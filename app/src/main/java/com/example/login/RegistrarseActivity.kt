package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val correoEditText = findViewById<EditText>(R.id.correoElectronico)
        val nameUserEditText = findViewById<EditText>(R.id.nameUserR)
        val registrarseBtn = findViewById<Button>(R.id.registrarseR)

        registrarseBtn.setOnClickListener {
            // Validar que los campos no estén vacíos
            val nameUser = nameUserEditText.text.toString().trim()
            val correo = correoEditText.text.toString().trim()


            if (nameUser.isEmpty()) {
                nameUserEditText.error = "El nombre es obligatorio"
                nameUserEditText.requestFocus()
            }
            if (correo.isEmpty()) {
                correoEditText.error = "El correo electrónico es obligatorio"
                correoEditText.requestFocus()
            }
            // else {
                // Si ambos campos están llenos, continuar con el registro
               // Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                // Aquí va la lógica para registrar al usuario
            }
        }
    }


