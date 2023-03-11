package br.com.dio.mvvm.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dio.mvvm.models.Live
import br.com.dio.mvvm.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// no construtor passamos o repositorio que abstrair dos dados Json
class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()


// aqui usa a funcao de chamada da funcao do repository que colocamos no construtor

    fun getAllLives() {
        val request = repository.getAllLives()

    // aqui chama um call back (execute isso quando vc terminar)

        request.enqueue(object : Callback<List<Live>>{
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                //aqui implementa a resposta  do que der certo
                liveList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                //aqui implementa se der errado
                errorMessage.postValue(t.message)


            }
        })



    }
}