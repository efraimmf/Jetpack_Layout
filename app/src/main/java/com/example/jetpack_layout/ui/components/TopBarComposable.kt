package com.example.jetpack_layout.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Preview(
    showBackground = true
)
@Composable
fun PreviewTopBarComposable() {
    TopBarComposable()
}