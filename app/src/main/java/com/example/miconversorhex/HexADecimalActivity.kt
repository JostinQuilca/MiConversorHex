package com.example.miconversorhex // Asegúrate que sea tu paquete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class HexADecimalActivity : AppCompatActivity() {

    // Declaramos las vistas de esta pantalla
    private lateinit var etHexadecimal: TextInputEditText
    private lateinit var btnHexADecimal: Button
    private lateinit var tvResultadoHex: TextView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hex_adecimal)

        // Inicializamos las vistas
        etHexadecimal = findViewById(R.id.etHexadecimal)
        btnHexADecimal = findViewById(R.id.btnHexADecimal)
        tvResultadoHex = findViewById(R.id.tvResultadoHex)
        btnVolver = findViewById(R.id.btnVolver)

        // Configuramos el listener para el botón de conversión
        btnHexADecimal.setOnClickListener {
            convertirHexADecimal()
        }

        // Configuramos el listener para el botón de Volver
        btnVolver.setOnClickListener {
            finish() // Esto simplemente cierra esta pantalla y vuelve a la anterior
        }
    }

    private fun convertirHexADecimal() {
        val inputHex = etHexadecimal.text.toString()
        if (inputHex.isEmpty()) {
            tvResultadoHex.text = "Error: El campo hexadecimal está vacío."
            return
        }

        try {
            val valorDecimal = java.lang.Long.parseLong(inputHex, 16)
            tvResultadoHex.text = "Resultado: $valorDecimal"
        } catch (_: NumberFormatException) {
            tvResultadoHex.text = "Error: Número hexadecimal inválido."
        }
    }
}
