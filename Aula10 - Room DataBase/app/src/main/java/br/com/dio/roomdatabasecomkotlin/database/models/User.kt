package br.com.dio.roomdatabasecomkotlin.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Determinei que aqui e' a minha tabela
@Entity
data class User(

    // Determinei o  nome de cada coluna separada por _ seguindo os padroes
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String
){
    // deixando uma chave primaria e gerando um id automaticamente para cada registro
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
