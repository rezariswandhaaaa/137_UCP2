package com.example.ucp2.ui.layout

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.SkripsiUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SkripsiViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(SkripsiUIState())
    val stateUI: StateFlow<SkripsiUIState> = _stateUI.asStateFlow()

    fun setContact(list: MutableList<String>){
        _stateUI.update {
                stateSaatIni -> stateSaatIni.copy(
            nama = list[0],
            nim = list[1],
            konsentrasi = list[2],
            judul = list [3]
        )
        }
    }



    fun setDosen(dosenPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = dosenPilihan)
        }
    }

    fun resetOrder(){
        _stateUI.value = SkripsiUIState()
    }


}