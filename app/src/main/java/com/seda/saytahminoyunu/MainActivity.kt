package com.seda.saytahminoyunu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seda.saytahminoyunu.ui.theme.SayıTahminOyunuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayıTahminOyunuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Anasayfa()
                }
            }
        }
    }
}

@Composable
fun Anasayfa() {
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Text(text = "Tahmin Oyunu", fontSize = 36.sp)
    Image(painter = painterResource(id = R.drawable.zar), contentDescription ="" )
    Button(onClick = {

    },Modifier.size(250.dp,50.dp)) {
       Text(text = "Oyuna Başla")

    }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayıTahminOyunuTheme {
        Anasayfa()
    }
}