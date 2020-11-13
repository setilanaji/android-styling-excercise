package com.ydh.androiddesignstyle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.ydh.androiddesignstyle.R
import com.ydh.androiddesignstyle.databinding.ActivityDetailProductBinding
import com.ydh.androiddesignstyle.databinding.ActivityThirdBinding

class DetailProductActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.extras?.getInt("id")
        val title = intent.extras?.getString("title")
        val category = intent.extras?.getString("category")
        val price = intent.extras?.getString("price")
        val des = intent.extras?.getString("description")
        val imgUrl = intent.extras?.getString("url")


        binding.run {
            tvDetailProductTitle.text = title
            tvDetailProductCategory.text = category
            tvDetailProductPrice.text = price
            tvDetailProductDesc.text = des
            Glide.with(this@DetailProductActivity).load(imgUrl).override(
                Target.SIZE_ORIGINAL,
                Target.SIZE_ORIGINAL
            ).into(imageDetailProduct)
        buttonBack.setOnClickListener{
            onBackPressed()
        }}

    }
}