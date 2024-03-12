package com.raman.RollMovie.ui.features.user.signUp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raman.RollMovie.model.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) :ViewModel(){

    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")



}