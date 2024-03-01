package com.example.pokedex.domain.repository

import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.data.models.Resource

interface IPokemonRepository {

    suspend fun getPokemons(): Resource<PokemonResponse>

}