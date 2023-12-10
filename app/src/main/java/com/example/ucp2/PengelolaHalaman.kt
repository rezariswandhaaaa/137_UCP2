@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.ui.layout.HalamanHome
import com.example.ucp2.ui.layout.SkripsiViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ucp2.data.SumberData.flavors
import com.example.ucp2.ui.layout.HalamanDua
import com.example.ucp2.ui.layout.HalamanSatu

enum class PengelolaHalaman {
    Home,
    Fomulir,
    Summary
}


@Composable
fun SkripsiApp(
    viewModel: SkripsiViewModel = viewModel(),
    navController: NavHostController =rememberNavController()
){
    Scaffold {rezaRiswandha ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(rezaRiswandha)
        ){
            composable(route = PengelolaHalaman.Home.name){
                HalamanHome(onNextButtonClicked = {navController.navigate(PengelolaHalaman.Fomulir.name)})
            }

            composable(route = PengelolaHalaman.Fomulir.name){
                val context = LocalContext.current
                val context1 = LocalContext.current
                HalamanSatu(
                    pilihanDosen = flavors.map{ id -> context.resources.getString(id) },
                    pilihanDosen1 = flavors.map{ id -> context1.resources.getString(id)},
                    onSelectionChanged = {viewModel.setDosen(it)},
                    onSelectionChanged1 = {viewModel.setDosen1(it)},
                    onSubmitButtonClicked = {
                        viewModel.setFomulir(it)
                        navController.navigate(PengelolaHalaman.Summary.name)
                    })
            }
            composable(route = PengelolaHalaman.Summary.name){
                HalamanDua(skripsiUIState = uiState, onBackButtonClicked = {navController.navigate(PengelolaHalaman.Fomulir.name)})
            }
        }

    }
}