package com.example.pokedex.presentation.pokemon_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.data.models.Resource
import com.example.pokedex.domain.usecases.models.PokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases
): ViewModel() {

    private val _state = MutableStateFlow<Resource<PokemonResponse>>(Resource.Initial())
    val state: StateFlow<Resource<PokemonResponse>> = _state


    init {
        viewModelScope.launch {
            _state.value = Resource.Loading()
            var result = pokemonUseCases.getPokemons()
            when(result){
                is Resource.Success ->{
                    _state.value = result
                }
                is Resource.Error ->{
                    _state.value = result
                }
                else -> {}
            }
        }
    }
}