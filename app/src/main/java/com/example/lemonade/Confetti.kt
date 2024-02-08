package com.example.lemonade

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.onSizeChanged
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.random.Random

@Immutable
private data class ConfettiItem(
    val size: Float,
    val speed: Float,
    val color: Color,
    val rotation: Float,
) {
    val sizeState = Size(size, size)
}

fun Modifier.confetti(
    showConfetti: Boolean,
    durationMillis: Int = 6000,
    itemsPerFrame: IntRange = 2..5,
    colors: List<Color> = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
    ),
    minSize: Float = 15f,
    maxSize: Float = 25f,
    minSpeed: Float = 7f,
    maxSpeed: Float = 10f,
    onCompleted: () -> Unit = {}
) = composed {
    val confettiPaint = remember { Paint() }
    val confetti = remember { mutableStateMapOf<ConfettiItem, Offset>() }
    var canvasWidth by remember { mutableStateOf(0f) }
    var canvasHeight by remember { mutableStateOf(0f) }

    fun addConfettiItem() {
        val r = Random.nextFloat()
        val size = r * (maxSize - minSize) + minSize
        val item = ConfettiItem(
            size = size,
            speed = r * (maxSpeed - minSpeed) + minSpeed,
            color = colors.random(Random),
            rotation = r * 360f
        )
        confetti[item] = Offset(
            x = r * canvasWidth,
            y = -size,
        )
    }

    LaunchedEffect(showConfetti) {
        if (!showConfetti) return@LaunchedEffect
        while (canvasHeight == 0f) yield()
        val endTime = withFrameNanos { it } + durationMillis * 1_000_000L
        launch {
            while (isActive && showConfetti) {
                val currentTime = withFrameNanos { it }
                if (currentTime < endTime) {
                    repeat(itemsPerFrame.random()) {
                        addConfettiItem()
                    }
                }
                val frameTimeNanos = withFrameNanos { it }
                val delayMillis = ((frameTimeNanos - currentTime) / 1_000_000).coerceAtLeast(0)
                delay(delayMillis)
            }
        }
        launch {
            while (isActive) {
                withFrameNanos {
                    confetti.forEach { (item, offset) ->
                        if (offset.y - item.size > canvasHeight) {
                            confetti.remove(item)
                        } else {
                            confetti[item] = offset.copy(y = offset.y + item.speed)
                        }
                    }
                }
                if (confetti.isEmpty()) {
                    onCompleted()
                    break
                }
            }
        }
    }

    onSizeChanged { size ->
        canvasWidth = size.width.toFloat()
        canvasHeight = size.height.toFloat()
    }.drawWithContent {
        drawContent()
        confetti.forEach { (confetti, offset) ->
            confettiPaint.color = confetti.color
            rotate(
                degrees = confetti.rotation,
                pivot = Offset(offset.x + confetti.size / 2, offset.y + confetti.size / 2)
            ) {
                drawCircle(
                    color = confetti.color,
                    center = offset,
                    radius = confetti.size / 2,
                    style = Fill
                )
            }
        }
    }
}
