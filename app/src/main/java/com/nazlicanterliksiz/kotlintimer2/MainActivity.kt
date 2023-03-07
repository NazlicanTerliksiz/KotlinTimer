package com.nazlicanterliksiz.kotlintimer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
//import android.widget.TextView
import android.os.Looper
import android.view.View
import com.nazlicanterliksiz.kotlintimer2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable { }
    var handler : Handler = Handler(Looper.getMainLooper())

    private lateinit var binding: ActivityMainBinding
    //private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //textView = findViewById<TextView>(R.id.textView)
    }

    fun start(view: View){
        number=0

        runnable = object : Runnable {
            override fun run() {

                number = number + 1
                binding.textView.text= "Time : $number"

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }

    fun stop(view: View){
        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = "Time: 0"

    }

}