package com.example.fakebot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakebot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var listaMensajeRespuestas:MutableList<Mensaje>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*val listaMensajeRespuestas:MutableList<Mensaje> = mutableListOf(Mensaje("Si"),Mensaje("No"),Mensaje("Pregunta de nuevo"),Mensaje("Es muy probable"),Mensaje("No lo creo"),Mensaje("No se"),Mensaje("Tal vez"),Mensaje("Desas algo mas?"),Mensaje("Hola que tal?"),Mensaje("Boca como te va??"),Mensaje("Hola que tal?"),Mensaje("Boca como te va??"),Mensaje("Hola que tal?"),Mensaje("Boca como te va??"),Mensaje("Bostero hijo de puta"),Mensaje("Te saluda tu papaaaa"))*/

        listaMensajeRespuestas= mutableListOf(Mensaje("Hola"))

        if (listaMensajeRespuestas.isEmpty()){
            binding.emptyviewText.visibility= View.VISIBLE
        }else{
            binding.emptyviewText.visibility= View.GONE
        }





        binding.recyclerview.layoutManager= LinearLayoutManager(this)

        val adapter= MensajeAdapter(listaMensajeRespuestas)
        binding.recyclerview.adapter=adapter

        binding.enviarMensaje.setOnClickListener {
            val capturoMensaje= binding.mensajeEnviado.text
            val mensaje=Mensaje(capturoMensaje.toString())
            listaMensajeRespuestas.add(mensaje)



            Log.d("MensajeEnv",mensaje.mensaje)
        }

    }
}