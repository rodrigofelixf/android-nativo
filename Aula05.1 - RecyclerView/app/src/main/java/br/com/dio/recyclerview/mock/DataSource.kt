package br.com.dio.recyclerview.mock

import br.com.dio.recyclerview.model.MovieModel

class DataSource {

    companion object {
         fun createDataSet(): ArrayList<MovieModel> {
             val list = ArrayList<MovieModel>()
             list.add(
                 MovieModel(
                     "Avengers",
                     "2012"
                 )
             )
             list.add(
                 MovieModel(
                     "Spider-Man",
                     "2002"
                 )
             )
             return list

         }
    }
}