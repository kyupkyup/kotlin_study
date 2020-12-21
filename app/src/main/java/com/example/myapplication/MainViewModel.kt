package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "todo").allowMainThreadQueries().build()

    fun getAll(): LiveData<List<User>> {
        return db.userDAO().getAll()
    }

    fun insert(user: User) {
        db.userDAO().insertAll(user)
    }

}