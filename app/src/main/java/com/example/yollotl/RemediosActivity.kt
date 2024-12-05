package com.example.yollotl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RemediosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remedios)

        // Configuración del botón para regresar al menú principal
        val btnMenuPrincipal = findViewById<Button>(R.id.btnMenuPrincipalRemedios)
        btnMenuPrincipal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
        }

        // Lista de remedios (agrega más según sea necesario)
        val remedios = listOf(
            Remedio("Té de manzanilla", "Alivia el estrés y ayuda con la digestión.", R.drawable.te_manzanilla),
            Remedio("Té de bugambilia con limón", "Alivia la tos y mejora el resfriado.", R.drawable.te_bugambilia),
            Remedio("Polvo de menta", "Refrescante y útil para el malestar estomacal.", R.drawable.polvo_menta),
            Remedio("Infusión de árnica seca", "Reduce inflamaciones y calma dolores.", R.drawable.infusion_arnica),
            Remedio("Té de jengibre y limón", "Mejora el sistema inmune y alivia el malestar general", R.drawable.te_jengibre),
            Remedio("Concentrado de tomillo", "Útil para infecciones respiratorias", R.drawable.concentrado_tomillo)
        )

        // Configuración del RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRemedios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RemedioAdapter(remedios) { remedio ->
            // Reemplazar el contenedor con los detalles del remedio seleccionado
            val fragment = DetalleRemedioFragment.newInstance(
                remedio.nombre,
                remedio.descripcion,
                remedio.imagen
            )

            // Asegúrate de usar el contenedor correcto para el fragmento
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmento, fragment) // Reemplaza el contenedor del fragmento
                .addToBackStack(null) // Permite regresar al listado con el botón atrás
                .commit()
        }
    }
}
