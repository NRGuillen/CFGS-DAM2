package com.example.holaconjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holaconjetpack.ui.theme.HolaConJetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //DosTextosVerticales()
            //EjemploBox()
            ImagenConTexto()
        }
    }
}

fun randomNumber(): Color {

    val Rojo = (0..255).random(); //Numero aleatorio del 0-255
    val Verde = (0..255).random();
    val Azul = (0..255).random();

    //val Rojo2 = (Math.random() * 256).toInt() equivalente al de arriba

    return Color(Rojo, Verde, Azul)

}

@Composable
fun ImagenConTexto() {
    var colorFondoBox by remember { mutableStateOf(Color.White) }
    var posicionTexto by remember { mutableStateOf(Offset(0f, 0f)) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
            .background(colorFondoBox)
    ) {

        Image(
            painter = painterResource(id = R.drawable.asdsadasd),
            contentDescription = "Perro formal para entrevista",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )

        Text( //Sobrepuesto en la imagen
            "Perro Entervistador ",
            fontSize = 22.sp,
            color = Color.Green,
            textAlign = TextAlign.Center, //Este algin centra en texto al medio del cuerpo
            modifier = Modifier.align(Alignment.Center) //Este aling centra el box al medio de la pantalla
        )

        Button(

            onClick = { colorFondoBox = randomNumber() },
            //modifier = Modifier.align(Alignment.TopCenter) boton en el centro arriba
            modifier = Modifier
                .offset {

                    IntOffset(posicionTexto.x.toInt(), posicionTexto.y.toInt())
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        posicionTexto = Offset(dragAmount.x, dragAmount.y)

                    }
                }
        ) {

            Text("Cambiar Fondo")

        }

    }

}

@Composable
fun EjemploBox() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {

        Text("Parte superior Izquierda", modifier = Modifier.align(Alignment.TopStart))
        Text("Parte Central ", modifier = Modifier.align(Alignment.Center))
        Text("Parte inferiror Derecha ", modifier = Modifier.align(Alignment.BottomEnd))


    }

}

@Composable
fun DosTextosVerticales() {

    /*Row(modifier = Modifier.padding(top = 25.dp)){
        Text("Primer Texto ")
        Text("Segundo texto")
    }*/


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(height = 40.dp))

        Row() {
            Text("Segundo Texto ")
            Spacer(modifier = Modifier.width(width = 20.dp))
            Text("Tercer texto")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {

            Text("Primer Texto")
            Text("Segundo texto")
        }

    }

}

@Preview
@Composable
fun FuncionesPreview() {
    //DosTextosVerticales()
    //EjemploBox()
    ImagenConTexto()
}