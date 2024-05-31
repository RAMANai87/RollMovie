package com.raman.RollMovie.model.repo.user

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.raman.RollMovie.model.data.HttpResult
import com.raman.RollMovie.utils.remote.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firebase: FirebaseAuth,
    private val sharedPreferences: SharedPreferences
) : UserRepository {
    override val currentUser: FirebaseUser?
        get() = firebase.currentUser

    override suspend fun signUpUser(
        name: String,
        email: String,
        password: String
    ): HttpResult<FirebaseUser> {

        return try {
            val result = firebase.createUserWithEmailAndPassword(email, password).await()
            saveUserInfo(name, email)
            result?.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )?.await()
            HttpResult.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            HttpResult.Failure(e)
        }

    }

    override suspend fun signInUser(email: String, password: String): HttpResult<FirebaseUser> {

        return try {
            val result = firebase.signInWithEmailAndPassword(email, password).await()
            HttpResult.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            HttpResult.Failure(e)
        }

    }

    override fun signOut() {
        firebase.signOut()
    }

    override fun saveUserInfo(username: String, email: String) {

        sharedPreferences.edit().putString("username", username).apply()
        sharedPreferences.edit().putString("email", email).apply()

    }

    override fun getUserInfo(): Pair<String, String> {

        val username = sharedPreferences.getString("username", "not found")!!
        val email = sharedPreferences.getString("email", "not found")!!

        return Pair(username, email)
    }

    override fun saveUserLocation(location: String) {
        sharedPreferences.edit().putString("userLocation", location).apply()
    }

    override fun getUserLocation(): String {
        return sharedPreferences.getString("userLocation", "not found")!!
    }


}