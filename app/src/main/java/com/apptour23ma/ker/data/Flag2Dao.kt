package com.apptour23ma.ker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Flag2Dao {

    @Query("SELECT * FROM flag2 ORDER BY id DESC")
    fun getAllFlags(): List<Flag2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(flag: Flag2)

}