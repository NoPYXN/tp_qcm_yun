package com.example.lemonade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.lemonade.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccueilScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EnsembleBoutonAccueil("1","QCM sur le bodybuilding", onElementClick = {numero ->
                navController.navigate(Screen.QcmScreen.itineraire + "/" + numero)
            })
            EnsembleBoutonAccueil("2","QCM sur la musique", onElementClick = {numero ->
                navController.navigate(Screen.QcmScreen.itineraire + "/" + numero)
            })
            EnsembleBoutonAccueil("3","QCM sur les chaussures",  onElementClick = {numero ->
                navController.navigate(Screen.QcmScreen.itineraire + "/" + numero)
            })
        }

        Text(
            text = "Liste des QCM",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(40.dp)
                .align(Alignment.TopCenter)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnsembleBoutonAccueil(
    numero: String,
    TextBouton : String,
    onElementClick : (String)->Unit){
    var boutonsVisibles by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (boutonsVisibles) {
            Button(
                onClick = { onElementClick(numero) },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = "$TextBouton")
            }
        }

        if (boutonsVisibles) {
            IconButton(
                onClick = {
                    boutonsVisibles = !boutonsVisibles
                },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}


@Preview
@Composable
fun PreviewAccueilScreen() {
    AppTheme() {
        //AccueilScreen()
    }
}