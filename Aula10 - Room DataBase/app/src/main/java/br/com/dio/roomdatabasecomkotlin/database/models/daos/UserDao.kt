package br.com.dio.roomdatabasecomkotlin.database.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.dio.roomdatabasecomkotlin.database.models.User

// serve para salvar os dados, tirar os dados ou obter os dados.
@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)


    @Query("SELECT COUNT(uid) FROM USER")
    suspend fun getTotalItems() : Long
}