package com.example.jetpack_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_layout.ui.components.TopBarComposable
import com.example.jetpack_layout.ui.screens.ListViewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    Scaffold(
        topBar = { TopBarComposable() }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            ListViewScreen()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)

@Composable
fun PreviewApp() {
    App()
}