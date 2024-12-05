package com.example.yollotl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RemedioAdapter(
    private val remedios: List<Remedio>,
    private val onItemClick: (Remedio) -> Unit
) : RecyclerView.Adapter<RemedioAdapter.RemedioViewHolder>() {

    inner class RemedioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen = itemView.findViewById<ImageView>(R.id.imagenRemedio)
        val nombre = itemView.findViewById<TextView>(R.id.nombreRemedio)

        fun bind(remedio: Remedio) {
            imagen.setImageResource(remedio.imagen)
            nombre.text = remedio.nombre
            itemView.setOnClickListener { onItemClick(remedio) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_remedio, parent, false)
        return RemedioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemedioViewHolder, position: Int) {
        holder.bind(remedios[position])
    }

    override fun getItemCount(): Int = remedios.size
}
