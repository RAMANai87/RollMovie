package com.raman.RollMovie.ui.features.user.signIn

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raman.RollMovie.model.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userRepository: UserRepository
) :ViewModel(){

    val email = mutableStateOf("")
    val password = mutableStateOf("")



}