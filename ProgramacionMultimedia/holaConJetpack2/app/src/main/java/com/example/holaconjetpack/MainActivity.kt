package com.example.holaconjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holaconjetpack.ui.theme.HolaConJetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DosTextosVerticales()
        }
    }
}

@Composable
fun DosTextosVerticales(){

    /*Row(modifier = Modifier.padding(top = 25.dp)){
        Text("Primer Texto ")
        Text("Segundo texto")
    }*/

    Column(modifier = Modifier.fillMaxSize().padding(top = 40.dp)){
        Row(){
            Text("Primer Texto ")
            Spacer(modifier = Modifier.width(20.dp))
            Text("Segundo texto")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("Mi Primer Texto")
        Text("Mi Segundo texto")
    }

}

@Preview
@Composable
fun DosTextosVerticalesPreview() {
    DosTextosVerticales()
}