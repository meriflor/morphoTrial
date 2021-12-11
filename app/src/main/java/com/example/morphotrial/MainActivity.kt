package com.example.morphotrial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.graphics.Typeface

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var title: TextView = findViewById(R.id.titleMorpho)
        var play: TextView = findViewById(R.id.playText)

        val type = Typeface.createFromAsset(assets, "fonts/mymodular_pixels.ttf")
        title.typeface = type
        play.typeface = type

    }

    fun startGame(view: View) {
        val intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
}