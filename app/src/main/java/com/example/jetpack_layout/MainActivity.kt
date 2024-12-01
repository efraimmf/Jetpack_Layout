package com.example.jetpack_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Scaffold (
                topBar = { TopBarComposable() }) {
                innerPadding -> Surface (
                    modifier = Modifier.padding(innerPadding)) {
                    ListViewComposable()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComposable() {
    var selectedIndex by remember { mutableStateOf(0) }

    Column {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "WhatsApp",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ) },
            actions = {
                IconButton(modifier = Modifier.padding(top = 8.dp), onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                }
                IconButton(modifier = Modifier.padding(top = 8.dp), onClick = { }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)
                }
            },
            modifier = Modifier.height(110.dp),
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF075E54))
        )

        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color(0xFF075E54),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = Color.White
                )
            },
        ) {
            Tab(selected = selectedIndex == 0, onClick = {selectedIndex = 0}) {
                Text(
                    text = "Conversas",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Tab(selected = selectedIndex == 1, onClick = {selectedIndex = 1}) {
                Text(
                    text = "Status",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Tab(selected = selectedIndex == 2, onClick = {selectedIndex = 2}) {
                Text(
                    text = "Chamadas",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
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

@Composable
fun ListItemComposable(name: String, date: String, message: String, number: Int) {
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
fun ListViewComposable() {
    Column {
        ListItemComposable(
            name = "John Doe",
            date = "Today",
            message = "Hello, how are you?",
            number = 8
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)

@Composable
fun Preview() {
    Scaffold(
        topBar = { TopBarComposable() }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            ListViewComposable()
        }
    }
}