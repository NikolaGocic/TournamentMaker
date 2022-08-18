package com.apptour23ma.ker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.apptour23ma.ker.Dark1

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TopBar(
    text: String
) {
    TopAppBar(modifier = Modifier.height(75.dp), backgroundColor = Dark1) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(
                    20F,
                    TextUnitType.Sp
                ),
                modifier = Modifier.padding(all = 5.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}