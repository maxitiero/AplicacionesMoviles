package com.example.login

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
//import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BienvenidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenido)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    val platformGroup = findViewById<RadioGroup>(R.id.platformGroup)
    val androidLogo = findViewById<ImageView>(R.id.androidLogo)
    val iosLogo = findViewById<ImageView>(R.id.iosLogo)
    val otherCheckbox = findViewById<CheckBox>(R.id.otherCheckbox)
    val otherPreferenceInput = findViewById<EditText>(R.id.otherPreferenceInput)

    platformGroup.setOnCheckedChangeListener { _, checkedId ->
        when (checkedId) {
            R.id.androidButton -> {
                androidLogo.visibility = View.VISIBLE
                iosLogo.visibility = View.GONE
            }
            R.id.iosButton -> {
                iosLogo.visibility = View.VISIBLE
                androidLogo.visibility = View.GONE
            }
        }
    }

    otherCheckbox.setOnCheckedChangeListener { _, isChecked ->
        otherPreferenceInput.visibility = if (isChecked) View.VISIBLE else View.GONE
    }
    }
}