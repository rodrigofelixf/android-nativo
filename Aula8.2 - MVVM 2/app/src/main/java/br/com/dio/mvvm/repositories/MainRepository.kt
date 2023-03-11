package br.com.dio.mvvm.repositories

import br.com.dio.mvvm.rest.RetrofitService


// serve para abstrair a classe retrofit service, se eu precisar trocar,
// so preciso trocar aqui e nao em todo o codigo

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()


}