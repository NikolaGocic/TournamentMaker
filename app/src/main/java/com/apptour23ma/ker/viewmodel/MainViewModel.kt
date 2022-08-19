package com.apptour23ma.ker.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import com.apptour23ma.ker.R
import com.apptour23ma.ker.data.Flag

class MainViewModel(val appContext: Application): AndroidViewModel(appContext) {


    var flagsSelected by mutableStateOf(listOf<Flag>())
    var flagsNotSelected by mutableStateOf(listOf<Flag>())
    var groupWinners by mutableStateOf(listOf<Flag>())


    init{
        preperFlags()
    }


    fun preperFlags(){
        val allFlags: MutableList<Flag> = arrayListOf()
        allFlags.add(Flag("Qatar", R.drawable.katar))
        allFlags.add(Flag("Ecuador", R.drawable.ecuador))
        allFlags.add(Flag("Senegal", R.drawable.senegal))
        allFlags.add(Flag("Netherlands", R.drawable.netherlands))
        allFlags.add(Flag("England", R.drawable.england))
        allFlags.add(Flag("Iran", R.drawable.iran))
        allFlags.add(Flag("Argentina", R.drawable.argentina))
        allFlags.add(Flag("USA", R.drawable.usa))
        allFlags.add(Flag("Saudi Arabia", R.drawable.saudi))
        allFlags.add(Flag("Mexico", R.drawable.mexico))
        allFlags.add(Flag("Poland", R.drawable.poland))
        allFlags.add(Flag("France", R.drawable.france))
        allFlags.add(Flag("Denmark", R.drawable.denmark))
        allFlags.add(Flag("Australia", R.drawable.australia))
        allFlags.add(Flag("Austria", R.drawable.austria))
        allFlags.add(Flag("Tunisia", R.drawable.tunis))
        allFlags.add(Flag("Spain", R.drawable.spain))
        allFlags.add(Flag("Wales", R.drawable.wales))
        allFlags.add(Flag("Germany", R.drawable.germany))
        allFlags.add(Flag("Japan", R.drawable.japan))
        allFlags.add(Flag("Belgium", R.drawable.belgium))
        allFlags.add(Flag("Canada", R.drawable.canada))
        allFlags.add(Flag("Morocco", R.drawable.moroco))
        allFlags.add(Flag("Croatia", R.drawable.croatia))
        allFlags.add(Flag("Brazil", R.drawable.brazil))
        allFlags.add(Flag("Serbia", R.drawable.serbia))
        allFlags.add(Flag("Switzerland", R.drawable.switzerland))
        allFlags.add(Flag("Cameroon", R.drawable.cameroon))
        allFlags.add(Flag("Portugal", R.drawable.portugal))
        allFlags.add(Flag("Ghana", R.drawable.ghana))
        allFlags.add(Flag("Uruguay", R.drawable.uruguay))
        allFlags.add(Flag("Republic of Korea", R.drawable.korea))
        allFlags.add(Flag("Barbados", R.drawable.barbados))
        allFlags.add(Flag("Czech Republic", R.drawable.check))
        allFlags.add(Flag("Finland", R.drawable.finland))
        allFlags.add(Flag("Costa Rica", R.drawable.costa))
        flagsNotSelected = allFlags
    }

    fun selectFlag(flag: Flag){
        val list: MutableList<Flag> = arrayListOf()

        if(flag.selected) {
            flag.selected=false
            list.add(flag)
            flagsNotSelected.forEach{list.add(it)}
            flagsNotSelected = list
            flagsSelected = flagsSelected.filter { flag.name!=it.name }
        }
        else if(flagsSelected.size == 32) Toast.makeText(appContext,"All 32 nations selected!",Toast.LENGTH_SHORT).show()
                else {
                    flag.selected=true
                    list.add(flag)
                    flagsSelected.forEach{list.add(it)}
                    flagsSelected = list
                    flagsNotSelected = flagsNotSelected.filter { flag.name!=it.name }
                }
    }

    fun shuffleSelected() {
        val list: MutableList<Flag> = arrayListOf()
        flagsSelected.forEach{list.add(it)}
        list.shuffle()
        flagsSelected=list
    }

    fun getWinnersForGroup(groupId: Int): Boolean {
        if(flagsSelected[groupId*4] !in groupWinners &&
            flagsSelected[groupId*4+1] !in groupWinners &&
            flagsSelected[groupId*4+2] !in groupWinners &&
            flagsSelected[groupId*4+3] !in groupWinners) {

            val first = (0..3).random()
            var second = first
            while(second==first) second = (0..3).random()

            val list: MutableList<Flag> = arrayListOf()
            groupWinners.forEach{list.add(it)}

            list.add(flagsSelected[groupId*4+first])
            list.add(flagsSelected[groupId*4+second])

            groupWinners=list
            return true
        } else return false

    }



}