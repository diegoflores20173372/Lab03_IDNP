package com.lab03.lab03_idnp

import Patient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    val patient = Patient(73641789, "Diego Flores Camargo", "Calle Tarapacá 208 Miraflores")

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
        val intent = Intent(this, VisitActivity::class.java).apply {

        }
        startActivity(intent)
    }

}