package com.example.jetpack_layout.ui.screens

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import com.example.jetpack_layout.ui.components.ListItemComposable
import com.example.jetpack_layout.ui.components.TopBarComposable

@Composable
fun ListViewScreen() {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                TopBarComposable()
            }
            items(19) { index ->
                ListItemComposable(
                    img = "https://picsum.photos/200/300?random=$index",
                    name = "Person $index",
                    date = "Today",
                    message = "Hello $index!",
                    number = index,
                    onClick = { Toast.makeText(context, "Item $index clicked", Toast.LENGTH_SHORT).show() }
                )
            }
        }

        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color.Green
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Novo Chat",
                tint = Color.White
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)
@Composable
fun PreviewListViewScreen() {
    ListViewScreen()
}