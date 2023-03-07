package br.com.dio.roomdatabasecomkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.roomdatabasecomkotlin.database.AppDatabase
import br.com.dio.roomdatabasecomkotlin.database.models.User
import br.com.dio.roomdatabasecomkotlin.database.models.daos.UserDao
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
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

        loadTotalUsers()

        this.binding.buttonNewUser.setOnClickListener {

            openNewUserActivity()
        }
    }

    private fun openNewUserActivity() {
        val intent = Intent(this, NewUserActivity::class.java)
        startActivity(intent)
    }

    private fun loadTotalUsers() {
        this.binding.textView.text = "Carregando..."

        CoroutineScope(Dispatchers.IO).launch {
            val total = userDao.getTotalItems()

            withContext(Dispatchers.Main) {
                binding.textView.text = "Total de usuarios: $total"
            }


        }





    }


}