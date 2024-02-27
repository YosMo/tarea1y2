package com.example.tarea1y2

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarea1y2.ui.theme.Tarea1y2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarea1y2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArithmeticScreen(){
    var numberOne:Int by remember {
        mutableStateOf(0)
    }

    var numberTwo:Int by remember {
        mutableStateOf(0)
    }

    var numbertres:Int by remember {
        mutableStateOf(0)
    }

    var resultado:String by remember {
        mutableStateOf("")
    }

    var resultado3:Int by remember {
        mutableStateOf(0)
    }

    var resultado2:String by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "CALCULA PROMEDIO")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = numberOne.toString(), onValueChange = {
            /*if (it.toIntOrNull()!= null) {
                numberOne = it.toInt()
            }else if(TextUtils.isEmpty(it)){
                numberOne = 0
            }*/
            numberOne = checkWroteNumber(it)
        } ,placeholder = {
            Text(text = "Porfavor escribe un numero")
        }, keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = numberTwo.toString(), onValueChange = {
            numberTwo = checkWroteNumber(it)
        }, keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number))

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = numbertres.toString(), onValueChange = {
            numbertres = checkWroteNumber(it)
        }, keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number))

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            resultado3 =((numberOne + numberTwo + numbertres)/3)
            resultado =((numberOne + numberTwo + numbertres)/3).toString()
            if(resultado3<7) {
                resultado2 = "Repetiras el semestre"
            }else if(resultado3<8.5){
                resultado2 = "Has perdido 5% de beca"
            }else if(resultado3>=8.5){
                resultado2 = "Felicidades eres un estudiante de honor"
            }
        }) {
            Text(text = "Promediar")

        }


        Text(text=resultado)

        Text(text=resultado2)
    }
}

fun checkWroteNumber(text: String):Int{
    if (text.toIntOrNull()!=null){
        return text.toInt()
    }else if(TextUtils.isEmpty(text)){
        return 0
    }
    return 1
}

