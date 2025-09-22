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

//Esto seria como el main de java
class MainActivity : ComponentActivity() { //ComponentActivity es una clase base de Android pensada para trabajar con Jetpack Compose
    override fun onCreate(savedInstanceState: Bundle?) {
        //onCreate se encarga de ejecutar la actividad
        //savedInstanceState guarda el estado de la UI si la actividad fue destruida y luego recreada

        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Permite a la app extender la interfaz hasta los bordes de la pantalla
        setContent {
            //DosTextosVerticales()
            //EjemploBox()
            ImagenConTexto()
        }
    }
}

fun randomNumber(): Color {
    //val -> no puede cambiar su valor, pero si se le llama de nuevo a la funcion se inicializa con otro valor
    val rojo = (0..255).random(); //Numero aleatorio del 0-255
    val verde = (0..255).random();
    val azul = (0..255).random();

    //val Rojo2 = (Math.random() * 256).toInt() equivalente al de arriba

    return Color(rojo, verde, azul)

}

@Composable
fun ImagenConTexto() {
    var colorFondoBox by remember { mutableStateOf(Color.White) }

        /*Var -> variable mutable (no estatica)*/

        /*by -> mutableStateOf(Color.White) devuelve un State<Color>, que tiene una propiedad .value.
        *
        * Sin by, tendrías que escribir así:
        * val colorState = remember { mutableStateOf(Color.White) }
        * colorState.value = Color.Red       // para cambiar
        * val c = colorState.value            // para leer
        *
        * Con by :
        * var color by remember { mutableStateOf(Color.White) }
        * color = Color.Red   // cambia el estado
        * val c = color       // lee el estado
        *
        * */

        /*remember -> se usa para guardar un valor durante recomposiciones de la misma función @Composable.
        * Cada vez que Compose vuelve a ejecutar la función (recomposición), el valor guardado con remember no se reinicia.
        * Sin remember, la variable se reiniciaría a su valor inicial cada vez que Compose vuelva a ejecutar la función.*/

        /*mutableStateOf -> se utiliza para cambiar de estado una interfaz y en este caso
          redibujar (volver a pintar la pantalla con un nuevo valor.)*/

    var posicionTexto by remember { mutableStateOf(Offset(0f, 0f)) }

        /* Sin by, tendria que hacer:
        * val posicionTexto  = remember { mutableStateOf(Offset(0f, 0f)) }
        * posicionTexto.value = Offset(dragAmount.x, dragAmount.y)*/

    Box( // Sirve para poner Text, Image, Button, etc., y se superpondrán según el orden en que los declares.
        modifier = Modifier
            .fillMaxSize() //Hace que el Box ocupe todoo el espacio del contenedor padre posible
            .padding(top = 25.dp) //Agrega un margen interno de 25 dp en la parte superior del Box.
            .background(colorFondoBox) //Pinta un fondo del color que tenga colorFondoBox.
    ) {

        Image( //muestra una imagen en la UI.
            painter = painterResource(id = R.drawable.asdsadasd), //painter dibuja en la pantalla
                                                                  // la imagen en Compose. id = R.drawable.asdsadasd indica
                                                                  // qué imagen quieres mostrar.

            contentDescription = "Perro formal para entrevista", //Es un texto descriptivo de la imagen para accesibilidad.
            modifier = Modifier //Los modificadores le indican a Compose cómo posicionar y dibujar la imagen.
                .align(Alignment.Center) //esto hace que la imagen se coloque en el centro del Box.
                .fillMaxSize() //La imagen ocupará todoo el tamaño disponible del Box.
        )

        Text( //Sobrepuesto en la imagen
            "Perro Entervistador ", //Es el contenido que se va a mostrar en la pantalla.
            fontSize = 22.sp, //Define el tamaño de la letra, sp -> scale-independent pixels se ajusta a la configuración de tamaño de fuente del usuario.
            color = Color.Green, //Cambia el color del texto.
            textAlign = TextAlign.Center, //Este algin centra en texto al medio del cuerpo del texto, como si fuera word en una tabla
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