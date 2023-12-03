package com.example.dadoarq.ui.dado.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dadoarq.R

class DadoViewModel : ViewModel() {

    private val _num = MutableLiveData<Int>()
    val num: LiveData<Int> = _num

    private val _numReal = MutableLiveData<Int>()
    val numReal: LiveData<Int> = _numReal

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
        _num.value = drawableResource
         _numReal.value = dadoValue
    }

    private fun lanzarDado(): Int = (1..6).random()
}