package com.example.lemonade

sealed class Screen (val itineraire : String){
    object AccueilScreen : Screen("accueil_screen")
    object QcmScreen : Screen("qcm_screen")
}