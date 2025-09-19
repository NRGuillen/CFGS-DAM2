package com.example.holaconjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun ImagenConTexto() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.asdsadasd),
            contentDescription = "Perro formal para entrevista",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )

        Text(
            "Perro Entervistador ",
            fontSize = 22.sp,
            color = Color.Green,
            textAlign = TextAlign.Center, //Este algin centra en texto al medio del cuerpo
            modifier = Modifier.align(Alignment.Center) //Este aling centra el box al medio de la pantalla
        )


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