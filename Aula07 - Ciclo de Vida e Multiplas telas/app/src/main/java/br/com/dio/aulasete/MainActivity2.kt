package br.com.dio.aulasete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.aulasete.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        // Recebe dados da activity anterior
        binding.textMain2.text = intent.getStringExtra("TEXT_VALUE")
    }
}