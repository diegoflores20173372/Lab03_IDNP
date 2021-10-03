package com.lab03.lab03_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View

class MainActivity : AppCompatActivity() {

    val patientData = arrayOf("73641789", "Diego Flores Camargo", "Calle Tarapaca 208 Miraflores", "dflorescam@unsa.edu.pe")
    val patientVisit = arrayOf("70kg", "73C", "110mmHg", "95%")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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