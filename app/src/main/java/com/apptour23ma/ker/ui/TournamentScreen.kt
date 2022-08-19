package com.apptour23ma.ker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.apptour23ma.ker.*
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
        modifier = Modifier.fillMaxSize().background(Dark2),
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
                        modifier = if (selected) Modifier.background(TabSelected).height(60.dp) else Modifier.background(TabNormal).height(60.dp),
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
                1 -> Text("1/8")
                2 -> Text("1/4")
                3 -> Text("1/2")
                4 -> Text("Final")

            }
        }


    }




}