// QuestionScreen.kt
package com.example.lemonade

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.properties.Delegates

@SuppressLint("SuspiciousIndentation")
@Composable
fun QcmScreenContent(numero: Int? = 1, navController: NavController) {

    var boutonsVisibles by remember { mutableStateOf(true) }
    var reponseChoisie by remember { mutableStateOf(0) }
    var showConfetti by remember { mutableStateOf(false) }
    Bouton_Retour_Accueil_Icon_Fleche("1", onElementClick = {navController.navigate(Screen.AccueilScreen.itineraire)})
    lateinit var valQuestion: String
    var valHauteurImage by Delegates.notNull<Int>()
    var valLargeurImage by Delegates.notNull<Int>()

    lateinit var valReponse1: String
    lateinit var valReponse2: String
    lateinit var valReponse3: String
    lateinit var valReponse4: String
    lateinit var valimage1: String
    lateinit var valimage2: String
    lateinit var valimage3: String
    lateinit var valimage4: String

    if (numero == 1) {
        valHauteurImage = 84
        valLargeurImage = 149
        valQuestion = "Qui est actuellement le vainqueur de Mister Olympia (catégorie Classique Physique) depuis 4 ans d'affilé ?"
        valReponse1 = "Chris Bumstead"
        valimage1 = "chrisbumstead"
        valReponse2 = "Ramon Rocha Queiroz"
        valimage2 = "ramonrochaqueiroz"
        valReponse3 = "Stephane Matala"
        valimage3 = "stephanematala"
        valReponse4 = "Nickolas Venuti"
        valimage4 = "nickolasvenuti"
    }
    if (numero == 2) {
        valHauteurImage = 120
        valLargeurImage = 120
        valQuestion = "Lesquels de ces artistes a la musique la plus écoutée ?"
        valReponse1 = "XXX Tentacion"
        valimage1 = "xxxtentacion"
        valReponse2 = "Scarlxrd"
        valimage2 = "scarlxrd"
        valReponse3 = "So la lune"
        valimage3 = "solalune"
        valReponse4 = "Laylow"
        valimage4 = "laylow"
    }
    if (numero == 3) {
        valHauteurImage = 84
        valLargeurImage = 149
        valQuestion = " Quel est la paire de chaussure la plus chère parmit les quatres ?"
        valReponse1 = "Air Jordan 1 Retro High Off-White Chicago"
        valimage1 = "airjordan1chicago"
        valReponse2 = "Baskets en cuir rhyton Gucci"
        valimage2 = "basketsrhytongucci"
        valReponse3 = "Balmain Unicorn"
        valimage3 = "balmainunicorn"
        valReponse4 = "Nike SB Dunk Low Travis Scott"
        valimage4 = "dunklowtravis"
    }

    val reponses = listOf(
        Response("$valReponse1","$valimage1",valHauteurImage, valLargeurImage, 1),
        Response("$valReponse2","$valimage2",valHauteurImage, valLargeurImage, 2),
        Response("$valReponse3","$valimage3",valHauteurImage, valLargeurImage, 3),
        Response("$valReponse4","$valimage4",valHauteurImage, valLargeurImage, 4)
    ).shuffled()

    if (boutonsVisibles) {
        //Affichage de la question
        Question_Affichage("$valQuestion")

        //Affichage des boutons de réponse sous forme de carré
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Response_Button(
                    reponses[0],
                    reponses[0].image,
                    reponses[0].hauteur,
                    reponses[0].largeur
                ) {
                    reponseChoisie = reponses[0].id
                    boutonsVisibles = false
                }
                Spacer(modifier = Modifier.width(16.dp))
                Response_Button(
                    reponses[1],
                    reponses[1].image,
                    reponses[1].hauteur,
                    reponses[1].largeur
                ) {
                    reponseChoisie = reponses[1].id
                    boutonsVisibles = false
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Response_Button(
                    reponses[2],
                    reponses[2].image,
                    reponses[2].hauteur,
                    reponses[2].largeur
                ) {
                    reponseChoisie = reponses[2].id
                    boutonsVisibles = false
                }
                Spacer(modifier = Modifier.width(16.dp))
                Response_Button(
                    reponses[3],
                    reponses[3].image,
                    reponses[3].hauteur,
                    reponses[3].largeur
                ) {
                    reponseChoisie = reponses[3].id
                    boutonsVisibles = false
                }
            }
        }
    } else {
        if (reponseChoisie == 1) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .confetti(showConfetti = true)
            ) {
                Question_Affichage("$valQuestion")

                Bonne_Reponse_Affichage()

                Bouton_Retour_Accueil_Bonne_Reponse(
                    "1",
                    onElementClick = { navController.navigate(Screen.AccueilScreen.itineraire) }
                )
            }

        }
        if (reponseChoisie != 1) {
            Question_Affichage("$valQuestion")

            Mauvaise_Reponse_Affichage()

            Bouton_Retour() {
                boutonsVisibles = true
            }
        }
    }
}

data class Response(val text: String, val image : String, val hauteur : Int, val largeur : Int, val id: Int)

@Composable
fun Response_Button(response: Response, image: String, hauteur : Int, largeur : Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(200.dp)
            .width(175.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Image
            Image(
                painter = painterResource(id = Lien_Image(image)),
                contentDescription = "image de réponse",
                modifier = Modifier
                    .height(hauteur.dp)
                    .width(largeur.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.background)
            )
            Text(
                text = response.text
            )
        }
    }
}

@Composable
fun Lien_Image(imageName: String): Int {
    return LocalContext.current.resources.getIdentifier(
        imageName,
        "drawable",
        LocalContext.current.packageName
    )
}

@Composable
fun Bouton_Retour_Accueil_Icon_Fleche(numero : String, onElementClick : (String)->Unit) {
    IconButton(
        onClick = { onElementClick(numero) },
        modifier = Modifier
            .padding(top = 40.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Retour à l'accueil")
    }
}
@Composable
fun Bouton_Retour_Accueil_Bonne_Reponse(numero : String, onElementClick : (String)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = { onElementClick(numero) },
            modifier = Modifier
                .height(50.dp)
                .width(300.dp)
                .paddingFromBaseline(bottom = 10.dp)
        ) {
            Text(" Retourner à l'accueil")
        }
    }
}

@Composable
fun Bouton_Retour(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = onClick,
            modifier = Modifier
                .height(50.dp)
                .width(300.dp)
                .paddingFromBaseline(bottom = 10.dp)
        ) {
            Text("Retour")
        }
    }
}

@Composable
fun Question_Affichage(Question : String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 130.dp, start = 8.dp, end = 8.dp),
    ) {
        Text(
            text = Question,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun Bonne_Reponse_Affichage(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bonne Réponse",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Green,
            textAlign = TextAlign.Center,
        )
    }
}
@Composable
fun Mauvaise_Reponse_Affichage(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mauvaise Réponse",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }
}
