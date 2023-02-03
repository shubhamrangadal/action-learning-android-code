package com.mygaurdian.android.ui.screens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mygaurdian.android.ui.theme.blue
import com.mygaurdian.android.ui.theme.lightBlue

class CustomTextField {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldView(
        value : String ,
        onValueChange : (String) -> Unit ,
        label : String,
        isError: Boolean,
        onDone: () -> Unit,
        myModi: Modifier
    ){
        val textState = remember { mutableStateOf(value) }

        var field = TextField(value = textState.value ,
            onValueChange = {
                textState.value = it;
                onValueChange(it)
            },
            label = { Text(text = label, color = blue)} ,
            isError = isError ,
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            }) ,
            shape = RoundedCornerShape(size = 8.dp) ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = lightBlue ,
                cursorColor = Color.Black ,
                disabledLabelColor = lightBlue ,
                focusedIndicatorColor = Color.Transparent ,
                unfocusedIndicatorColor = Color.Transparent
            ), modifier = myModi
        )


    }
}