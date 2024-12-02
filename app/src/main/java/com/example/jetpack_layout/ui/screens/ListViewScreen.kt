package com.example.jetpack_layout.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.jetpack_layout.ui.components.ListItemComposable

@Composable
fun ListViewScreen() {
    Column {
        repeat(10) { index ->
            ListItemComposable(
                img = "https://picsum.photos/200/300?random=$index",
                name = "Person $index",
                date = "Today",
                message = "Hello $index!",
                number = index
            )
        }
    }
}