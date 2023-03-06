package br.com.dio.roomdatabasecomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.roomdatabasecomkotlin.database.AppDatabase
import br.com.dio.roomdatabasecomkotlin.database.models.daos.UserDao
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityMainBinding
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNewUserBinding.inflate(layoutInflater) }
    private lateinit var database : AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.binding.root)

        // implementa o database da classe data base passando o contexto
        this.database = AppDatabase.getInstance(this)

        this.userDao = this.database.userDao()
    }

    override fun onStart() {
        super.onStart()

        this.binding.btnSave.setOnClickListener {

        }
    }
}