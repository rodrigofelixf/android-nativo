package br.com.dio.customviewskotlin.components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.dio.customviewskotlin.R
import br.com.dio.customviewskotlin.databinding.ResFollowersIndicatorBinding


// extend de LinerarLayout e implementa os parametros
class FollowersIndicator(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

// inflando a custom view creada passando o contexto do parametro e o this da classe com um true no final
    private val binding: ResFollowersIndicatorBinding = ResFollowersIndicatorBinding.inflate(
        LayoutInflater.from(context), this, true
    )


    // iniciando junto com a classe
    init {

        // criando objetivo atributo para atribuir valores da custom passando os parametros do attrs.xml
        val attibutes = context.obtainStyledAttributes(attrs, R.styleable.FollowersIndicator)
        this.binding.tvCounter.text = attibutes.getString(R.styleable.FollowersIndicator_counter)
        this.binding.tvIndicator.text = attibutes.getString(R.styleable.FollowersIndicator_indicador)


        // mudando o estilo das fontes usando boolean
        if (attibutes.getBoolean(R.styleable.FollowersIndicator_Bold, true)) {
            this.binding.tvCounter.typeface = Typeface.DEFAULT_BOLD
        } else {
            this.binding.tvCounter.typeface = Typeface.DEFAULT
        }

    }


}