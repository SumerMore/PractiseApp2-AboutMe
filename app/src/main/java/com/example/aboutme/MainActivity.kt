package com.example.aboutme
import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
private val myName:MyName= MyName("Sumer More")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName =myName
        binding.donebutton.setOnClickListener {
            addNickname(it)
        }

    }
    private fun addNickname(view: View){
        binding.apply {
        //nicknameText.text = binding.nicknameEdit.text
        myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
        donebutton.visibility= View.GONE
        nicknameText.visibility=View.VISIBLE
        }

        //HIDE KEYBOARD
        val imm =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
