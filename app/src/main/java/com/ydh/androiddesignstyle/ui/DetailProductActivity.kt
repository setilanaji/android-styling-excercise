package com.ydh.androiddesignstyle.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
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

        title = ""
        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        val actionBar: ActionBar? = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))
        actionBar!!.elevation = 0F
        actionBar.setBackgroundDrawable(colorDrawable)


        val id = intent.extras?.getInt("id")
        val title = intent.extras?.getString("title")
        val category = intent.extras?.getString("category")
        val price = intent.extras?.getString("price")
        val des = intent.extras?.getString("description")
        val imgUrl = intent.extras?.getString("url")


        binding.run {
            tvDetailProductTitle.text = title
            tvDetailProductCategory.text = category
            tvDetailProductPrice.text = "$ $price"
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