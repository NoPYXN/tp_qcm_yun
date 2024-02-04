package com.example.lemonade

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.AccueilScreen.itineraire){
        composable(route = Screen.AccueilScreen.itineraire){
            AccueilScreen(navController = navController)
        }
        composable(
            route = Screen.QcmScreen.itineraire + "/{numero}",
            arguments = listOf(
                navArgument("numero"){
                    type = NavType.IntType
                }
            )
            ){
            QcmScreenContent(numero = it.arguments?.getInt("numero") ?: 1, navController = navController)

            //,navController = navController
        }
    }
}