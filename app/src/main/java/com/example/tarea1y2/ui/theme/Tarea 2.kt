package com.example.tarea1y2.ui.theme

import android.text.TextUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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

    var menor:Int by remember {
        mutableStateOf(0)
    }

    var mayor:Int by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "CALCULAR MAYOR Y MENOR")
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
            resultado =("MAYOR = " + mayor + " MENOR = " + menor).toString()

            if(numberOne<numberTwo) {
                menor = numberOne
                mayor = numberTwo
            }else if(numberOne>numbertres){
                menor = numbertres
                mayor = numberOne
            }else if(numbertres>numberTwo){
                menor = numberTwo
                mayor = numbertres
            }
        }) {
            Text(text = "Calcular")

        }

        Text(text=resultado)
        mayor

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