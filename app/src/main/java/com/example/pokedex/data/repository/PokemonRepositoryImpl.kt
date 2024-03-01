package com.example.pokedex.data.repository
import com.example.pokedex.data.PokemonService
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.data.models.Resource
import com.example.pokedex.domain.repository.IPokemonRepository
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonService: PokemonService
) : IPokemonRepository {

    override suspend fun getPokemons(): Resource<PokemonResponse> {
        return try {
            val response = pokemonService.getPokemons(20)
            responseToResult(response)
        } catch (e: HttpException) {
            Resource.Error("HTTP Error: ${e.code()}")
        } catch (e: IOException) {
            Resource.Error("Network Error: ${e.message}")
        } catch (e: Exception) {
            Resource.Error("An error occurred: ${e.message}")
        }
    }

    private fun responseToResult(response: Response<PokemonResponse>): Resource<PokemonResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}