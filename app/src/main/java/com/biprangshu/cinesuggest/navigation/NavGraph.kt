package com.biprangshu.cinesuggest.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.biprangshu.cinesuggest.onboarding.OnBoardingScreen
import com.biprangshu.cinesuggest.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String,
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(route= Route.OnBoardingScreen.Route, startDestination = Route.OnBoardingScreen.Route){
            composable(
                route = Route.OnBoardingScreen.Route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
            }
        }
    }
}