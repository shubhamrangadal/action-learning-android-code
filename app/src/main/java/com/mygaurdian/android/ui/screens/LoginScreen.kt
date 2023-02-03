package com.mygaurdian.android.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mygaurdian.android.R
import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.domain.usecases.LoginUserUseCase
import com.mygaurdian.android.ui.composable.Screen
import com.mygaurdian.android.ui.composable.SetupNavGraph
import com.mygaurdian.android.ui.theme.MyGuardianTheme
import com.mygaurdian.android.ui.theme.blue
import com.mygaurdian.android.ui.theme.lightBlue
import com.mygaurdian.android.ui.util.RetroFitServiceUtil
import kotlinx.coroutines.*
import retrofit2.Response


class LoginScreen : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content : @Composable () -> Unit) {
    MyGuardianTheme {
        Surface(modifier = Modifier.fillMaxSize() , color = MaterialTheme.colorScheme.background) {
            content()
        }

    }
}

@Composable
fun MainContent() {
    Column {
        MainAppTitle()
        EmailFieldsView()
        PasswordFieldsView()
        buttonView(rememberNavController())
    }
}

@Composable
fun MainAppTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Text(
            text = "MyGuardian" ,
            modifier = Modifier.wrapContentWidth() ,
            style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 38.sp) ,
            color = Color.Black
        )
        Image(
            painterResource(id = R.drawable.parental_control) ,
            contentDescription = "Logo" ,
            contentScale = ContentScale.Crop ,
            modifier = Modifier.size(200.dp)
        )
    }
}

var emailValue = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailFieldsView() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        var value by remember {
            mutableStateOf("")
        }

        var isVaildEmail by remember {
            mutableStateOf(false)
        }

        CustomTextField().TextFieldView(
            value = value ,
            onValueChange = {
                value = it
                emailValue = value
                isVaildEmail = false
            } ,
            label = "Email" ,
            isError = isVaildEmail,
            onDone = {
                isVaildEmail = isVaildEmail(value)
            }, myModi = Modifier.padding(vertical = 8.dp))

    }


}

var password = ""
var childName = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldsView() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {

        var value by remember {
            mutableStateOf("")
        }

        var isPasswordVaild by remember {
            mutableStateOf(false)
        }

        CustomTextField().TextFieldView(
            value = value ,
            onValueChange = {
                value = it
                password = value
                isPasswordVaild = false
            } ,
            label = "Password" ,
            isError = isPasswordVaild,
            onDone = {
                isPasswordVaild = true
            }, myModi = Modifier.padding(vertical = 8.dp))

        var child_Name by remember {
            mutableStateOf("")
        }

        CustomTextField().TextFieldView(
            value = value ,
            onValueChange = {
                child_Name = it
                childName = value
            } ,
            label = "Child name" ,
            onDone = {
            }, myModi = Modifier.padding(vertical = 8.dp), isError = false)
    }
}


@Composable
fun buttonView(navController : NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier.fillMaxWidth()
    ) {

        Button(
            onClick = {
                val loginUserPost = LoginUserPost(email_address = emailValue, password, childName);

                GlobalScope.launch {
                    var res: LoginUserResponse = RetroFitServiceUtil.checkIfUserIsAuth(loginUserPost)
                    if (res.message.contains("successfully")){
                        navController.navigate(route = Screen.PermissionScreen.route)
                    }
                }


            } ,
            modifier = Modifier
                .padding(vertical = 8.dp , horizontal = 30.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        Button(
            onClick = {
                      navController.navigate(route = Screen.SignUpScreen.route)
            } ,
            modifier = Modifier
                .padding(vertical = 8.dp , horizontal = 30.dp)
                .fillMaxWidth()
        ) {
            Text(text = "SignUp")
        }

    }
}

fun isVaildEmail(email : String) : Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MyApp {
        MainContent()
    }
}