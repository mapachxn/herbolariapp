package com.example.yollotl

import retrofit2.Call
import retrofit2.http.*

interface PlantaApi {
    @GET("api/v1/planta/")
    fun getPlantas(): Call<List<Planta>>

    @GET("api/v1/planta/{id}/")
    fun getPlanta(@Path("id") id: Int): Call<Planta>

    @POST("api/v1/planta/")
    fun createPlanta(@Body planta: Planta): Call<Planta>

    @PUT("api/v1/planta/{id}/")
    fun updatePlanta(@Path("id") id: Int, @Body planta: Planta): Call<Planta>

    @DELETE("api/v1/planta/{id}/")
    fun deletePlanta(@Path("id") id: Int): Call<Void>
}
