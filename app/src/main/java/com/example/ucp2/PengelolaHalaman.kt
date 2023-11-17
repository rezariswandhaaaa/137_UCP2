package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.ui.layout.HalamanHome

enum class PengelolaHalaman {
    Home,
    Fomulir,
    Summary
}


@Composable
fun SkripsiApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController =rememberNavController()
){
    Scaffold {rezaRiswandha ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(rezaRiswandha)
        ){


        }
    }

}