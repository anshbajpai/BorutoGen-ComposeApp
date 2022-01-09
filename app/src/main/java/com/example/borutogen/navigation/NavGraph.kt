package com.example.borutogen.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.borutogen.presentation.details.DetailsScreen
import com.example.borutogen.presentation.screens.home.HomeScreen
import com.example.borutogen.presentation.screens.search.SearchScreen
import com.example.borutogen.presentation.screens.splash.SplashScreen
import com.example.borutogen.presentation.screens.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController, navBool: Boolean) {
    NavHost(
        navController = navController,
            startDestination = Screen.Splash.route ,
    ){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreen(navController)
        }
        composable(
            route = Screen.Welcome.route
        ){
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(
                navController
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("heroId"){
                type = NavType.IntType
            })
        ){
            DetailsScreen(navController = navController)
        }
        composable(
            route = Screen.Search.route
        ){
            SearchScreen(navController)
        }
    }
}