package br.com.dio.roomdatabasecomkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dio.roomdatabasecomkotlin.database.models.User
import br.com.dio.roomdatabasecomkotlin.database.models.daos.UserDao


// aqui cria o banco de dados importa a entidade e define uma versao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun userDao(): UserDao

    companion object {

        private const val DATABASE_NAME: String = "nome-do-banco-de-dados"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()
    }


}