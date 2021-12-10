package com.example.morphotrial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(view: View) {
        val intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
}