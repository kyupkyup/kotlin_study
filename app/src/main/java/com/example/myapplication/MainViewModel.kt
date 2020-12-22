package com.example.myapplication

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "todo").allowMainThreadQueries().build()

    lateinit var users: LiveData<List<User>>

    var newUser : String? = null

    init{
        users = getAll()
    }

    fun getAll(): LiveData<List<User>> {
        return db.userDAO().getAll()
    }

    fun insert(user: String) {
        viewModelScope.launch { Dispatchers.IO }
        db.userDAO().insertAll(User(user))
    }

}