package com.miempresa.laboratorio11b.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miempresa.laboratorio11b.model.PokemonResponse
import com.miempresa.laboratorio11b.viewmodel.PokemonViewModel

@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {
    val pokemones by viewModel.pokemon.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchPokemon()
    }

    Column {
        if (pokemones == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            PokemonItem(pokemones!!)
        }
    }
}


@Composable
fun PokemonItem(pokemon: PokemonResponse) {
    //val habilidad = pokemon.abilities.getOrNull(0)?.ability?.name
    //Agregamos nuevas variables
    //var pokemones by remember { mutableStateOf<PokemonResponse?>(null) }
    //var isLoading by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            /*Text(
                text = habilidad?: "No Pokemon found",
                style = TextStyle(fontSize = 14.sp)
            )*/
            Text(
                text = "Habilidades del Pokémon:",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )

            // Itera sobre las habilidades y muestra sus nombres
            for (ability in pokemon.abilities) {
                Text(
                    text = ability.ability.name,
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
    }
}
