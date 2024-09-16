package com.biprangshu.cinesuggest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.biprangshu.cinesuggest.domain.usecases.AppEntryUseCases
import com.biprangshu.cinesuggest.navigation.NavGraph
import com.biprangshu.cinesuggest.navigation.Route
import com.biprangshu.cinesuggest.onboarding.OnBoardingScreen
import com.biprangshu.cinesuggest.onboarding.OnBoardingViewModel
import com.biprangshu.cinesuggest.ui.theme.CineSuggestTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            viewModel.splashCondition
        }
        setContent {
            CineSuggestTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                    val startDestination= viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}
