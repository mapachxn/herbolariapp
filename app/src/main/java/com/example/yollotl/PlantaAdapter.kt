package com.example.yollotl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.util.Log

class PlantaAdapter(private var plantas: List<Planta>) : RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder>() {

    fun updatePlantas(nuevasPlantas: List<Planta>) {
        plantas = nuevasPlantas
        notifyDataSetChanged()
        Log.d("PlantaAdapter", "Plantas updated: ${plantas.size}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planta, parent, false)
        return PlantaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantaViewHolder, position: Int) {
        val planta = plantas[position]
        holder.bind(planta)
        Log.d("PlantaAdapter", "Binding planta at position $position: ${planta.nombre}")
    }

    override fun getItemCount(): Int = plantas.size

    class PlantaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        private val imagenImageView: ImageView = itemView.findViewById(R.id.imagenImageView)

        fun bind(planta: Planta) {
            nombreTextView.text = planta.nombre
            descripcionTextView.text = planta.descripcion
            Glide.with(itemView.context)
                .load(planta.imagen)
                .into(imagenImageView)
        }
    }
}
