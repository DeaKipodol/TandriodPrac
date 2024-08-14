package com.chobo.practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var timerTask : Timer? = null
        var isRunning = false
        var sec : Int = 0
        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)

        btn.setOnClickListener{
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = kotlin.concurrent.timer(period = 1000) {
                    sec++
                    runOnUiThread {
                        tv.text = sec.toString()
                    }
                }
            } else {
                timerTask?.cancel()
            }
        }
    }
}