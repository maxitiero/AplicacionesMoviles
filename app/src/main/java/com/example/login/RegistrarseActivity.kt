package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val passwordEditText = findViewById<EditText>(R.id.contrasenaR)
        val passwordRepeatEditText = findViewById<EditText>(R.id.repetirContrasena)


        fun isValidEmail(correoEditText: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(correoEditText).matches()
        }

        registrarseBtn.setOnClickListener {
            // Validar que los campos no estén vacíos
            val nameUser = nameUserEditText.text.toString().trim()
            val correo = correoEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val passwordRepeat = passwordRepeatEditText.text.toString().trim()

            if (nameUser.isEmpty()) {
                nameUserEditText.error = "Debe ingresar un nombre de usuario"
                nameUserEditText.requestFocus()
                return@setOnClickListener
            }

            if (correo.isEmpty()) {
                correoEditText.error = "Debe ingresar un correo electronico"
                correoEditText.requestFocus()
                return@setOnClickListener
            } else if (!isValidEmail(correo)) {
                correoEditText.error = "El correo electronico es incorrecto"
                correoEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEditText.error = "Debe ingresar una contraseña"
                passwordEditText.requestFocus()
                return@setOnClickListener
            } else if (password.length < 6) {
                passwordEditText.error = "La contraseña debe tener al menos 6 caracteres"
                passwordEditText.requestFocus()
                return@setOnClickListener
            }

            if (passwordRepeat.isEmpty()) {
                passwordRepeatEditText.error = "Debe ingresar su contraseña nuevamente"
                passwordRepeatEditText.requestFocus()
                return@setOnClickListener
            } else if (passwordRepeat.length < 6) {
                passwordRepeatEditText.error =
                    "La contraseña ingresada debe tener al menos 6 caracteres"
                passwordRepeatEditText.requestFocus()
                return@setOnClickListener
            }
            if (password != passwordRepeat) {
                passwordRepeatEditText.error = "Las contraseñas deben ser iguales "
                passwordRepeatEditText.requestFocus()
                return@setOnClickListener
            }
            // Si todas las validaciones pasan, navegar a MainActivity
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


            }
        }
    }