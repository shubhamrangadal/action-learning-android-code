package com.mygaurdian.android.ui.screens

import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mygaurdian.android.data.model.SignUpPost
import com.mygaurdian.android.ui.composable.Screen
import com.mygaurdian.android.ui.theme.MyGuardianTheme
import com.mygaurdian.android.ui.util.RetroFitServiceUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SignUpScreen(var navController : NavController) : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppSignUp {
                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "SignUp")
                        } ,
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.ArrowBack , "")
                            }
                        } ,
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent) ,
                    )
                } , content = { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FieldView(navController)
                    }
                })

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppSignUp(con : @Composable () -> Unit) {
    MyGuardianTheme {
        Surface(
            modifier = Modifier.fillMaxSize() ,
            color = MaterialTheme.colorScheme.background
        ) {
            con()
        }
    }
}

@Composable
fun FieldView(navController : NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier.fillMaxWidth()
    ) {

        var emailValue by remember {
            mutableStateOf("")
        }

        var isVaildEmail by remember {
            mutableStateOf(false)
        }

        CustomTextField().TextFieldView(
            value = emailValue ,
            onValueChange = {
                emailValue = it
                isVaildEmail = false
            } ,
            label = "Email" ,
            isError = isVaildEmail ,
            onDone = {
                isVaildEmail = isVaildEmail(emailValue)
            } , myModi = Modifier.padding(vertical = 5.dp)
        )

        var password by remember {
            mutableStateOf("")
        }

        CustomTextField().TextFieldView(
            value = password ,
            onValueChange = {
                password = it
            } ,
            label = "Password" ,
            isError = false ,
            onDone = {

            } , myModi = Modifier.padding(vertical = 5.dp)
        )

        var re_password by remember {
            mutableStateOf("")
        }

        CustomTextField().TextFieldView(
            value = re_password ,
            onValueChange = {
                re_password = it
            } ,
            label = "Re-Password" ,
            isError = false ,
            onDone = {

            } , myModi = Modifier.padding(vertical = 5.dp)
        )

        var childName by remember {
            mutableStateOf("")
        }

        CustomTextField().TextFieldView(
            value = childName ,
            onValueChange = {
                childName = it
            } ,
            label = "Child Name" ,
            isError = false ,
            onDone = {

            } , myModi = Modifier.padding(vertical = 5.dp)
        )

        val context = LocalContext.current

        Button(onClick = {

            var signUpPost = SignUpPost(
                child_name = childName ,
                email_address = emailValue ,
                device_id = Settings.Secure.ANDROID_ID,
                password = password
            )

            CoroutineScope(context = Dispatchers.IO).launch {
                var value = RetroFitServiceUtil.submitToBackend(signUpPost)

                if(value){
                    Toast.makeText(context,"Register success",Toast.LENGTH_SHORT).show()

                    navController.navigate(route = Screen.PermissionScreen.route)

                }
            }

        }) {
            Text(text = "Submit" , color = Color.White)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    MyAppSignUp {
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(text = "SignUp")
                } ,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack , "")
                    }
                } ,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent) ,
            )
        } , content = {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxWidth()) {
                FieldView(rememberNavController())
            }
        })

    }
}