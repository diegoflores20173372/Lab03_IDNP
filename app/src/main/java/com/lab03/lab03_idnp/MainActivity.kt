package com.lab03.lab03_idnp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.lab03.lab03_idnp.PatientActivity.Companion.ARRAY

class MainActivity : AppCompatActivity() {

    var patientData = arrayOf<String>("", "", "", "")
    var patientVisit = arrayOf<String>("", "", "", "")

    private val infoPatient = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ arrayPatientData: ActivityResult ->
        if (arrayPatientData.resultCode == RESULT_OK){
            patientData = arrayPatientData.data!!.extras!![ARRAY] as Array<String>
            Toast.makeText(this, "Se actualizó paciente", Toast.LENGTH_SHORT).show()
            setData(patientData)
        }
        else{
            Toast.makeText(this, "Sin cambios", Toast.LENGTH_SHORT).show()
        }
    }

    private val dataVisit = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ arrayVisitData: ActivityResult ->
        if (arrayVisitData.resultCode == RESULT_OK){
            patientVisit = arrayVisitData.data!!.extras!![ARRAY] as Array<String>
            Toast.makeText(this, "Se actualizó datos de paciente", Toast.LENGTH_SHORT).show()
            setData(patientVisit)
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

        val btnVisitData = findViewById<Button>(R.id.btnVisitData)

        btnVisitData.setOnClickListener{
            val intent = Intent(this, VisitActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, patientData[0])
            }
            dataVisit.launch(intent)
        }

        val btnSendMessage = findViewById<ImageButton>(R.id.btnSendMessage)

        btnSendMessage.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(patientData[3]))
                putExtra(Intent.EXTRA_SUBJECT, "Programar Visita Médica")
                putExtra(Intent.EXTRA_TEXT, "Necesitamos programar una cita médica...")
            }

            startActivity(intent)
        }

        setData(patientData)

    }

    private fun setData(tempPatientData: Array<String>){
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

}