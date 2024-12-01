package com.example.jetpack_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Scaffold { innerPadding ->
                Surface (
                    modifier = Modifier.padding(innerPadding)) {
                    ListViewComposable()
                }
            }
        }
    }
}

@Composable
fun ListViewComposable(modifier: Modifier = Modifier) {
    Column {
        ListItemComposable(
            modifier = Modifier,
            name = "John Doe",
            date = "Today",
            message = "Hello, how are you?",
            number = 8
        )
    }
}

@Composable
fun ListItemComposable(modifier: Modifier = Modifier, name: String, date: String, message: String, number: Int) {
    Row (
        Modifier.
            padding(horizontal = 12.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = CenterVertically
    ) {
        AsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdQLwDqDwd2JfzifvfBTFT8I7iKFFevcedYg&s",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 14.dp)
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Column (
            Modifier
                .padding(start = 16.dp, top = 18.dp)
                .fillMaxWidth(0.85f)
        ) {

            Text(
               text = name,
               fontSize = 16.sp,
               fontWeight = FontWeight.Bold,
           )

            Text(
                text = message,
                color = Color.Gray,
                modifier = Modifier.padding(top = 6.dp)
            )
        }

        Column (
            Modifier
                .padding(top = 20.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.End
        ) {
            Text(
                text = date,
                fontSize = 12.sp,
                color = Color.Gray,
            )

            BadgeComposable(number)
        }
    }
}

@Composable
fun BadgeComposable(number: Int) {
    if (number > 0) {
        Surface(
            color = Color.Green,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = number.toString(),
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 4.dp)
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
fun ListViewComposablePreview() {
    Scaffold { innerPadding ->
        Surface (modifier = Modifier.padding(innerPadding)) {
            ListViewComposable()
        }
    }
}