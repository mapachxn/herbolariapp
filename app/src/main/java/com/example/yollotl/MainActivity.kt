package com.example.yollotl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración del botón "Almanaque" para navegar a AlmanaqueActivity
        val btnAlmanaque: Button = findViewById(R.id.btn_almanaque)
        btnAlmanaque.setOnClickListener {
            val intent = Intent(this, AlmanaqueActivity::class.java)
            startActivity(intent)
        }

        // Configuración del botón "Remedios" o cualquier otra lógica adicional
        val btnRemedios: Button = findViewById(R.id.btn_remedios)
        btnRemedios.setOnClickListener {
            // Aquí puedes agregar la lógica para navegar a otra actividad o realizar otra acción
        }
    }
}
