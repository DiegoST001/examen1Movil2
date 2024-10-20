package com.sanchez.diego.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ejecrcicio02 : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etNumero: EditText
    private lateinit var etProducto: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etDireccion: EditText
    private lateinit var btnEnviar: Button

    private val NAME_KEY = "NAME_KEY"
    private val NUMBER_KEY = "NUMBER_KEY"
    private val PRODUCT_KEY = "PRODUCT_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejecrcicio02)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa los EditText y el botón
        etNombre = findViewById(R.id.etNombre)
        etNumero = findViewById(R.id.etNumero)
        etProducto = findViewById(R.id.etProducto)
        etCiudad = findViewById(R.id.etCiudad)
        etDireccion = findViewById(R.id.etDireccion)
        btnEnviar = findViewById(R.id.btnEnviar)

        // Establece el listener para el botón
        btnEnviar.setOnClickListener {
            goDetailActivity()
        }
    }

    private fun goDetailActivity() {
        // Obtiene los datos de los EditText
        val nombre = etNombre.text.toString()
        val numero = etNumero.text.toString()
        val producto = etProducto.text.toString()
        val ciudad = etCiudad.text.toString()
        val direccion = etDireccion.text.toString()

        // Crea el Intent para ir a la actividad de detalles
        val intent = Intent(this, detalles::class.java)

        // Envía los datos al Intent
        intent.putExtra(NAME_KEY, nombre)
        intent.putExtra(NUMBER_KEY, numero)
        intent.putExtra(PRODUCT_KEY, producto)
        intent.putExtra(CITY_KEY, ciudad)
        intent.putExtra(ADDRESS_KEY, direccion)

        // Inicia la actividad de detalles
        startActivity(intent)
    }
}
