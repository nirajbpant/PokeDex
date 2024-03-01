package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.domain.repository.IPokemonRepository
import com.example.pokedex.domain.usecases.GetPokemons
import com.example.pokedex.domain.usecases.models.PokemonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun providePokemonUseCases(repository: IPokemonRepository, context: Context) : PokemonUseCases {
        return PokemonUseCases(
            getPokemons = GetPokemons(repository)
        )
    }
}