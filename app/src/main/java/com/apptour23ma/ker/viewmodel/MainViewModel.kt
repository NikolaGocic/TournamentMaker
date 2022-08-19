package com.apptour23ma.ker.viewmodel

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
    var eightWinners by mutableStateOf(listOf<Flag>())
    var fourWinners by mutableStateOf(listOf<Flag>())
    var twoWinners by mutableStateOf(listOf<Flag>())
    var first by mutableStateOf(Flag("Null", 0))
    var second by mutableStateOf(Flag("Null", 0))
    var third by mutableStateOf(Flag("Null", 0))


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

    fun shuffleGroupWinners() {
        val list: MutableList<Flag> = arrayListOf()
        groupWinners.forEach{list.add(it)}
        list.shuffle()
        groupWinners=list
    }

    fun getWinnersForGroup(groupId: Int): Boolean {
        if(flagsSelected[groupId*4] !in groupWinners &&
            flagsSelected[groupId*4+1] !in groupWinners &&
            flagsSelected[groupId*4+2] !in groupWinners &&
            flagsSelected[groupId*4+3] !in groupWinners) {

            var winner = (0..10000).random()
            if(winner<2500) winner = 0 else if(winner<5000) winner=1 else if(winner<7500) winner=2 else winner=3
            val first = winner


            var second = first
            while(second==first){
                var winner = (0..10000).random()
                if(winner<2500) winner = 0 else if(winner<5000) winner=1 else if(winner<7500) winner=2 else winner=3
                second = winner
            }

            val list: MutableList<Flag> = arrayListOf()
            groupWinners.forEach{list.add(it)}

            list.add(flagsSelected[groupId*4+first])
            list.add(flagsSelected[groupId*4+second])

            groupWinners=list
            return true
        } else return false

    }

    fun getWinnersFromEight(): Boolean{
        val list: MutableList<Flag> = arrayListOf()

        if(eightWinners.isEmpty()){
            for(index in 0 .. groupWinners.size-1 step 2) {
                var winner = (0..10000).random()
                if(winner>5000) winner = 1 else winner=0
                list.add(groupWinners[index+winner])
            }

            eightWinners = list
            return true
        }

        return false
    }

    fun getWinnersFromFour(): Boolean{
        val list: MutableList<Flag> = arrayListOf()

        if(fourWinners.isEmpty()){
            for(index in 0 .. eightWinners.size-2 step 2) {
                var winner = (0..10000).random()
                if(winner>5000) winner = 1 else winner=0
                list.add(eightWinners[index+winner])
            }

            fourWinners = list
            return true
        }

        return false
    }

    fun getWinnersFromTwo(): Boolean{
        val list: MutableList<Flag> = arrayListOf()

        if(twoWinners.isEmpty()){
            for(index in 0 .. fourWinners.size-2 step 2) {
                var winner = (0..10000).random()
                if(winner>5000) winner = 1 else winner=0
                list.add(fourWinners[index+winner])
            }

            twoWinners = list

            if(fourWinners[0] !in twoWinners) third = fourWinners[0]
            else if(fourWinners[1] !in twoWinners) third = fourWinners[1]
            else if(fourWinners[2] !in twoWinners) third = fourWinners[2]
            else if(fourWinners[3] !in twoWinners) third = fourWinners[3]

            return true
        }

        return false
    }

    fun getWinner(): Boolean{
        if(first.name=="Null"){
            var winner = (0..10000).random()
            if(winner>5000) winner = 1 else winner=0
            first = twoWinners[winner]
            if(winner==0) second = twoWinners[1] else second=twoWinners[0]

            return true
        }

        return false
    }



}