package com.biprangshu.cinesuggest.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.biprangshu.cinesuggest.details.DetailsScreen
import com.biprangshu.cinesuggest.ui.theme.CineSuggestTheme
import com.biprangshu.cinesuggest.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
            CineSuggestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.rout
                    ) {
                        composable(Screen.Home.rout) {
                            HomeScreen(navController)
                        }

                        composable(
                            Screen.Details.rout + "/{movieId}",
                            arguments = listOf(
                                navArgument("movieId") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            DetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color){
    val systemUiController = com.google.accompanist.systemuicontroller.rememberSystemUiController()
    LaunchedEffect(key1=color) {
        systemUiController.setSystemBarsColor(color)
    }
}
