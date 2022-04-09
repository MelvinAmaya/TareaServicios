package com.example.tareaservicios

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val servicec = MostrarHora::class.java
        val i = Intent(applicationContext,servicec)

        btnIniciar.setOnClickListener{
            //btnIniciar.text="Funciona el onclick"
            if(!Servicestar(servicec)){
                startService(i)
                Toast.makeText(applicationContext,"El servicio se ha inicado", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext,"El servicio ya esta inicado",Toast.LENGTH_SHORT).show()
            }
        }

        btnStop.setOnClickListener {
            if(Servicestar(servicec)){
                stopService(i)
                Toast.makeText(applicationContext,"El servicio se detuvo", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Ya se detuvo el servicio",Toast.LENGTH_SHORT).show()
            }
        }

        btnEstado.setOnClickListener {
            if(Servicestar(servicec)){
                Toast.makeText(applicationContext,"El servicio esta corriendo", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext,"El servicio esta detenido",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun Servicestar(servicec: Class<*>): Boolean {
        val activityMan = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in activityMan.getRunningServices(Integer.MAX_VALUE)){
            return true
        }
        return false
    }
}