package com.ydh.androiddesignstyle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ydh.androiddesignstyle.ui.adapter.ProductAdapter
import com.ydh.androiddesignstyle.databinding.ActivityFourthBinding
import com.ydh.androiddesignstyle.model.ProductModel
import com.ydh.androiddesignstyle.viewmodel.ProductViewModel

class FourthActivity : AppCompatActivity() {

    lateinit var binding: ActivityFourthBinding
    lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
        setData()

    }

    private fun setViewModel(){
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
    }

    private fun setData() {
        productViewModel.setAllProduct()

        productViewModel.data.observe({ lifecycle }, {
            val productAdapter = ProductAdapter(this, it as MutableList<ProductModel>,
                object : ProductAdapter.PostItemListener {
                    override fun onPostClick(userModel: ProductModel) {
//                        val intent = Intent(this@FourthActivity, ::class.java)
//                        intent.putExtra("id", userModel.id)
//                        intent.putExtra("firstName", userModel.firstName)
//                        intent.putExtra("lastName", userModel.lastName)
//                        intent.putExtra("email", userModel.email)
//                        intent.putExtra("url", userModel.avatarImgUrl)
//                        startActivity(intent)
                    }

                })
            val recyclerView = binding.recyclerFourthProduct

            recyclerView.apply {
                this.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                this.adapter = productAdapter
            }
        })

        productViewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}