package com.biprangshu.cinesuggest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.biprangshu.cinesuggest.domain.usecases.AppEntryUseCases
import com.biprangshu.cinesuggest.navigation.NavGraph
import com.biprangshu.cinesuggest.navigation.Route
import com.biprangshu.cinesuggest.onboarding.OnBoardingScreen
import com.biprangshu.cinesuggest.ui.theme.CineSuggestTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CineSuggestTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                    OnBoardingScreen()
                }
            }
        }
    }
}
