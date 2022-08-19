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
import com.apptour23ma.ker.Dark2
import com.apptour23ma.ker.Dark3
import com.apptour23ma.ker.Red1
import com.apptour23ma.ker.viewmodel.MainViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun SelectionScreen( mainViewModel: MainViewModel, goToNextScreen: (() -> Unit) ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = "New tournament",0, null)
        Column(modifier = Modifier.weight(1f)){
            Column( horizontalAlignment = Alignment.Start) {
                LazyRow(
                    modifier= Modifier.padding(top=30.dp, start = 15.dp, bottom = 5.dp),
                    horizontalArrangement= Arrangement.spacedBy(5.dp, Alignment.Start),
                ){
                    itemsIndexed(
                        items = mainViewModel.flagsNotSelected
                    ){index, item ->
                        if( index % 3 == 0)
                            FlagCard(
                                flag = mainViewModel.flagsNotSelected[index],
                                selected = false,
                                onFlagClick = { mainViewModel.selectFlag(item)}
                            )
                    }
                }

                LazyRow(
                    modifier= Modifier.padding(top=10.dp, start = 10.dp, bottom = 5.dp),
                    horizontalArrangement= Arrangement.spacedBy(5.dp, Alignment.Start)
                ){
                    itemsIndexed(
                        items = mainViewModel.flagsNotSelected
                    ){index, item ->
                        if( index % 3 == 1)
                            FlagCard(
                                flag = mainViewModel.flagsNotSelected[index],
                                selected = false,
                                onFlagClick = { mainViewModel.selectFlag(item) }
                            )
                    }
                }

                LazyRow(
                    modifier= Modifier.padding(top=10.dp, start = 5.dp, bottom = 25.dp),
                    horizontalArrangement= Arrangement.spacedBy(5.dp, Alignment.Start)
                ){
                    itemsIndexed(
                        items = mainViewModel.flagsNotSelected
                    ){index, item ->
                        if( index % 3 == 2)
                            FlagCard(
                                flag = mainViewModel.flagsNotSelected[index],
                                selected = false,
                                onFlagClick = { mainViewModel.selectFlag(item) }
                            )
                    }
                }
            }
            Divider(modifier= Modifier.padding(start=15.dp,end=15.dp), color = Dark3, thickness = 3.dp)
            Column( horizontalAlignment = Alignment.Start) {
                LazyRow(
                    modifier= Modifier.padding(top=30.dp, start = 15.dp, bottom = 5.dp),
                    horizontalArrangement= Arrangement.spacedBy(5.dp, Alignment.Start),
                ){
                    itemsIndexed(
                        items = mainViewModel.flagsSelected
                    ){index, item ->
                        if( index % 2 == 0)
                            FlagCard(
                                flag = mainViewModel.flagsSelected[index],
                                selected = true,
                                onFlagClick = { mainViewModel.selectFlag(item) }
                            )
                    }
                }

                LazyRow(
                    modifier= Modifier.padding(top=10.dp, start = 10.dp, bottom = 25.dp),
                    horizontalArrangement= Arrangement.spacedBy(5.dp, Alignment.Start)
                ){
                    itemsIndexed(
                        items = mainViewModel.flagsSelected
                    ){index, item ->
                        if( index % 2 == 1)
                            FlagCard(
                                flag = mainViewModel.flagsSelected[index],
                                selected = true,
                                onFlagClick = { mainViewModel.selectFlag(item) }
                            )
                    }
                }

            }
            Divider(modifier= Modifier.padding(start=15.dp,end=15.dp), color = Dark3, thickness = 3.dp)


        }
        Text(
            text = "Selected ${mainViewModel.flagsSelected.size}/32",
            style = TextStyle(color = Color.White),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            textAlign = TextAlign.Center
        )
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
                .height(130.dp)
                .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 30.dp)
        ) {
            Text(text = "Go to group distribution",
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