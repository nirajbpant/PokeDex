package com.example.pokedex.data

import com.example.pokedex.data.api.PokemonAPI
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonService @Inject constructor(
    private val retrofit: Retrofit
) {

    private val pokemonService by lazy { retrofit.create(PokemonAPI::class.java) }

    suspend fun getPokemons(limit: Int) = pokemonService.getPokemons(limit)
}