package br.com.dio.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.dio.mvvm.adapters.MainAdapter
import br.com.dio.mvvm.databinding.ActivityMainBinding
import br.com.dio.mvvm.repositories.MainRepository
import br.com.dio.mvvm.rest.RetrofitService
import br.com.dio.mvvm.viewmodel.main.MainViewModel
import br.com.dio.mvvm.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var viewModel: MainViewModel

    // aqui retorna a intencia da api
    private val retrofitService = RetrofitService.getInstance()


    // aqui passa quando acontece o click
    private val adapter = MainAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        viewModel.liveList.observe(this, Observer { lives ->
            Log.i("Rodrigo", "OnStart")
            adapter.setLiveList(lives)
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllLives()
    }
}