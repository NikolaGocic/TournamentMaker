package com.apptour23ma.ker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.Dark1
import com.apptour23ma.ker.Dark2
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.ui.cards.MatchCard
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WinnerList(
    mainViewModel: MainViewModel,
    startNew: (()-> Unit)
){
    Column(
        modifier = Modifier.fillMaxSize().background(Dark2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = "Main menu",0,null)
        Text(
            text = "Past winners",
            style = TextStyle(color = Color.White),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(20F, TextUnitType.Sp),
            modifier = Modifier.padding(top = 25.dp,bottom = 20.dp),
            textAlign = TextAlign.Center,
        )
        Divider(modifier=Modifier.padding(start=30.dp,end=30.dp,bottom=10.dp),color = Dark1, thickness = 1.dp)
        LazyColumn(
            modifier= Modifier.weight(1f),
            contentPadding = PaddingValues(bottom=150.dp),
            verticalArrangement= Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ){
            itemsIndexed(
                items = mainViewModel.winnerList
            ){index, item ->

                    Row(modifier=Modifier.padding(start=30.dp,end=30.dp,bottom=10.dp),verticalAlignment = Alignment.CenterVertically){
                        Image(
                            modifier= Modifier.height(45.dp),
                            painter = painterResource(item.resource),
                            contentDescription = ""
                        )
                        Text(
                            text = item.name,
                            style = TextStyle(color = Color.White),
                            fontSize = TextUnit(18F, TextUnitType.Sp),
                            modifier = Modifier.padding(all = 5.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                    Divider(modifier=Modifier.padding(start=30.dp,end=30.dp,bottom=5.dp),color = Dark1, thickness = 1.dp)
                }


        }
        Button(
            onClick = {
                mainViewModel.startNew()
                startNew()
            },
            enabled = mainViewModel.flagsSelected.size==32,
            colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 25.dp, end = 25.dp, bottom= 30.dp,top = 20.dp)
        ) {
            Text(text = "Start a new tournament",
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