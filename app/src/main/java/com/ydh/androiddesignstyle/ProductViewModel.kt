package com.ydh.androiddesignstyle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    private val _data: MutableLiveData<List<ProductModel>> by lazy {
        MutableLiveData<List<ProductModel>>()
    }

    val data: LiveData<List<ProductModel>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response


    fun setAllProduct() {
        NetUtilProduct.apiService.getAllProduct()
            .enqueue(object : Callback<MutableList<ProductModel>> {
                override fun onResponse(
                    call: Call<MutableList<ProductModel>>,
                    response: Response<MutableList<ProductModel>>
                ) {
                    val productResponse = response.body() as MutableList<ProductModel>
                    _data.postValue(productResponse)
                    Log.d("TAG", "Response = $_data");
                }

                override fun onFailure(call: Call<MutableList<ProductModel>>, t: Throwable) {
                    Log.d("TAG", "Response = $t");
                }

            }
            )

    }
}
