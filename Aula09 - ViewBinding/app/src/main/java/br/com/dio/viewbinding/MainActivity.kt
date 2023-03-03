package br.com.dio.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.binding.root)
    }

    override fun onStart() {
        super.onStart()


        this.binding.buttonContador.setOnClickListener {

            count++
            this.binding.textView.text = count.toString()
        }
    }


}