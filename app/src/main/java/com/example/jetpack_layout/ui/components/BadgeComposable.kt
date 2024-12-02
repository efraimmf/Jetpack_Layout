package com.example.jetpack_layout.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BadgeComposable(number: Int) {
    if (number > 0) {
        Surface(
            color = Color.Green,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier.padding(top = 6.dp)
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
    showBackground = true
)
@Composable
fun PreviewBadgeComposable() {
    BadgeComposable(number = 5)
}