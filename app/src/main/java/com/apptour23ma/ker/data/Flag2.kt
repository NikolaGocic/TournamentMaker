package com.apptour23ma.ker.data

import androidx.room.*

@Entity(tableName = "flag2")
data class Flag2(
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="resource") val resource: Int
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

