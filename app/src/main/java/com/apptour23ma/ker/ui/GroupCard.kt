package com.apptour23ma.ker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Dark1
import com.apptour23ma.ker.Dark3
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.data.Flag

@OptIn(ExperimentalUnitApi::class)
@Composable
fun GroupCard(
    title: String,
    flag1: Flag,
    flag2: Flag,
    flag3: Flag,
    flag4: Flag,
    winners: List<Flag>
) {
    Card(modifier = Modifier
        .height(310.dp)
        .width(240.dp),
        backgroundColor = Dark1,
        shape = RoundedCornerShape(4)
    ){
        Column(modifier=Modifier.padding(all=22.dp)) {
            Text(
                text = title,
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(20F, TextUnitType.Sp),
                textAlign = TextAlign.Center
            )
            Divider(modifier=Modifier.padding(top=10.dp,bottom=10.dp),color = Red1, thickness = 3.dp)
            Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth().background(if(flag1 in winners) Red1 else Color.Transparent),verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(flag1.resource),
                    contentDescription = ""
                )
                Text(
                    text = flag1.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth().background(if(flag2 in winners) Red1 else Color.Transparent),verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(flag2.resource),
                    contentDescription = ""
                )
                Text(
                    text = flag2.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth().background(if(flag3 in winners) Red1 else Color.Transparent),verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(flag3.resource),
                    contentDescription = ""
                )
                Text(
                    text = flag3.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth().background(if(flag4 in winners) Red1 else Color.Transparent),verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(flag4.resource),
                    contentDescription = ""
                )
                Text(
                    text = flag4.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

}