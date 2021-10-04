package com.lab03.lab03_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PatientActivity : AppCompatActivity() {

    companion object{
        const val ARRAY = "ARRAY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)

        var dni = findViewById<EditText>(R.id.edtDNI)
        var fullName = findViewById<EditText>(R.id.edtFullName)
        var direction = findViewById<EditText>(R.id.edtDirection)
        var email = findViewById<EditText>(R.id.edtEmail)

        val patientData = arrayOf(dni.text, fullName.text, direction.text, email.text)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSave.setOnClickListener{
            val intent = Intent()
            intent.putExtra(ARRAY, patientData)
            setResult(RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}