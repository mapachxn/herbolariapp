package com.example.yollotl // Asegúrate de reemplazar 'com.tu_paquete.yollotl' con el paquete de tu proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.yollotl.MainActivity // Importa MainActivity si está en Java

class IntroActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2)

        // Botón para regresar a IntroActivity1
        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            finish() // Cierra esta actividad y regresa a IntroActivity1
        }

        // Botón para ir al menú principal (MainActivity)
        val menuButton: Button = findViewById(R.id.btn_menu)
        menuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Verifica que MainActivity esté accesible en el proyecto
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish() // Cierra IntroActivity2 para después abrir el menú principal
        }
    }
}
