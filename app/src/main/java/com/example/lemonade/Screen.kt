package com.example.lemonade

sealed class Screen (val itineraire : String){
    object Accueil_Screen : Screen("accueil_screen")
    object QcmScreen : Screen("qcm_screen")
}