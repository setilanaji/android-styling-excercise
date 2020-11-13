package com.ydh.androiddesignstyle.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ydh.androiddesignstyle.R
import com.ydh.androiddesignstyle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            buttonOne.setOnClickListener(this@MainActivity)
            buttonTwo.setOnClickListener(this@MainActivity)
            buttonThree.setOnClickListener(this@MainActivity)
            buttonFour.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_one -> startActivity(Intent(this, FirstActivity::class.java))
            R.id.button_two -> startActivity(Intent(this, SecondActivity::class.java))
            R.id.button_three ->  startActivity(Intent(this, ThirdActivity::class.java))
            R.id.button_four ->  startActivity(Intent(this, FourthActivity::class.java))
        }
    }
}