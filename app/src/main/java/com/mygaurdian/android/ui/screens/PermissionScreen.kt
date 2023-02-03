package com.mygaurdian.android.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mygaurdian.android.data.service.MyAccessibilityService
import com.mygaurdian.android.ui.AccessibilityUtils
import com.mygaurdian.android.ui.composable.Screen
import com.mygaurdian.android.ui.theme.MyGuardianTheme


class PermissionScreen(var navController : NavController) : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrantPermissionScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppPermission(content: @Composable () -> Unit){
    MyGuardianTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(text = "Permission")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack,"")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            )
        }, content = {
          Box(modifier = Modifier.padding(it)){
              Surface(
                  modifier = Modifier.fillMaxSize() ,
                  color = MaterialTheme.colorScheme.background
              ) {
                  content()
              }
          }
        })
        // A surface container using the 'background' color from the theme
    }

}

@Composable
fun GrantPermissionScreen(navController : NavController){
    MyAppPermission {

        val context = LocalContext.current

        if (AccessibilityUtils.isAccessibilityServiceEnabled(context,MyAccessibilityService::class.java)){
            navController.navigate(route = Screen.AllSetScreen.route)
        }
        
        Column() {
            var isAccessibilitySwitchEnabled by remember {
                mutableStateOf(false)
            }

            Card(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 15.dp , vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Accessibility permission", style = TextStyle(fontSize = 18.sp))
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(checked = isAccessibilitySwitchEnabled , onCheckedChange = {

                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    GrantPermissionScreen(rememberNavController())
}