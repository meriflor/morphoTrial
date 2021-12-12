package com.example.morphotrial

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.media.MediaPlayer


class MorphoGameOver : Activity() {

    private var player: MediaPlayer = MediaPlayer()

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

        if(score >= highScore){
            gameText.text = "CONGRATULATIONS!!"
            urScore.text = score.toString()
            hiScore.text = "New Record!"
            player = MediaPlayer.create(this, R.raw.congrats)
            player.start()
        }else{
            player = MediaPlayer.create(this, R.raw.failed)
            player.start()
            urScore.text = score.toString()
            hiScore.text = "Highest Score: $highScore"
        }
    }

    fun yesText(view: View) {
        player = MediaPlayer.create(this, R.raw.tap)
        player.start()
        intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun noText(view: View) {
        player = MediaPlayer.create(this, R.raw.tap)
        player.start()
        this.finishAffinity()
    }
}