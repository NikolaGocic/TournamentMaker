package com.apptour23ma.ker.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.*
import com.apptour23ma.ker.ui.tabs.CetriTab
import com.apptour23ma.ker.ui.tabs.DvaTab
import com.apptour23ma.ker.ui.tabs.Finale
import com.apptour23ma.ker.ui.tabs.OsamTab
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WinnerScreen(
    mainViewModel: MainViewModel,
    goToNextScreen : (() -> Unit)
){

    Column(
        modifier = Modifier.fillMaxSize().background(Dark2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = "Winners",0,null)
        Column(
            modifier = Modifier.fillMaxSize().background(Dark2).weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                contentScale= ContentScale.FillHeight,
                modifier= Modifier.height(60.dp),
                painter = painterResource(mainViewModel.first.resource),
                contentDescription = ""
            )
            Text(
                text = mainViewModel.first.name,
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(40F, TextUnitType.Sp),
                modifier = Modifier.padding(top = 25.dp,bottom = 40.dp),
                textAlign = TextAlign.Center,
            )
            Divider(modifier=Modifier.padding(start=30.dp,end=30.dp,top=10.dp,bottom=10.dp),color = Red1, thickness = 2.dp)
            Text(
                text ="2nd and 3rd place",
                style = TextStyle(color = Color.White),
                fontSize = TextUnit(20F, TextUnitType.Sp),
                modifier = Modifier.padding(top = 15.dp,bottom = 25.dp),
                textAlign = TextAlign.Center,
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(mainViewModel.second.resource),
                    contentDescription = ""
                )
                Text(
                    text = mainViewModel.second.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier= Modifier.height(45.dp),
                    painter = painterResource(mainViewModel.third.resource),
                    contentDescription = ""
                )
                Text(
                    text = mainViewModel.third.name,
                    style = TextStyle(color = Color.White),
                    fontSize = TextUnit(18F, TextUnitType.Sp),
                    modifier = Modifier.padding(all = 5.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }

        Button(
            onClick =
            {
                mainViewModel.shuffleSelected()
                goToNextScreen()
            },
            enabled = mainViewModel.flagsSelected.size==32,
            colors = ButtonDefaults.buttonColors(backgroundColor = Red1),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 25.dp, end = 25.dp, top = 20.dp)
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
        Button(
            onClick =
            {
                mainViewModel.shuffleSelected()
                goToNextScreen()
            },
            enabled = mainViewModel.flagsSelected.size==32,
            colors = ButtonDefaults.buttonColors(backgroundColor = Dark2),
            border = BorderStroke(5.dp, Red1),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 50.dp, end = 50.dp, top = 10.dp, bottom = 20.dp)
        ) {
            Text(text = "To Main Menu",
                style = TextStyle(color = Red1),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(
                    18F,
                    TextUnitType.Sp
                )
            )
        }


    }




}