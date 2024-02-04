// QuestionScreen.kt
package com.example.lemonade

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController


@Composable
fun QcmScreenContent(numero: Int? = 1, navController: NavController) {
    //,navController: NavController
    var boutonsVisibles by remember { mutableStateOf(true) }
    var reponseChoisie by remember { mutableStateOf(0) }

    Bouton_Retour_Accueil("3", onElementClick = {navController.navigate(Screen.AccueilScreen.itineraire)})
    lateinit var valReponse1: String
    lateinit var valReponse2: String
    lateinit var valReponse3: String
    lateinit var valReponse4: String
    lateinit var valimage1: String
    lateinit var valimage2: String
    lateinit var valimage3: String
    lateinit var valimage4: String
    lateinit var valQuestion: String

    if (numero == 1) {
        valQuestion = "Qui est actuellement le vainqueur de Mister Olympia (catégorie Classique Physique) depuis 4 ans d'affilé ?"
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
        valQuestion = "Artiste de rap?"
        valReponse1 = "Chris Bumstead"
        valimage1 = "chrisbumstead"
        valReponse2 = "Réponse 2"
        valimage2 = "ramonrochaqueiroz"
        valReponse3 = "Réponse 3"
        valimage3 = "stephanematala"
        valReponse4 = "Réponse 4"
        valimage4 = "nickolasvenuti"
    }
    if (numero == 3) {
        valQuestion = " Quel est la paire de chaussure la plus chère parmit les quatres ?"
        valReponse1 = "Chris Bumstead"
        valimage1 = "chrisbumstead"
        valReponse2 = "Réponse 2"
        valimage2 = "ramonrochaqueiroz"
        valReponse3 = "Réponse 3"
        valimage3 = "stephanematala"
        valReponse4 = "Réponse 4"
        valimage4 = "nickolasvenuti"
    }


    val reponses = listOf(
        Response("$valReponse1","$valimage1" , 1),
        Response("$valReponse2","$valimage2", 2),
        Response("$valReponse3","$valimage3", 3),
        Response("$valReponse4","$valimage4", 4)
    ).shuffled()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$valQuestion",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (boutonsVisibles) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Response_Button(reponses[0],reponses[0].image) {
                        reponseChoisie = reponses[0].id
                        boutonsVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Response_Button(reponses[1],reponses[1].image) {
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
                    Response_Button(reponses[2],reponses[2].image) {
                        reponseChoisie = reponses[2].id
                        boutonsVisibles = false
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Response_Button(reponses[3],reponses[3].image) {
                        reponseChoisie = reponses[3].id
                        boutonsVisibles = false
                    }
                }
            }
        } else {
            if (reponseChoisie == 1) {
                Text("Bonne réponse")
                BoutonRetourAccueil_MauvaiseReponse("3", onElementClick = {navController.navigate(Screen.AccueilScreen.itineraire)})
            }
            if (reponseChoisie != 1) {
                Text("Mauvaise réponse")
                BoutonRetour() {
                    boutonsVisibles = true
                }
            }
        }
    }
}

data class Response(val text: String, val image : String, val id: Int)


@Composable
fun Response_Button(response: Response, image: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(250.dp)
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
                painter = painterResource(id = getDrawableResourceId(image)),
                contentDescription = "image de réponse",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
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
fun getDrawableResourceId(imageName: String): Int {
    return LocalContext.current.resources.getIdentifier(
        imageName,
        "drawable",
        LocalContext.current.packageName
    )
}

/*
@Composable
fun Response_Button(response: Response, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(175.dp)
            .width(175.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(text = response.text)
    }
}*/

@Composable
fun Bouton_Retour_Accueil(numero : String, onElementClick : (String)->Unit) {
    IconButton(
        onClick = {onElementClick(numero) },
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(horizontal = 8.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Retour à l'accueil")
    }
}
@Composable
fun BoutonRetourAccueil_MauvaiseReponse(numero : String, onElementClick : (String)->Unit) {
    Button(
        onClick = {onElementClick(numero) },
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
    ) {
        Text(" Retourner à l'accueil")
    }
}

@Composable
fun BoutonRetour(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text("Retour")
    }
}