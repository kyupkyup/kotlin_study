package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @ColumnInfo(name = "first_name")
    val firstName: String?

    ) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}