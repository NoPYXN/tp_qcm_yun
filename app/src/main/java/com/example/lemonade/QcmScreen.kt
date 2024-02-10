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
    Bouton_Retour_Accueil_Icon_Fleche("1", onElementClick = {navController.navigate(Screen.Accueil_Screen.itineraire)})
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
    lateinit var valReponseDescription1: String
    lateinit var valReponseDescription2: String
    lateinit var valReponseDescription3: String
    lateinit var valReponseDescription4: String

    if (numero == 1) {
        valHauteurImage = 85
        valLargeurImage = 149

        valQuestion = "Qui est actuellement le vainqueur de Mister Olympia (catégorie Classique Physique) depuis 4 ans d'affilée ?"
        valReponse1 = "Chris Bumstead"
        valimage1 = "chrisbumstead"
        valReponseDescription1 = "Et oui, Chris Bumstead est le champion du monde depuis 4 ans !"

        valReponse2 = "Ramon Rocha Queiroz"
        valimage2 = "ramonrochaqueiroz"
        valReponseDescription2 = "Plus connu sous le nom de Ramon Dino, il est arrivé 2ème à Mister Olympia 2022. Il est le plus grand challenger de Chris Bumstead."

        valReponse3 = "Stephane Matala"
        valimage3 = "stephanematala"
        valReponseDescription3 = "Stéphane Matala est un Français. Il est nouveau dans le domaine et il est bien parti pour devenir un grand champion."

        valReponse4 = "Nickolas Venuti"
        valimage4 = "nickolasvenuti"
        valReponseDescription4 = "Nicholas Venuti est seulement un influenceur mais ne fait pas de grandes compétitions."
    }
    if (numero == 2) {
        valHauteurImage = 120
        valLargeurImage = 120
        valQuestion = "Parmi ces artistes, qui a la musique la plus écoutée ?"

        valReponse1 = "XXX Tentacion"
        valimage1 = "xxxtentacion"
        valReponseDescription1 = "XXXTentacion est largement au-dessus des autres avec son titre \"SAD!\" qui compte plus de 2 milliards 150 millions d'écoutes."

        valReponse2 = "Scarlxrd"
        valimage2 = "scarlxrd"
        valReponseDescription2 = "Scarlxrd n'a pas la musique la plus écoutée des quatre, mais il a quand même réussi à atteindre les 115 millions d'écoutes avec sa chanson \"Heart Attack\"."

        valReponse3 = "So la lune"
        valimage3 = "solalune"
        valReponseDescription3 = "So La Lune a le son le moins écouté des quatre mais fait partie des plus originaux, ce qui divise les avis. Cependant, il a tout de même son titre \"Rodé\" qui a 22 millions d'écoutes."

        valReponse4 = "Laylow"
        valimage4 = "laylow"
        valReponseDescription4 = "Laylow a atteint les 55 millions d'écoutes avec \"SPECIAL\", en featuring avec Nekfeu, ce qui est très honorable pour un Français."
    }
    if (numero == 3) {
        valHauteurImage = 84
        valLargeurImage = 149
        valQuestion = "Quelle est la paire de chaussures la plus chère parmi les quatre ?"

        valReponse1 = "Air Jordan 1 Retro High Off-White Chicago"
        valimage1 = "airjordan1chicago"
        valReponseDescription1 = "Et oui, la Air Jordan 1 Chicago est la plus chère des quatre, au prix de 10 600 euros."

        valReponse2 = "Baskets en cuir rhyton Gucci"
        valimage2 = "basketsrhytongucci"
        valReponseDescription2 = "Même si c'est une chaussure Gucci, elle n'est pas si chère que ça car elles sont au prix de 860 euros."

        valReponse3 = "Balmain Unicorn"
        valimage3 = "balmainunicorn"
        valReponseDescription3 = "Les Balmain Unicorn sont celles qui ont l'aspect le plus particulier, mais leur prix n'est pas le plus élevé, avec une valeur de 995 euros."

        valReponse4 = "Nike SB Dunk Low Travis Scott"
        valimage4 = "dunklowtravis"
        valReponseDescription4 = "Les Dunk Low de Travis sont au prix de 2 100 euros et sont les deuxièmes plus chères de cette liste."
    }

    val reponses = listOf(
        Response(valReponse1, valimage1, valHauteurImage, valLargeurImage,1),
        Response(valReponse2, valimage2, valHauteurImage, valLargeurImage,2),
        Response(valReponse3, valimage3, valHauteurImage, valLargeurImage,3),
        Response(valReponse4, valimage4, valHauteurImage, valLargeurImage,4)
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

                Bonne_Reponse_Affichage("$valReponseDescription1")

                Bouton_Retour_Accueil_Bonne_Reponse(
                    "1",
                    onElementClick = { navController.navigate(Screen.Accueil_Screen.itineraire) }
                )
            }

        }
        else if (reponseChoisie == 2) {
            Question_Affichage("$valQuestion")

            Mauvaise_Reponse_Affichage("$valReponseDescription2")

            Bouton_Retour() {
                boutonsVisibles = true
            }
        }
        else if (reponseChoisie == 3) {
            Question_Affichage("$valQuestion")

            Mauvaise_Reponse_Affichage("$valReponseDescription3")

            Bouton_Retour() {
                boutonsVisibles = true
            }
        }
        else if (reponseChoisie == 4) {
            Question_Affichage("$valQuestion")

            Mauvaise_Reponse_Affichage("$valReponseDescription4")

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
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = response.text,
                textAlign = TextAlign.Center
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
fun Bonne_Reponse_Affichage(ReponseDescription : String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
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
        Spacer(modifier = Modifier.height(30.dp))
        Explication_Resultat_Affichage(ReponseDescription)
    }
}
@Composable
fun Mauvaise_Reponse_Affichage(ReponseDescription : String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
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
        Spacer(modifier = Modifier.height(30.dp))
        Explication_Resultat_Affichage(ReponseDescription)
    }
}

@Composable
fun Explication_Resultat_Affichage(ReponseDescription : String) {
    Text(
        text = ReponseDescription,
        textAlign = TextAlign.Center,

    )
}
