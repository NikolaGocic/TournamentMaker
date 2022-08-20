package com.apptour23ma.ker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.unit.*
import com.apptour23ma.ker.data.Flag2RoomDatabase
import com.apptour23ma.ker.ui.MainScreenComposable
import com.apptour23ma.ker.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mainViewModel: MainViewModel by viewModels()

        setContent {
            MainScreenComposable(mainViewModel = mainViewModel)
        }
    }
}


