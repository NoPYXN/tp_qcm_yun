// QuestionScreen.kt
package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.lemonade.ui.theme.AppTheme
class QcmScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QcmScreenContent()
                }
            }
        }
    }
}

@Composable
fun QcmScreenContent() {
    // État pour déterminer si les boutons doivent être affichés ou non
    var boutonsVisibles by remember { mutableStateOf(true) }
    // État pour suivre la réponse choisie
    var reponseChoisie by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Question",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Affichage des boutons uniquement si boutonsVisibles est vrai
        if (boutonsVisibles) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ResponseButton("Réponse 1") {
                        // Logique à exécuter lorsque le bouton est cliqué
                        reponseChoisie = 1
                        boutonsVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    ResponseButton("Réponse 2") {
                        // Logique à exécuter lorsque le bouton est cliqué
                        reponseChoisie = 2
                        boutonsVisibles = false
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ResponseButton("Réponse 3") {
                        // Logique à exécuter lorsque le bouton est cliqué
                        reponseChoisie = 3
                        boutonsVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    ResponseButton("Réponse 4") {
                        // Logique à exécuter lorsque le bouton est cliqué
                        reponseChoisie = 4
                        boutonsVisibles = false
                    }
                }
            }
        } else {
            // Affichage du texte en fonction de la réponse choisie
            val texteReponse = if (reponseChoisie == 2) "Bonne réponse" else "Mauvaise réponse"
            Text(text = texteReponse)
        }
    }
}

@Composable
fun ResponseButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .background(MaterialTheme.colorScheme.primary) // Couleur de fond
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    AppTheme {
        QcmScreenContent()
    }
}