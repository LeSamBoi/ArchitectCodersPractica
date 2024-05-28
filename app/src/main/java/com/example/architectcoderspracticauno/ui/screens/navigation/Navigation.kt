package com.example.architectcoderspracticauno.ui.screens.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.architectcoderspracticauno.ui.screens.detail.DetailScreen
import com.example.architectcoderspracticauno.ui.screens.detail.DetailViewModel
import com.example.architectcoderspracticauno.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val animationDuration = 800

    NavHost(
        navController = navController,
        startDestination = Home
    ){
        composable<Home>(
            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(animationDuration)) },
            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(animationDuration)) },
        ){
            HomeScreen( onWizardClicked = { wizard ->
                navController.navigate(Detail(wizard.id))
            })
        }
        composable<Detail>(
            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(animationDuration)) },
            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(animationDuration)) },
        ){backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            DetailScreen(
                viewModel { DetailViewModel(detail.wizardId) },
                onBack = { navController.popBackStack() }
            )
        }
    }
}