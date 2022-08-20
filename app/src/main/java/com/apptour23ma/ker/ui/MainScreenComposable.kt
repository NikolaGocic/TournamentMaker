package com.apptour23ma.ker.ui


import androidx.activity.compose.BackHandler
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.apptour23ma.ker.viewmodel.MainViewModel


@Composable
fun MainScreenComposable(
    mainViewModel: MainViewModel
) {
    var screen by remember { mutableStateOf(0) }

    when(screen){
        1 -> BackHandler(enabled = true) {
            screen = 0
        }
        2 -> BackHandler(enabled = false) {}
        3 -> BackHandler(enabled = true) {}
        4 -> BackHandler(enabled = false) {}

    }

    if(screen == 0) SelectionScreen(mainViewModel = mainViewModel, goToNextScreen = {screen=1})
    if(screen == 1) DistributionScreen(mainViewModel = mainViewModel, goToNextScreen = {screen=2}, goToPreviusScreen = {screen=0})
    if(screen == 2) TournamentScreen(mainViewModel = mainViewModel, goToNextScreen = {screen=3})
    if(screen == 3) WinnerScreen(mainViewModel = mainViewModel, startNew = {screen=0},goToNextScreen = {screen=4} )
    if(screen == 4) WinnerList(mainViewModel = mainViewModel,startNew = {screen=0})
}