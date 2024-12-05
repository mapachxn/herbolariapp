package com.example.yollotl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetalleRemedioFragment : Fragment() {

    companion object {
        fun newInstance(nombre: String, descripcion: String, imagen: Int): DetalleRemedioFragment {
            val fragment = DetalleRemedioFragment()
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("descripcion", descripcion)
            args.putInt("imagen", imagen)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_remedio, container, false)

        // Obtener argumentos y asignarlos a los elementos de la vista
        val nombre = arguments?.getString("nombre")
        val descripcion = arguments?.getString("descripcion")
        val imagen = arguments?.getInt("imagen")

        view.findViewById<TextView>(R.id.detalleNombre).text = nombre
        view.findViewById<TextView>(R.id.detalleDescripcion).text = descripcion
        view.findViewById<ImageView>(R.id.detalleImagen).setImageResource(imagen ?: 0)

        return view
    }
}
