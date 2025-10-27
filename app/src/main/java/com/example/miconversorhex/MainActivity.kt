package com.example.miconversorhex // Asegúrate que sea tu paquete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // Declaramos las vistas de esta pantalla
    private lateinit var etDecimal: TextInputEditText
    private lateinit var btnDecimalAHex: Button
    private lateinit var tvResultado: TextView
    private lateinit var btnIrAHex: Button // Botón para ir a la otra pantalla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos las vistas
        etDecimal = findViewById(R.id.etDecimal)
        btnDecimalAHex = findViewById(R.id.btnDecimalAHex)
        tvResultado = findViewById(R.id.tvResultado)
        btnIrAHex = findViewById(R.id.btnIrAHex)

        // Configuramos el listener para el botón de conversión
        btnDecimalAHex.setOnClickListener {
            convertirDecimalAHex()
        }

        // Configuramos el listener para el botón de NAVEGACIÓN
        btnIrAHex.setOnClickListener {
            // Creamos un "Intent" para abrir la nueva Activity
            val intent = Intent(this, HexADecimalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun convertirDecimalAHex() {
        val inputDecimal = etDecimal.text.toString()
        if (inputDecimal.isEmpty()) {
            tvResultado.text = "Error: El campo decimal está vacío."
            return
        }

        try {
            val valorDecimal = inputDecimal.toLong()
            val valorHex = java.lang.Long.toHexString(valorDecimal).uppercase()
            tvResultado.text = "Resultado: $valorHex"
        } catch (e: NumberFormatException) {
            tvResultado.text = "Error: Número decimal inválido."
        }
    }
}
