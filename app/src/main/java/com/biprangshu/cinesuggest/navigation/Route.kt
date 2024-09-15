package com.biprangshu.cinesuggest.navigation

sealed class Route(val Route: String){
    object OnBoardingScreen: Route("onBoardingScreen")
    object AppStartNavigation: Route("appstartnavigation")
}