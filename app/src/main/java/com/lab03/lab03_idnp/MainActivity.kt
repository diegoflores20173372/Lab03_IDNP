package com.lab03.lab03_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lab03.lab03_idnp.PatientActivity.Companion.ARRAY

class MainActivity : AppCompatActivity() {

    var patientData = arrayOf<String>("73641789", "Diego Flores Camargo", "Calle Tarapaca 208 Miraflores", "dflorescam@unsa.edu.pe")
    var patientVisit = arrayOf<String>("70kg", "73C", "110mmHg", "95%")

    private val infoPatient = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ arrayPatientData ->
        if (arrayPatientData.resultCode == RESULT_OK){
            //patientData = arrayPatientData.data?.getStringArrayExtra(ARRAY).orEmpty() as Array<String>
            Toast.makeText(this, "Se actualizó paciente", Toast.LENGTH_SHORT).show()
            Log.e("Array actualizado", patientData[0])
        }
        else{
            Toast.makeText(this, "Sin cambios", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewPatient = findViewById<Button>(R.id.btnNewPatient)

        btnNewPatient.setOnClickListener{
            val intent = Intent(this, PatientActivity::class.java)
            infoPatient.launch(intent)
        }

        var txtDNI = findViewById<TextView>(R.id.txtDNI).apply {
            text = patientData[0]
        }

        var txtFullName = findViewById<TextView>(R.id.txtFullName).apply {
            text = patientData[1]
        }

        var txtDirection = findViewById<TextView>(R.id.txtDirection).apply {
            text = patientData[2]
        }

        var txtEmail = findViewById<TextView>(R.id.txtEmail).apply {
            text = patientData[3]
        }

        var txtWeight = findViewById<TextView>(R.id.txtWeight).apply {
            text = patientVisit[0]
        }

        var txtTemperature = findViewById<TextView>(R.id.txtTemperature).apply {
            text = patientVisit[1]
        }

        var txtPressure = findViewById<TextView>(R.id.txtPressure).apply {
            text = patientVisit[2]
        }

        var txtSaturation = findViewById<TextView>(R.id.txtSaturation).apply {
            text = patientVisit[3]
        }

    }
/*
    /** We call the activity for the btnNewPatient to the visit of the patient */
    fun visitPatientButton(view: View){
        val dni = patientData.get(0)
        val intent = Intent(this, VisitActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, dni)
        }
        startActivity(intent)
    }
*/
}