package br.com.dio.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dio.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var liveAdapter: LiveAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun initRecyclerView() {
        this.liveAdapter = LiveAdapter()

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = this.liveAdapter
    }
}