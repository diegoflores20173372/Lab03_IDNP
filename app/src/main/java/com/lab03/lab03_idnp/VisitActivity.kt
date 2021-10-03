package com.lab03.lab03_idnp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE

class VisitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit)

        /** Capturing the dni from the MainActivity */
        val dni = intent.getStringExtra(EXTRA_MESSAGE)



    }
}