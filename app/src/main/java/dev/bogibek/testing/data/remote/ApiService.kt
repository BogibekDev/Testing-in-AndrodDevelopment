package dev.bogibek.testing.data.remote

import dev.bogibek.testing.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProducts():Call<ProductResponse>
}