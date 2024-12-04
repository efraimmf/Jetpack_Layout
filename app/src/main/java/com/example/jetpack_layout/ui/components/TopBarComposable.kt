package com.example.jetpack_layout.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComposable() {
    var selectedIndex by remember { mutableIntStateOf(0) }

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
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = Color.White
                )
            },
        ) {
            Tab(selected = selectedIndex == 0, onClick = { selectedIndex = 0 }) {
                Text(
                    text = "Conversas",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Tab(selected = selectedIndex == 1, onClick = { selectedIndex = 1 }) {
                Text(
                    text = "Status",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Tab(selected = selectedIndex == 2, onClick = { selectedIndex = 2 }) {
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

@Preview(
    showBackground = true
)
@Composable
fun PreviewTopBarComposable() {
    TopBarComposable()
}