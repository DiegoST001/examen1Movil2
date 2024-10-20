package com.sanchez.diego.usolayoutsv4

import android.content.Intent
import android.net.Uri
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
        observeButtons(intent.extras)
    }

    private fun setInformation(bundle: Bundle?) {
        if (bundle != null) {
            binding.tvNombre.text = "Nombre: ${bundle.getString(NAME_KEY)}"
            binding.tvNumero.text = "Número: ${bundle.getString(NUMBER_KEY)}"
            binding.tvProducto.text = "Producto: ${bundle.getString(PRODUCT_KEY)}"
            binding.tvUbicacion.text = "Ubicación: ${bundle.getString(CITY_KEY)}"
            binding.tvUbicacion.text = "Dirección: ${bundle.getString(ADDRESS_KEY)}"
        }
    }

    private fun observeButtons(bundle: Bundle?) {
        binding.ivWsp.setOnClickListener {
            goWhatsApp(bundle)
        }

        binding.ivLlamar.setOnClickListener {
            goDial(bundle)
        }

        binding.Maps.setOnClickListener {
            openMaps(bundle)
        }
    }

    private fun goWhatsApp(bundle: Bundle?) {
        val phone = "+51${bundle?.getString(NUMBER_KEY)}"
        val message = "Hola, he realizado un pedido con los siguientes detalles."
        val intentWsp = Intent(Intent.ACTION_VIEW)
        intentWsp.data = Uri.parse("https://wa.me/$phone?text=$message")
        startActivity(intentWsp)
    }

    private fun goDial(bundle: Bundle?) {
        val phone = bundle?.getString(NUMBER_KEY)
        val intentDial = Intent(Intent.ACTION_DIAL)
        intentDial.data = Uri.parse("tel:$phone")
        startActivity(intentDial)
    }

    private fun openMaps(bundle: Bundle?) {
        val address = bundle?.getString(ADDRESS_KEY)
        val uri = Uri.parse("geo:0,0?q=$address")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }
}
