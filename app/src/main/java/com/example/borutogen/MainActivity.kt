package com.example.borutogen

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.borutogen.navigation.SetupNavGraph
import com.example.borutogen.presentation.screens.splash.SplashViewModel
import com.example.borutogen.ui.theme.BorutoGenTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: FirstViewModel by viewModels()
    private var isCheck: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        var navScreenBool: Boolean = false
        super.onCreate(savedInstanceState)
//        installSplashScreen().apply {
//            this.setKeepVisibleCondition{
//                if(viewModel.isCheck.value){
//                    Log.d("New", "${viewModel.isLoading.value}")
//                    navScreenBool = viewModel.isLoading.value
//                    false
//                }
//                else {
//                    Log.d("New", "Check Value${viewModel.isCheck.value}")
//                    true
//                }
//
//
//            }
//        }
        setContent {
            BorutoGenTheme {
                Log.d("New", "Nav Value: $navScreenBool")
                navController = rememberNavController()
                    SetupNavGraph(navController = navController, navBool = navScreenBool)
               }
        }
    }
}

@Composable
private fun justGettingValue(){

}