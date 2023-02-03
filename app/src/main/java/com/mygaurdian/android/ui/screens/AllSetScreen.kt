package com.mygaurdian.android.ui.screens

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mygaurdian.android.R
import com.mygaurdian.android.data.api.RetrofitService
import com.mygaurdian.android.ui.theme.MyGuardianTheme
import com.mygaurdian.android.ui.util.RetroFitServiceUtil
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class AllSetScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Composable
fun MyAppAllSet(content : @Composable () -> Unit) {
    MyGuardianTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize() , color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun mainContent() {
    MyAppAllSet {
        setWebSocketConnection()
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.baseline_done_24) ,
                contentDescription = "correct image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
            Text(text = "All Permission set")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "View dashboard")
            }
        }
    }
}

fun setWebSocketConnection(){
    var retrofit = RetroFitServiceUtil.getRetrofitService()
    val service = retrofit.create(RetrofitService::class.java)
    val call = service.listen("get_live_locations")
    call.enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody> , response: Response<ResponseBody>) {
            // Handle incoming messages
            Log.i(TAG , "onResponse: $response")
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            // Handle connection failure
        }
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyGuardianTheme {
        mainContent()
    }
}