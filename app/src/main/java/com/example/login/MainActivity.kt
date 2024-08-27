package com.example.login
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val usuarioValido = "Juan Torres"
    private val passwordValida = "1234utn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun irIngresar(view: View) {
        val inputUsuario = findViewById<EditText> (R.id.nameUserL)
        val inputPassword = findViewById<EditText>(R.id.contrasenaL)
        val usuarioIngresado = inputUsuario.text.toString()
        val passwordIngresada = inputPassword.text.toString()

        if (usuarioIngresado == usuarioValido && passwordIngresada == passwordValida) {
            // Usuario y contraseña correctos, iniciar sesión
            val intent = Intent(this, BienvenidoActivity::class.java)
            startActivity(intent)
        } else {
            // Usuario o contraseña incorrectos, mostrar error
            //Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            //val rootView = findViewById<View>(android.R.id.content)
            //Snackbar.make(rootView, "Datos incorrectos", Snackbar.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Nombre de usuario o contraseña incorrectos")
            builder.setPositiveButton("Aceptar", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    fun irRegistrarse(view: View) {
        val intent = Intent(this, RegistrarseActivity::class.java)
        startActivity(intent)
    }
}