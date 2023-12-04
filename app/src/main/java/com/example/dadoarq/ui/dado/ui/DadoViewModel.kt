package com.example.dadoarq.ui.dado.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dadoarq.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DadoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DadoUiState())
    val uiState: StateFlow<DadoUiState> = _uiState.asStateFlow()

     fun onChangeDado() {
        val dadoValue = lanzarDado()
        val drawableResource = when (dadoValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
       /* _num.value = drawableResource
         _numReal.value = dadoValue*/
         _uiState.update { currentState -> currentState.copy(
            num=drawableResource,
             numReal = dadoValue
         ) }
    }

    private fun lanzarDado(): Int = (1..6).random()
}