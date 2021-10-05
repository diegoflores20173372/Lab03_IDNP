package com.lab03.lab03_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class VisitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit)

        /** Capturing the dni from the MainActivity */
        val dni = intent.getStringExtra(EXTRA_MESSAGE)

        /** Print the dni */
        val txtDNIView = findViewById<TextView>(R.id.txtDNIView).apply {
            text = dni
        }

        var weight = findViewById<EditText>(R.id.edtWeight)
        var temperature = findViewById<EditText>(R.id.edtTemperature)
        var pressure = findViewById<EditText>(R.id.edtPressure)
        var saturation = findViewById<EditText>(R.id.edtSaturation)

        val btnSave_2 = findViewById<Button>(R.id.btnSave_2)
        val btnCancel_2 = findViewById<Button>(R.id.btnCancel_2)

        btnSave_2.setOnClickListener{
            setResult(RESULT_OK, Intent().apply {
                this.putExtra(PatientActivity.ARRAY, arrayOf(weight.text.toString() + "kg", temperature.text.toString() + "C°", pressure.text.toString() + "mmHg", saturation.text.toString() + "%"))
            })
            finish()
        }

        btnCancel_2.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}