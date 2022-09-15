package com.example.fakebot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakebot.databinding.ItemMessageBinding

class MensajeAdapter(val listaMensajes:MutableList<Mensaje>):RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder>() {


    inner class MensajeViewHolder(private var binding: com.example.fakebot.databinding.ItemMessageBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(mensaje:Mensaje){
            binding.mensaje.text = mensaje.mensaje
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeViewHolder {
        val binding= ItemMessageBinding.inflate(LayoutInflater.from(parent.context))
        return MensajeViewHolder(binding)
        }

    override fun onBindViewHolder(holder: MensajeViewHolder, position: Int) {
            val mensaje= listaMensajes[position]
            holder.bind(mensaje)


      }

    override fun getItemCount() = listaMensajes.size
}