package br.com.dio.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dio.recyclerview.adapter.AdapterMovies
import br.com.dio.recyclerview.databinding.ActivityMainBinding
import br.com.dio.recyclerview.model.Movies

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapterMovies: AdapterMovies
    private val moviesList: MutableList<Movies> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerViewMovies = binding.recyclerViewMovies
        recyclerViewMovies.layoutManager = LinearLayoutManager(this)

        recyclerViewMovies.setHasFixedSize(true)
        adapterMovies = AdapterMovies(this, moviesList)
        recyclerViewMovies.adapter = adapterMovies
    }

    override fun onStart() {
        super.onStart()
        itemsOfList()


    }

    private fun itemsOfList() {
        val avengerMovie = Movies(
            "Avengers",
        "2012")
        moviesList.add(avengerMovie)
    }

}