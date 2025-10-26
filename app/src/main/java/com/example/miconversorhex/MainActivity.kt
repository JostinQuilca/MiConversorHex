// !! IMPORTANTE !! CAMBIA ESTA LÍNEA AHORA MISMO
package com.example.miconversorhex // <- PON TU PAQUETE AQUÍ (el que apuntaste en el Paso 1)

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // Declaramos las vistas
    private lateinit var etDecimal: TextInputEditText
    private lateinit var etHexadecimal: TextInputEditText
    private lateinit var btnDecimalAHex: Button
    private lateinit var btnHexADecimal: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Esto conecta con el XML

        // Inicializamos las vistas
        etDecimal = findViewById(R.id.etDecimal)
        etHexadecimal = findViewById(R.id.etHexadecimal)
        btnDecimalAHex = findViewById(R.id.btnDecimalAHex)
        btnHexADecimal = findViewById(R.id.btnHexADecimal)
        tvResultado = findViewById(R.id.tvResultado)

        // Configuramos el listener para el botón Decimal -> Hex
        btnDecimalAHex.setOnClickListener {
            convertirDecimalAHex()
        }

        // Configuramos el listener para el botón Hex -> Decimal
        btnHexADecimal.setOnClickListener {
            convertirHexADecimal()
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
            etHexadecimal.setText(valorHex)
            tvResultado.text = "Resultado: $valorHex"
        } catch (e: NumberFormatException) {
            tvResultado.text = "Error: Número decimal inválido."
        }
    }

    private fun convertirHexADecimal() {
        val inputHex = etHexadecimal.text.toString()
        if (inputHex.isEmpty()) {
            tvResultado.text = "Error: El campo hexadecimal está vacío."
            return
        }

        try {
            val valorDecimal = java.lang.Long.parseLong(inputHex, 16)
            etDecimal.setText(valorDecimal.toString())
            tvResultado.text = "Resultado: $valorDecimal"
        } catch (_: NumberFormatException) {
            tvResultado.text = "Error: Número hexadecimal inválido."
        }
    }
}