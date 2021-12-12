package com.example.morphotrial

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.graphics.Typeface
import android.media.MediaPlayer




class MainActivity : Activity() {

    private var player: MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player = MediaPlayer.create(this, R.raw.opening_bg)
        player.start()

        var playText: TextView = findViewById(R.id.playText)

        val type1 = Typeface.createFromAsset(assets, "fonts/mymodular_pixels.ttf")
        playText.typeface = type1

    }

    fun startGame(view: View) {
        player.stop()
        player = MediaPlayer.create(this, R.raw.tap)
        player.start()
        val intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
}