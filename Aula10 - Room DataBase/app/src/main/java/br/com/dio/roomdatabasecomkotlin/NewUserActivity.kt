package br.com.dio.roomdatabasecomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.dio.roomdatabasecomkotlin.database.AppDatabase
import br.com.dio.roomdatabasecomkotlin.database.models.User
import br.com.dio.roomdatabasecomkotlin.database.models.daos.UserDao
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityMainBinding
import br.com.dio.roomdatabasecomkotlin.databinding.ActivityNewUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

            CoroutineScope(Dispatchers.IO).launch {
                val result = saveUser(
                    binding.edtFirstName.text.toString(),
                    binding.edtLastName.text.toString()
                )

                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@NewUserActivity,
                        if(result) "User Saved!" else "Error trying to save user",
                        Toast.LENGTH_LONG
                    ).show()
                    if (result)
                        finish()
                }
            }
        }
    }

    private suspend fun saveUser(firstName: String, lastName: String): Boolean {
        if (firstName.isBlank() || firstName.isEmpty())
            return false
        if (lastName.isBlank() || lastName.isEmpty())
            return false

        this.userDao.insert(User(firstName, lastName))

        return true
    }
}