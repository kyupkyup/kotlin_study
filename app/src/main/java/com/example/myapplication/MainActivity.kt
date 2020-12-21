package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.result_text)
        val button : Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.todo_edit)

        val mainViewModel : MainViewModel by viewModels()

        mainViewModel.getAll().observe(this, Observer {users->
            textView.text = users.toString()
        } )

        button.setOnClickListener{
            mainViewModel.insert(User(editText.text.toString()))
        }
    }
}