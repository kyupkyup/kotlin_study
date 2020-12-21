package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert
    fun insertAll (vararg users: User)

    @Delete
    fun delete(user: User)
}