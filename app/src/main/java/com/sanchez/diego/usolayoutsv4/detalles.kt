package com.sanchez.diego.usolayoutsv4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sanchez.diego.usolayoutsv4.databinding.ActivityDetallesBinding

class detalles : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesBinding

    private val NAME_KEY = "NAME_KEY"
    private val NUMBER_KEY = "NUMBER_KEY"
    private val PRODUCT_KEY = "PRODUCT_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setInformation(intent.extras)
    }

    private fun setInformation(bundle: Bundle?) {
        if (bundle != null) {
            binding.tvNombre.text = "Nombre: ${bundle.getString(NAME_KEY)}"
            binding.tvNumero.text = "Número: ${bundle.getString(NUMBER_KEY)}"
            binding.tvProducto.text = "Producto: ${bundle.getString(PRODUCT_KEY)}"
            binding.tvCiudad.text = "Ciudad: ${bundle.getString(CITY_KEY)}"
            binding.tvDireccion.text = "Dirección: ${bundle.getString(ADDRESS_KEY)}"
        }
    }
}
