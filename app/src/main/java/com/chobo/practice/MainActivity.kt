package com.chobo.practiced

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import java.util.Timer
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var sec: Int = 0
        val tv: TextView = findViewById(R.id.tv_random)
        val tv_t: TextView = findViewById(R.id.tv_timer)
        val tv_p:TextView = findViewById(R.id.tv_point)
        val btn: Button = findViewById(R.id.btn_main)
        var isRunning = false
        var timerTask: Timer? = null

            val random_box = Random()
            val num = random_box.nextInt(1001)
            tv.text =((num.toFloat())/100).toString()


        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = kotlin.concurrent.timer(period = 10) {
                    sec++
                    runOnUiThread {
                        tv_t.text = (sec.toFloat() / 100).toString()
                    }
                }
            } else {
                timerTask?.cancel()
               val point= (kotlin.math.abs(sec - num)).toFloat()/100
                tv_p.text=point.toString()
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tv_point)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}