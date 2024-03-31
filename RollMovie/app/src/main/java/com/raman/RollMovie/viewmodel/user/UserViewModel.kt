package com.raman.RollMovie.viewmodel.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.raman.RollMovie.model.data.HttpResult
import com.raman.RollMovie.model.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) :ViewModel(){

    private val _signUpFlow = MutableStateFlow<HttpResult<FirebaseUser>?>(null)
    val signUpFlow :StateFlow<HttpResult<FirebaseUser>?> = _signUpFlow

    private val _signInFlow = MutableStateFlow<HttpResult<FirebaseUser>?>(null)
    val signInFlow : StateFlow<HttpResult<FirebaseUser>?> = _signInFlow

    val currentUser :FirebaseUser?
        get() = userRepository.currentUser

    init {

        if (userRepository.currentUser != null) {
            _signInFlow.value = HttpResult.Success(userRepository.currentUser!!)
        }

    }

    fun signUp(name :String, email :String, password :String) {
        viewModelScope.launch {
            _signUpFlow.value = HttpResult.Loading
            val result = userRepository.signUpUser(name, email, password)
            _signUpFlow.value = result
        }
    }

    fun signIn(email :String, password: String) {
        viewModelScope.launch {
            _signInFlow.value = HttpResult.Loading
            val result = userRepository.signInUser(email, password)
            _signInFlow.value = result
        }
    }

    fun signOut() {
        userRepository.signOut()
        _signUpFlow.value = null
        _signInFlow.value = null
    }

}