package br.com.dio.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.recyclerview.adapter.AdapterMovies
import br.com.dio.recyclerview.databinding.ActivityMainBinding
import br.com.dio.recyclerview.model.MovieModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapterMovies: AdapterMovies
    private val moviesList: MutableList<MovieModel> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}