package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //DATA BINDIG DE VIEW
    //PRECISA AJUSTAR NO GRADLE BUILD, SÓ OLHAR LÁ
    //E ADICIONAR A TAG layout COMENDO TUDO NO XML
    //USADO PARA GANHAR PERFORMACE
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Gabriel Neri")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        /*button_done.setOnClickListener{
            addNickName(it)
        }*/
        binding.buttonDone.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        //APPLY PARA UMA 'MELHOR' VISUALIZAÇÃO DO CÓDIGO
        binding.apply {
            myName?.nickname = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textViewName.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
