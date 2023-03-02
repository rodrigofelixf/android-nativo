package br.com.dio.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.imc.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val peso = binding.editPeso.text.toString().toDouble()
            val estatura = binding.editAltura.text.toString().toDouble()
            val resultado = peso / (estatura * estatura)


            binding.textResultado.text = "Seu IMC e %.2f".format(resultado)
        }
    }

    override fun onResume() {
        super.onResume()




    }



}