package com.lab03.lab03_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.service.autofill.TextValueSanitizer
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val patientData = arrayOf("73641789", "Diego Flores Camargo", "Calle Tarapaca 208 Miraflores", "dflorescam@unsa.edu.pe")
    val patientVisit = arrayOf("70kg", "73C", "110mmHg", "95%")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtDNI = findViewById<TextView>(R.id.txtDNI).apply {
            text = patientData[0]
        }

        val txtFullName = findViewById<TextView>(R.id.txtFullName).apply {
            text = patientData[1]
        }

        val txtDirection = findViewById<TextView>(R.id.txtDirection).apply {
            text = patientData[2]
        }

        val txtEmail = findViewById<TextView>(R.id.txtEmail).apply {
            text = patientData[3]
        }

        val txtWeight = findViewById<TextView>(R.id.txtWeight).apply {
            text = patientVisit[0]
        }

        val txtTemperature = findViewById<TextView>(R.id.txtTemperature).apply {
            text = patientVisit[1]
        }

        val txtPressure = findViewById<TextView>(R.id.txtPressure).apply {
            text = patientVisit[2]
        }

        val txtSaturation = findViewById<TextView>(R.id.txtSaturation).apply {
            text = patientVisit[3]
        }

    }

    /** We call the activity for the button to the patient */
    fun patientViewButton(view: View){
        val intent = Intent(this, PatientActivity::class.java).apply {

        }
        startActivity(intent)
    }

    /** We call the activity for the button to the visit of the patient */
    fun visitPatientButton(view: View){
        val dni = patientData.get(0)
        val intent = Intent(this, VisitActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, dni)
        }
        startActivity(intent)
    }

}