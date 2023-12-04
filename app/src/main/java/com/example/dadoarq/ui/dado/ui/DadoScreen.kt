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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DadoScreen(viewModel: DadoViewModel = viewModel()){
    val dadoUiState by viewModel.uiState.collectAsState()
    Box (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.Yellow)){
        dadoLoco({ viewModel.onChangeDado() },Modifier.align(Alignment.Center),dadoUiState.num,dadoUiState.numReal,dadoUiState.aux)
    }
}

@Composable
fun dadoLoco(onChangeDado: () -> Unit, modifier: Modifier,numDado:Int,numReal:Int,numVeces:Int) {
    Column(modifier = modifier
        .background(Color.Cyan)
        .padding(2.dp)) {
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
            onClick = onChangeDado,
            modifier= Modifier.align(Alignment.CenterHorizontally)
        ){
            Text(text = "Dado loco")
        }
        Spacer(Modifier.padding(2.dp))
        Text(
            text = "Veces tirada: $numVeces",
            modifier= Modifier.align(Alignment.End),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
    }
}
