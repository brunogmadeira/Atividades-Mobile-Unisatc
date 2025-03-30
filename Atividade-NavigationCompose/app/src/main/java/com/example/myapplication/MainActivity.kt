package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = "tela01") {
                    composable("tela01") {
                        Tela01(
                            { navigationController.navigate("tela02") })
                    }
                    composable("tela02") {
                        Tela02(
                            { navigationController.navigate("tela01") },
                            { navigationController.navigate("tela03") })
                    }

                    composable("tela03") {
                        Tela03(
                            { navigationController.navigate("tela02") },
                            { navigationController.navigate("tela04") })
                    }
                    composable("tela04") {
                        Tela04(
                            { navigationController.navigate("tela03") },
                            { navigationController.navigate("tela05") })
                    }
                    composable("tela05") {
                        Tela05(
                            { navigationController.navigate("tela01") })
                    }
                }
            }
        }
    }
}

@Composable
fun Tela01(onNavigateToScreen02: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Caça ao Tesouro", fontSize = 36.sp, fontFamily = FontFamily.Monospace)
        Button(
            onClick = { onNavigateToScreen02() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Iniciar caça ao tesouro",
                color = Color.Black)
        }
    }
}

@Composable
fun Tela02(onNavigateToScreen01: () -> Unit, onNavigateToScreen03: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Qual foi o primeiro jogo de consoles da história?", fontSize = 24.sp,
            fontFamily = FontFamily.Monospace, modifier = Modifier.padding(horizontal = 16.dp) )

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Button(
                onClick = { onNavigateToScreen01() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Voltar")
            }

            Button(
                onClick = {
                    if (resposta("2", respostaUsuario)) {
                        onNavigateToScreen03()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Proxima Pista",
                    color = Color.Black)
            }
        }

    }
}



@Composable
fun Tela03(onNavigateToScreen02: () -> Unit, onNavigateToScreen04: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Qual jogo vendeu mais cópias na história?", fontSize = 24.sp,
            fontFamily = FontFamily.Monospace, modifier = Modifier.padding(horizontal = 16.dp))

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { onNavigateToScreen02() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Voltar")
            }

            Button(
                onClick = {
                    if (resposta("3", respostaUsuario)) {
                        onNavigateToScreen04()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Proxima Pista",
                    color = Color.Black)
            }
        }

    }
}

@Composable
fun Tela04(onNavigateToScreen03: () -> Unit, onNavigateToScreen05: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Qual empresa criou o PlayStation?", fontSize = 24.sp,
            fontFamily = FontFamily.Monospace, modifier = Modifier.padding(horizontal = 32.dp))

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { onNavigateToScreen03() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Voltar")
            }

            Button(
                onClick = {
                    if (resposta("4", respostaUsuario)) {
                        onNavigateToScreen05()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Proxima Pista",
                    color = Color.Black)
            }
        }

    }
}

@Composable
fun Tela05(onNavigateToScreen01: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Parabéns! Você encontrou o " +
                "tesouro!", fontSize = 30.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.fillMaxWidth())
        val image: Painter = painterResource(id = R.drawable.tesouro)
        Image(
            painter = image,
            contentDescription = "Imagem do Tesouro",
            modifier = Modifier.size(200.dp)
        )
        Button(
            onClick = { onNavigateToScreen01() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Voltar")
        }
    }
}


fun resposta(tela: String, resposta: String): Boolean {
    return when (tela) {
        "2" -> resposta.lowercase() == "pong"
        "3" -> resposta.lowercase() == "minecraft"
        "4" -> resposta.lowercase() == "sony"
        else -> false
    }
}



@Preview(showBackground = true)
@Composable
fun MyPreview() {
    NavigationComposeTheme {
        Tela01({})
    }
}