package com.raman.RollMovie.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.raman.RollMovie.model.api.ApiService
import com.raman.RollMovie.model.db.FavoriteDao
import com.raman.RollMovie.model.db.MovieDao
import com.raman.RollMovie.model.db.RollMovieDatabase
import com.raman.RollMovie.model.repo.movie.MovieRemoteDataSource
import com.raman.RollMovie.utils.createApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return createApiService()
    }

    @Provides
    @Singleton
    fun provideFirebase(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideMovieDao( db :RollMovieDatabase ): MovieDao {
        return db.movieDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteDao( db :RollMovieDatabase ): FavoriteDao {
        return db.favoriteDao()
    }

    @Provides
    @Singleton
    fun provideRemoteMovieDataSource( apiService: ApiService ): MovieRemoteDataSource{
        return MovieRemoteDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideAppDatabase( @ApplicationContext context: Context ) :RollMovieDatabase {
        return Room.databaseBuilder(
            context,
            RollMovieDatabase::class.java,
            "app_database.db"
        ).build()
    }

}