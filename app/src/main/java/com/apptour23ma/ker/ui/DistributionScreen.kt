package com.apptour23ma.ker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Dark1
import com.apptour23ma.ker.Dark2
import com.apptour23ma.ker.Dark3
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DistributionScreen(
    mainViewModel: MainViewModel,
    goToNextScreen : (() -> Unit),
    goToPreviusScreen : (() -> Unit)
) {

    val groups = mapOf(0 to "A",4 to "B", 8 to "C", 12 to "D", 16 to "E", 20 to "F", 24 to "G", 28 to "H")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = "Distribution",1, goToPreviusScreen)
        Column(modifier = Modifier.weight(1f)){
            LazyRow(
                modifier= Modifier.padding(top=35.dp),
                horizontalArrangement= Arrangement.spacedBy(20.dp, Alignment.Start),
                contentPadding = PaddingValues(start=20.dp,end=20.dp)
            ){
                for(index in 0..28 step 4){
                    item {
                        GroupCard(
                            title = "Group ${groups[index]}",
                            flag1 = mainViewModel.flagsSelected[index+0],
                            flag2 = mainViewModel.flagsSelected[index+1],
                            flag3 = mainViewModel.flagsSelected[index+2],
                            flag4 = mainViewModel.flagsSelected[index+3],
                            mainViewModel.groupWinners
                        )
                    }
                }
            }
        }
        Button(
            onClick = {  mainViewModel.shuffleSelected() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Dark1),
            modifier = Modifier
                .width(250.dp)
                .height(80.dp)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 5.dp)
        ) {
            Text(text = "Shuffle teams",
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(
                    18F,
                    TextUnitType.Sp
                )
            )
        }
        Button(
            onClick = { goToNextScreen() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 30.dp)
        ) {
            Text(text = "Start tournament",
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