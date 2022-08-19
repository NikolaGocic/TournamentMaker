package com.apptour23ma.ker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Dark1
import com.apptour23ma.ker.R
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TabGroup(
    mainViewModel: MainViewModel,
    goToTab2: (()->Unit)){

    val groups = mapOf(0 to "A",4 to "B", 8 to "C", 12 to "D", 16 to "E", 20 to "F", 24 to "G", 28 to "H")
    var groupIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f),horizontalAlignment = Alignment.CenterHorizontally){
            Row(
                modifier = Modifier.height(400.dp).fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(modifier = Modifier.height(75.dp),onClick = { if(groupIndex>0) groupIndex-- } ) {
                    Image(
                        modifier= Modifier.height(45.dp),
                        painter = painterResource(if(groupIndex==0) R.drawable.back_disabled else R.drawable.back_enabled),
                        contentDescription = ""
                    )
                }
                GroupCard(
                    title = "Group ${groups[groupIndex*4]}",
                    flag1 = mainViewModel.flagsSelected[groupIndex*4+0],
                    flag2 = mainViewModel.flagsSelected[groupIndex*4+1],
                    flag3 = mainViewModel.flagsSelected[groupIndex*4+2],
                    flag4 = mainViewModel.flagsSelected[groupIndex*4+3],
                    mainViewModel.groupWinners
                )
                IconButton(modifier = Modifier.height(75.dp),onClick = { if(!mainViewModel.getWinnersForGroup(groupIndex)) if(groupIndex<7) groupIndex++ } ) {
                    Image(
                        modifier= Modifier.height(45.dp),
                        painter = painterResource(if(groupIndex==7) R.drawable.next_disabled else R.drawable.next_enabled),
                        contentDescription = ""
                    )
                }
            }
            Button(
                onClick = {  mainViewModel.getWinnersForGroup(groupIndex) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
                modifier = Modifier
                    .width(250.dp)
                    .height(80.dp)
                    .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 5.dp)
            ) {
                Text(text = "Choose 2 winners",
                    style = TextStyle(color = Color.White),
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(
                        18F,
                        TextUnitType.Sp
                    )
                )
            }
        }

        Button(
            onClick = { goToTab2() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
            enabled = mainViewModel.groupWinners.size == 16,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 30.dp)
        ) {
            Text(text = "Go to next step",
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(
                    18F,
                    TextUnitType.Sp
                )
            )
        }
    }

}