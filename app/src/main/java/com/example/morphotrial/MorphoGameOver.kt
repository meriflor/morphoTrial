package com.example.morphotrial

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.content.res.AssetFileDescriptor
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.provider.MediaStore


class MorphoGameOver : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morpho_game_over)

        val urScore: TextView = findViewById(R.id.urScore)
        val hiScore: TextView = findViewById(R.id.hiScore)
        val gameText: TextView = findViewById(R.id.gameText)
        val tryAgain: TextView = findViewById(R.id.tryAgain)
        val yesText: TextView = findViewById(R.id.yesText)
        val noText: TextView = findViewById(R.id.noText)

        val type = Typeface.createFromAsset(assets, "fonts/mymodular_pixels.ttf")
        urScore.typeface = type
        hiScore.typeface = type
        gameText.typeface = type
        tryAgain.typeface = type
        yesText.typeface = type
        noText.typeface = type

        val score = intent.getIntExtra("score", 0)
        val prefs = getSharedPreferences(
            "Morpho",
            Context.MODE_PRIVATE)
        val highScore = prefs.getInt("highScore", 0)

        //Guboooooooot ginoo ko gabalik2 lamang kapuy search haha
        if(score >= highScore){
            gameText.text = "CONGRATULATIONS!!"
            urScore.text = score.toString()
            hiScore.text = "You have surpassed your limits!"
            val congrats: MediaPlayer = MediaPlayer.create(this, R.raw.congrats)
            congrats.start()
        }else{
            val failed: MediaPlayer = MediaPlayer.create(this, R.raw.failed)
            failed.start()
            urScore.text = score.toString()
            hiScore.text = "Highest Score: $highScore"
        }
    }

    fun yesText(view: View) {
        val player: MediaPlayer = MediaPlayer.create(this, R.raw.tap)
        player.start()
        intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun noText(view: View) {
        val player: MediaPlayer = MediaPlayer.create(this, R.raw.tap)
        player.start()
        this.finishAffinity()
    }
}