package com.apptour23ma.ker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Dark3
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.data.Flag

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FlagCard(
    flag: Flag,
    selected: Boolean,
    onFlagClick: ((flag: Flag) -> Unit)
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = if(selected) Red1 else Dark3),
        shape = RoundedCornerShape(12),
        onClick = { onFlagClick(flag) }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                modifier= Modifier.height(45.dp),
                painter = painterResource(flag.resource),
                contentDescription = ""
            )
            Text(
                text = flag.name,
                style = TextStyle(color = Color.White),
                fontSize = TextUnit(18F, TextUnitType.Sp),
                modifier = Modifier.padding(all = 5.dp),
                textAlign = TextAlign.Center,
            )
        }
    }

}