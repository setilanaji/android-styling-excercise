package com.ydh.androiddesignstyle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ydh.androiddesignstyle.R
import com.ydh.androiddesignstyle.databinding.ActivityFourthBinding
import com.ydh.androiddesignstyle.databinding.ActivityThirdBinding
import com.ydh.androiddesignstyle.model.ProductModel
import com.ydh.androiddesignstyle.ui.adapter.ProductAdapter
import com.ydh.androiddesignstyle.ui.adapter.ThirdProductAdapter
import com.ydh.androiddesignstyle.viewmodel.ProductViewModel

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding
    lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    private fun setViewModel(){
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
    }

    private fun setData() {
        productViewModel.setAllProduct()

        productViewModel.data.observe({ lifecycle }, {
            val productAdapter = ThirdProductAdapter(this, it as MutableList<ProductModel>,
                object : ThirdProductAdapter.PostItemListener {
                    override fun onPostClick(productModel: ProductModel) {
//                        val intent = Intent(this@FourthActivity, ::class.java)
//                        intent.putExtra("id", userModel.id)
//                        intent.putExtra("firstName", userModel.firstName)
//                        intent.putExtra("lastName", userModel.lastName)
//                        intent.putExtra("email", userModel.email)
//                        intent.putExtra("url", userModel.avatarImgUrl)
//                        startActivity(intent)
                    }

                })
            val recyclerView = binding.recyclerThirdProduct

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