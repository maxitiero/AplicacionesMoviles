package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var nombreUsuario:TextView
    lateinit var contraseña:TextView
    lateinit var ingresar:Button
    lateinit var registrarse:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nombreUsuario=findViewById(R.id.nameUserText)
        contraseña=findViewById(R.id.passwordText)
        ingresar=findViewById(R.id.registrarsePantalla)
        registrarse=findViewById(R.id.)
    }

    public void irIngresar(View view)
}