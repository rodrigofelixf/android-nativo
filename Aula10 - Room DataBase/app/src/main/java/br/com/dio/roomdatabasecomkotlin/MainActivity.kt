package br.com.dio.roomdatabasecomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.roomdatabasecomkotlin.database.AppDatabase
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var database : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.binding.root)
    }
}