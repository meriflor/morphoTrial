package com.example.morphotrial

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MorphoGameOver : Activity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morpho_game_over)

        var urScore: TextView = findViewById(R.id.urScore)
        var hiScore: TextView = findViewById(R.id.hiScore)
        var gameText: TextView = findViewById(R.id.gameText)
        var tryAgain: TextView = findViewById(R.id.tryAgain)
        var yesText: TextView = findViewById(R.id.yesText)
        var noText: TextView = findViewById(R.id.noText)

        val type = Typeface.createFromAsset(assets, "fonts/mymodular_pixels.ttf")
        urScore.typeface = type
        hiScore.typeface = type
        gameText.typeface = type
        tryAgain.typeface = type
        yesText.typeface = type
        noText.typeface = type


        var score = intent.getIntExtra("score", 0)
        val prefs = getSharedPreferences(
            "Kotlin Invaders",
            Context.MODE_PRIVATE)
        var highScore = prefs.getInt("highScore", 0)

        if(score > highScore){
            gameText.text = "CONGRATULATIONS!!"
            urScore.text = score.toString()
            hiScore.text = "You have surpassed your limits!"
        }else{
            urScore.text = score.toString()
            hiScore.text = "Highest Score: $highScore"
        }
    }

    fun yesText(view: View) {
        intent = Intent(this, MorphoGameActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun noText(view: View) {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}