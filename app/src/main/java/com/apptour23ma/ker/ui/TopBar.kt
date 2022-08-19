package com.apptour23ma.ker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.apptour23ma.ker.Dark1
import com.apptour23ma.ker.R

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TopBar(
    text: String,
    screen: Int,
    goToPreviusScreen: (() -> Unit)?
) {
    if(screen == 0)
        TopAppBar(modifier = Modifier.height(75.dp), backgroundColor = Dark1) {
            Column(
                modifier = Modifier.fillMaxWidth(),
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
    else if(screen==1)
        TopAppBar(modifier = Modifier.height(75.dp), backgroundColor = Dark1) {
            IconButton(modifier = Modifier.height(75.dp),onClick = { if (goToPreviusScreen != null) goToPreviusScreen() } ) {
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(R.drawable.arrow),
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
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
                    modifier = Modifier.padding(start= 5.dp, bottom = 5.dp, top=5.dp, end=45.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
}
