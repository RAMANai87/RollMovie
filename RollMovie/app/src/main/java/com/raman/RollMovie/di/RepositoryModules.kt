package com.raman.RollMovie.di

import com.raman.RollMovie.model.repo.movie.MovieRepository
import com.raman.RollMovie.model.repo.movie.MovieRepositoryImpl
import com.raman.RollMovie.model.repo.tv.TvShowRepository
import com.raman.RollMovie.model.repo.tv.TvShowRepositoryImpl
import com.raman.RollMovie.model.repo.user.UserRepository
import com.raman.RollMovie.model.repo.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl) :UserRepository

    @Binds
    @Singleton
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl) :MovieRepository

    @Binds
    @Singleton
    abstract fun bindTvShowRepository(tvShowRepositoryImpl: TvShowRepositoryImpl) :TvShowRepository

}