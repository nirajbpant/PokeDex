package com.example.pokedex.domain.usecases

import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.data.models.Resource
import com.example.pokedex.domain.repository.IPokemonRepository
import javax.inject.Inject

class GetPokemons @Inject constructor(
    private val pokemonRepository: IPokemonRepository
) {

    suspend operator fun invoke() : Resource<PokemonResponse>{
        return pokemonRepository.getPokemons()
    }
}