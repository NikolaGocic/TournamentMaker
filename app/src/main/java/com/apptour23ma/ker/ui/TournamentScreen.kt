package com.apptour23ma.ker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.apptour23ma.ker.*
import com.apptour23ma.ker.ui.tabs.CetriTab
import com.apptour23ma.ker.ui.tabs.DvaTab
import com.apptour23ma.ker.ui.tabs.Finale
import com.apptour23ma.ker.ui.tabs.OsamTab
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TournamentScreen(
        mainViewModel: MainViewModel,
        goToNextScreen : (() -> Unit)
){
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Groups", "1/8", "1/4","1/2","Final")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = "Games",0,null)
        Column {
            TabRow(selectedTabIndex = tabIndex,
                backgroundColor = Color(0xff1E76DA),
                indicator = { tabPositions: List<TabPosition> -> Box {} }
            ) {
                tabTitles .forEachIndexed { index, title ->
                    val selected = tabIndex == index
                    Tab(
                        modifier = if (selected) Modifier
                            .background(TabSelected)
                            .height(60.dp) else Modifier
                            .background(TabNormal)
                            .height(60.dp),
                        selected = selected,
                        onClick = {  },
                        text = {
                            Text(
                                text = title,
                                style = TextStyle(color = Color.White),
                                fontWeight = FontWeight.Bold,
                                fontSize = TextUnit(14F, TextUnitType.Sp)
                            )
                        }
                    )
                }
            }
            when (tabIndex) { // 6.
                0 -> TabGroup(mainViewModel=mainViewModel,goToTab2= {tabIndex=1})
                1 -> OsamTab(mainViewModel = mainViewModel,goToTab3= {tabIndex=2})
                2 -> CetriTab(mainViewModel = mainViewModel,goToTab4= {tabIndex=3})
                3 -> DvaTab(mainViewModel = mainViewModel,goToTab5= {tabIndex=4})
                4 -> Finale(mainViewModel = mainViewModel, goToWinnersScreen = {goToNextScreen()})
            }
        }


    }




}