package com.apptour23ma.ker.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.data.Flag

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MatchCard(
    flag1: Flag,
    flag2: Flag,
    winner: Int
) {

    Box(modifier= Modifier.fillMaxWidth().padding(all=10.dp), contentAlignment = Alignment.Center){
        Divider(modifier=Modifier.padding(top=10.dp,bottom=10.dp),color = Dark1, thickness = 5.dp)
        Row(modifier=Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(15.dp)){
            Card(modifier = Modifier
                .height(140.dp).fillMaxWidth().weight(1f),
                backgroundColor = Dark1,
                shape = RoundedCornerShape(4)
            ){
                Column(modifier=Modifier.padding(all=10.dp)) {
                    Row(modifier=Modifier.padding(bottom=5.dp).fillMaxWidth().height(60.dp),verticalAlignment = Alignment.CenterVertically){
                        Image(
                            modifier= Modifier.height(45.dp).alpha(if (winner == 1 || winner == 0) 1.0f else 0.2f),
                            painter = painterResource(flag1.resource),
                            contentDescription = ""
                        )
                        Text(
                            text = flag1.name,
                            style = TextStyle(color = if(winner == 1 || winner == 0) Color.White else Color.White.copy(alpha = 0.2f)),
                            fontSize = TextUnit(14F, TextUnitType.Sp),
                            modifier = Modifier.padding(all = 5.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth().height(60.dp),verticalAlignment = Alignment.CenterVertically){
                        Image(
                            modifier= Modifier.height(45.dp).alpha(if (winner == 2 || winner == 0) 1.0f else 0.2f),
                            painter = painterResource(flag2.resource),
                            contentDescription = ""
                        )
                        Text(
                            text = flag2.name,
                            style = TextStyle(color = if(winner == 2 || winner == 0) Color.White else Color.White.copy(alpha = 0.2f)),
                            fontSize = TextUnit(14F, TextUnitType.Sp),
                            modifier = Modifier.padding(all = 5.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

            Card(modifier = Modifier.height(70.dp).fillMaxWidth().weight(1f),
                backgroundColor = Dark1,
                shape = RoundedCornerShape(4)
            ){
                if(winner!=0)
                Column(modifier=Modifier.padding(all=15.dp)) {
                    Row(modifier=Modifier.padding(top=3.dp,bottom=3.dp).fillMaxWidth(),verticalAlignment = Alignment.CenterVertically){
                        Image(
                            modifier= Modifier.height(45.dp),
                            painter = painterResource(if(winner==1) flag1.resource else flag2.resource),
                            contentDescription = ""
                        )
                        Text(
                            text = if(winner==1) flag1.name else flag2.name,
                            style = TextStyle(color = Color.White),
                            fontSize = TextUnit(14F, TextUnitType.Sp),
                            modifier = Modifier.padding(all = 5.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}