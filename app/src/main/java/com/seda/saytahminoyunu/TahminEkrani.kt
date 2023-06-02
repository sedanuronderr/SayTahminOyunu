package com.seda.saytahminoyunu

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.seda.saytahminoyunu.ui.theme.SayıTahminOyunuTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TahminEkrani(navController: NavController) {
    val tfTahmin = remember {
        mutableStateOf("")
    }
    val rastgeleSayi = remember {
        mutableStateOf(0)
    }
    val kalanHak = remember {
        mutableStateOf(5)
    }
    val yönlendirme = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(key1 = true )
        {
            rastgeleSayi.value = Random.nextInt(101)
            Log.e("rastgele sayi = ","${rastgeleSayi.value}")

        }
        Text(text = "Kalan Hak: ${kalanHak.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım: ${yönlendirme.value}", fontSize = 24.sp)
        TextField(value = tfTahmin.value, onValueChange = {
            tfTahmin.value=it
        }, label = { Text(text = "Tahmin")})
        Button(onClick = {
            kalanHak.value = kalanHak.value-1
            if(rastgeleSayi.value == tfTahmin.value.toInt()){
                navController.navigate("sonuc_ekrani/true"){
                    popUpTo("tahmin"){inclusive=true}
                }
                return@Button
            }
            if(rastgeleSayi.value > tfTahmin.value.toInt()){
                yönlendirme.value="Çoğalt"

            }
            if(rastgeleSayi.value < tfTahmin.value.toInt()){
                yönlendirme.value ="Azalt"
            }
            if(kalanHak.value == 0){
                navController.navigate("sonuc_ekrani/false"){
                    popUpTo("tahmin"){inclusive=true}
                }
            }
tfTahmin.value = ""

        },Modifier.size(250.dp,50.dp)) {
            Text(text = "Tahmin Et")

        }
    }
}


