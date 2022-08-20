package com.apptour23ma.ker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.apptour23ma.ker.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Flag2::class], version = 1, exportSchema = false)
abstract class Flag2RoomDatabase : RoomDatabase() {

    abstract fun flagDao(): Flag2Dao

    companion object{
        @Volatile private var instance: Flag2RoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            Flag2RoomDatabase::class.java,
            "flagdb"
        ).build()

    }



}