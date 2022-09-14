package com.mistershorr.stopwatch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    // make a classwide static constant in Kotlin
    companion object {
        // all your static constants go here
        val TAG = "MainActivity"
    }

    lateinit var buttonStartStop: Button
    lateinit var buttonReset: Button
    lateinit var chronometer: Chronometer
    var isRunning = false
    var displayTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        wireWidgets()

        buttonStartStop.setOnClickListener {
            if(!isRunning) {
                chronometer.base = SystemClock.elapsedRealtime() - displayTime
                chronometer.start()
                buttonStartStop.text = "Stop"
                buttonStartStop.setBackgroundColor(Color.RED)
            } else {
                chronometer.stop()
                buttonStartStop.text = "Start"
                buttonStartStop.setBackgroundColor(Color.BLUE)
                displayTime = SystemClock.elapsedRealtime() - chronometer.base
            }
            isRunning = !isRunning
        }

        buttonReset.setOnClickListener {
            if(isRunning) {
                chronometer.stop()
                buttonStartStop.text = "Start"
                buttonStartStop.setBackgroundColor(Color.BLUE)
                isRunning = false
            }
            chronometer.base = SystemClock.elapsedRealtime()
            displayTime = 0L
        }


    }

    private fun wireWidgets() {
        buttonStartStop = findViewById(R.id.button_main_startStop)
        buttonReset = findViewById(R.id.button_main_reset)
        chronometer = findViewById(R.id.chronometer_main_stopwatch)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}