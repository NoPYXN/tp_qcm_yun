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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Accueil_Screen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Ensemble_BoutonAccueil("1","QCM sur le bodybuilding", onElementClick = {numero ->
                navController.navigate(Screen.QcmScreen.itineraire + "/" + numero)
            })
            Ensemble_BoutonAccueil("2","QCM sur la musique", onElementClick = {numero ->
                navController.navigate(Screen.QcmScreen.itineraire + "/" + numero)
            })
            Ensemble_BoutonAccueil("3","QCM sur les chaussures",  onElementClick = {numero ->
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

@Composable
fun Ensemble_BoutonAccueil(
    numero: String,
    TextBouton: String,
    onElementClick: (String) -> Unit
) {
    var boutonsVisibles by remember { mutableStateOf(true) }
    var showDialog by remember { mutableStateOf(false) }

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
                    showDialog = true
                },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "Supprimer cet élément ?")
            },
            text = {
                Text(text = "Êtes-vous sûr de vouloir supprimer cet élément ?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        boutonsVisibles = !boutonsVisibles
                    }
                ) {
                    Text(text = "Oui")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Non")
                }
            }
        )
    }
}