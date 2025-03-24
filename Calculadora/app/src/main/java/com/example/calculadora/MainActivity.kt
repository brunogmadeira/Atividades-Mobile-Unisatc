package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraView();
        }
    }
}


//fun calculo(funcao : String, valor1: Int, valor2: Int): Int {
//    var valor = 0;
//    if(funcao == "soma"){
//        valor = valor1 + valor2;
//    }else if(funcao == "mult"){
//        valor = valor1 * valor2;
//    }else if(funcao == "divd"){
//        valor = valor1/valor2;
//    }else if(funcao == "sub"){
//        valor = valor1 - valor2;
//    }
//    return valor;
//}
//
//val listaValores = mutableListOf<Int>()
//
//fun variaveis(valor: Int): List<Int> {
//    listaValores.add(valor)
//    return listaValores
//}

@Composable
fun CalculadoraView (){
        Column (
            modifier = Modifier.fillMaxSize().background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            visor()
            button()
        }
    }


@Composable
fun visor(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()){
        Text("0",
            style = TextStyle(
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight(weight = 100),
                fontStyle = FontStyle(value = 40)
            )
        )

    }
}

@Composable
fun button(){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Button(onClick = {}) {
                Text(text = "7")
            }
            Button(onClick = {}) {
                Text(text = "4")
            }
            Button(onClick = {}) {
                Text(text = "1")
            }
            Button(onClick = {}) {
                Text(text = "C")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text(text = "8")
            }
            Button(onClick = {}) {
                Text(text = "5")
            }
            Button(onClick = {}) {
                Text(text = "2")
            }
            Button(onClick = {}) {
                Text(text = "0")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text(text = "9")
            }
            Button(onClick = {}) {
                Text(text = "6")
            }
            Button(onClick = {}) {
                Text(text = "3")
            }
            Button(onClick = {}) {
                Text(text = "=")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text(text = "+")
            }
            Button(onClick = {}) {
                Text(text = "-")
            }
            Button(onClick = {}) {
                Text(text = "*")
            }
            Button(onClick = {}) {
                Text(text = "/")
            }
        }
    }
}
