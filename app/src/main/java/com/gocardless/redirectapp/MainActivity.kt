package com.gocardless.redirectapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import com.gocardless.redirectapp.ui.theme.RedirectAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedirectAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    LinkRedirectFields()
                }
            }
        }
    }

    @Composable
    fun LinkRedirectFields() {
        var uri: String by rememberSaveable { mutableStateOf("") }
        Column {


            TextField(value = uri, onValueChange = {
                uri = it
            }, label = { Text("Link") })
            Button(onClick = {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
            }) {
                Text(text = "Go to URL")
            }
        }
    }
}