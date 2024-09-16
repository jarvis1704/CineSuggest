package com.biprangshu.cinesuggest.navigation

sealed class Route(val Route: String){
    object OnBoardingScreen: Route("onBoardingScreen")
    object AppStartNavigation: Route("appstartnavigation")
    object MainNavigation: Route("mainnavigation")
    object HomeScreen: Route("homeScreen")
    object DetailsScreen: Route("detailsScreen")
    object SearchScreen: Route("searchScreen")
}