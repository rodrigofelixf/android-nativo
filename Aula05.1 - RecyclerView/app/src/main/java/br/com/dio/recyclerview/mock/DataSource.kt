package br.com.dio.recyclerview.mock

import br.com.dio.recyclerview.model.Movies

class DataSource {

    companion object {
         fun createDataSet(): ArrayList<Movies> {
             val list = ArrayList<Movies>()
             list.add(
                 Movies(
                     "Avengers",
                     "2012"
                 )
             )
             list.add(
                 Movies(
                     "Spider-Man",
                     "2002"
                 )
             )
             return list

         }
    }
}