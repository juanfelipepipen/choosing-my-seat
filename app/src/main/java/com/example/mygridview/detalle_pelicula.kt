package com.example.mygridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula :TextView = findViewById(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)

        val ticketButton: Button = findViewById(R.id.compraTiket)
        val seatsTextView: TextView = findViewById(R.id.seatLeft)
        val boletos: String? = intent.getStringExtra("seats")


        Toast.makeText(this, "Boletos: " + boletos, Toast.LENGTH_LONG).show()

        ticketButton.setOnClickListener { view: View ->
            val intent = Intent(this, SeatSelection::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras;

        if(bundle!=null){
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsTextView.setText(boletos + " boletos disponibles")
        }
    }
}