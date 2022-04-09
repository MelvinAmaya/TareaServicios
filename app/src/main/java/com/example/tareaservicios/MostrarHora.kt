package com.example.tareaservicios

import android.app.Service
import android.content.AsyncQueryHandler
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MostrarHora : Service() {
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler = Handler()
        runnable = Runnable {
            mostrarhoras()
            handler.postDelayed(runnable,3000)
        }
        handler.postDelayed(runnable,3000)
        return Service.START_STICKY
    }

    private fun mostrarhoras() {
        val hora = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currenthora = hora.format(Date())
        Toast.makeText(applicationContext,currenthora,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"El servicio esta apagado",Toast.LENGTH_LONG).show()
        handler.removeCallbacks(runnable)
    }
}