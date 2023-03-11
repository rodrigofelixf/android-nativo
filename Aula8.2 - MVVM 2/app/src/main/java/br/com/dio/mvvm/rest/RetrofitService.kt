package br.com.dio.mvvm.rest

import br.com.dio.mvvm.models.Live
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    // aqui pega a url base e retorna uma lista de lives
    @GET("lista-lives.json")
    fun getAllLives(): Call<List<Live>>


    //pega a lista do link json e transforma em objetos
    companion object {

        private val retrofitService: RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        // retorna quando for inicializado uma vez
        fun getInstance(): RetrofitService {
            return retrofitService
        }
    }
}