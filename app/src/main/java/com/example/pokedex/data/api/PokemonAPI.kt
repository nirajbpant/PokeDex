package com.example.pokedex.data.api

import com.example.pokedex.data.models.PokemonResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI {

    @GET("/pokemon")
    suspend fun getPokemons(
        @Query("limit") limit : Int,
    ): Response<PokemonResponse>

    @GET("/pokemon/")
    suspend fun getPokemonDetails(
    ): ResponseBody
}