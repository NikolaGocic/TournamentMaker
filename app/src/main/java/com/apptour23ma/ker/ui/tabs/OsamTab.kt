package com.apptour23ma.ker.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.apptour23ma.ker.ui.FlagCard
import com.apptour23ma.ker.ui.cards.MatchCard
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun OsamTab(mainViewModel: MainViewModel, goToTab3: (()->Unit)){

    var buttonText by remember { mutableStateOf("Choose new winners") }

    Box(contentAlignment = Alignment.BottomCenter){
        LazyColumn(
            contentPadding = PaddingValues(bottom=150.dp),
            verticalArrangement= Arrangement.spacedBy(5.dp, Alignment.Top),
        ){

            for(index in 0..mainViewModel.groupWinners.size-1 step 2 )
                item {
                    MatchCard(
                        flag1 = mainViewModel.groupWinners[index],
                        flag2 = mainViewModel.groupWinners[index+1] ,
                        winner = if(mainViewModel.eightWinners.isEmpty()) 0
                                    else if(mainViewModel.groupWinners[index] in mainViewModel.eightWinners ) 1 else 2
                    )
                }


        }

        Button(
            onClick = {
                if( mainViewModel.getWinnersFromEight() ) buttonText = "Go next step"
                else goToTab3()
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

