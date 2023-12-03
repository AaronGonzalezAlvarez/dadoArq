package com.example.dadoarq.ui.dado.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dadoarq.R

@Composable
fun DadoScreen(viewModel: DadoViewModel){
    Box (modifier =Modifier.fillMaxSize().padding(16.dp).background(Color.Yellow)){
        dadoLoco(viewModel,Modifier.align(Alignment.Center))
    }
}

@Composable
fun dadoLoco(viewModel: DadoViewModel, modifier: Modifier) {
    val numDado:Int by viewModel.num.observeAsState(initial = R.drawable.dice_1)
    val numReal:Int by viewModel.numReal.observeAsState(initial = 1)
    Column(modifier = modifier.background(Color.Cyan).padding(2.dp)) {
        Image(
            painter = painterResource(numDado),
            contentDescription = null
        )
        Spacer(Modifier.padding(2.dp))
        Text(
            text = "Número: $numReal",
            modifier= Modifier.align(Alignment.End),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(Modifier.padding(2.dp))
        Button(
            onClick = {viewModel.onChangeDado()},
            modifier= Modifier.align(Alignment.CenterHorizontally)
        ){
            Text(text = "Dado loco")
        }
    }
}
