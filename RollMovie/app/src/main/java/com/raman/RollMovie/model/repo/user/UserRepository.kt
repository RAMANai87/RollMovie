package com.raman.RollMovie.model.repo.user

import com.google.firebase.auth.FirebaseUser
import com.raman.RollMovie.model.data.HttpResult

interface UserRepository {

     val currentUser :FirebaseUser?

     suspend fun signUpUser(name :String, email: String, password: String) :HttpResult<FirebaseUser>
     suspend fun signInUser(email :String, password :String) :HttpResult<FirebaseUser>

     fun signOut()

     fun saveUserInfo(username :String, email: String)
     fun getUserInfo() :Pair<String, String>

     fun saveUserLocation(location :String)
     fun getUserLocation() :String

}