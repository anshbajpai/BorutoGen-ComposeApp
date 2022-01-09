package com.example.borutogen

import android.util.Log
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borutogen.domain.use_cases.UseCases
import com.example.borutogen.presentation.screens.splash.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    private val _isCheck = MutableStateFlow(false)
    val isCheck = _isLoading.asStateFlow()
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.readOnBoardingUseCase().collect {
                _isLoading.value = it
                _isCheck.value = true
//                Log.d("Heyy", "${it}")
            }
        }
    }

}