package com.raman.RollMovie.ui.features.user.signUp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() :ViewModel(){

    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")



}