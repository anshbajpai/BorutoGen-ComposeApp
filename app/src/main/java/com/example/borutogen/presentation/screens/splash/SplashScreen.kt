package com.example.borutogen.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.borutogen.R
import com.example.borutogen.navigation.Screen
import com.example.borutogen.ui.theme.Purple500
import com.example.borutogen.ui.theme.Purple700

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

    val rotate = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navHostController.popBackStack()
        if(onBoardingCompleted){
            navHostController.navigate(Screen.Home.route)
        }
        else{
            navHostController.navigate(Screen.Welcome.route)
        }
    }

}

@Composable
fun Splash(rotate: Float) {
    if(isSystemInDarkTheme()){
        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = rotate),
                painter = painterResource(
                id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo) )
        }
    }
    else{
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = rotate),
                painter = painterResource(
                id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo) )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(0f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    Splash(0f)
}