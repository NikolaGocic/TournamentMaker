package com.apptour23ma.ker.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.ui.cards.MatchCard
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Finale(mainViewModel: MainViewModel, goToWinnersScreen: (()->Unit)){

    var buttonText by remember { mutableStateOf("Choose the winner") }

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom=150.dp),
            verticalArrangement= Arrangement.spacedBy(5.dp, Alignment.Top),
        ){


                item {
                    MatchCard(
                        flag1 = mainViewModel.twoWinners[0],
                        flag2 = mainViewModel.twoWinners[1],
                        winner = if (mainViewModel.first.name=="Null") 0
                        else if (mainViewModel.first == mainViewModel.twoWinners[0]) 1 else 2
                    )
                }


        }

        Button(
            onClick = {
                if( mainViewModel.getWinner() ) buttonText = "Proceed"
                else goToWinnersScreen()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 30.dp)
        ) {
            Text(text = buttonText,
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