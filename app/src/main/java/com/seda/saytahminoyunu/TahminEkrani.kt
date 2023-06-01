package com.seda.saytahminoyunu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seda.saytahminoyunu.ui.theme.SayıTahminOyunuTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TahminEkrani() {
    val tfTahmin = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Kalan Hak: 5", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım: Arttır", fontSize = 24.sp)
        TextField(value = tfTahmin.value, onValueChange = {
            tfTahmin.value=it
        }, label = { Text(text = "Tahmin")})
        Button(onClick = {

        },Modifier.size(250.dp,50.dp)) {
            Text(text = "Tahmin Et")

        }
    }
}


@Preview(showBackground = true)
@Composable
fun Grg() {
    SayıTahminOyunuTheme {
        TahminEkrani()
    }
}