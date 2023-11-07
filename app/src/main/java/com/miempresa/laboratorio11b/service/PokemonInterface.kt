package com.miempresa.laboratorio11b.service

import com.miempresa.laboratorio11b.model.PokemonResponse
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon/1/")
    suspend fun getPokemon() : PokemonResponse
}