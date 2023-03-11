package br.com.dio.mvvm.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.mvvm.repositories.MainRepository


// anotacoes no caderno ViewModel

// cola um metodo padrao da viewModel

// cria a view model passando a classe para ela

class MainViewModelFactory constructor(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}