package com.ydh.androiddesignstyle

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getAllProduct(): Call<MutableList<ProductModel>>

}