package br.com.dio.aulasete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.aulasete.databinding.ActivityMain2Binding
import br.com.dio.aulasete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }



    override fun onResume() {
        super.onResume()


        //Passa dados para outra activity
        binding.bottomMain1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("TEXT_VALUE", binding.editText.text.toString())
            startActivity(intent)
        }
    }

}