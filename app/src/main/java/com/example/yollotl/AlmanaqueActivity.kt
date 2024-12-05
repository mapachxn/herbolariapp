package com.example.yollotl

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlmanaqueActivity : AppCompatActivity() {

    private lateinit var plantaAdapter: PlantaAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almanaque)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        plantaAdapter = PlantaAdapter(emptyList())
        recyclerView.adapter = plantaAdapter

        // Debug log to check initialization
        Log.d("AlmanaqueActivity", "RecyclerView and Adapter initialized")

        fetchPlantas()
    }

    private fun fetchPlantas() {
        // Debug log to check fetching process
        Log.d("AlmanaqueActivity", "Fetching plantas")

        RetrofitClient.instance.getPlantas().enqueue(object : Callback<List<Planta>> {
            override fun onResponse(call: Call<List<Planta>>, response: Response<List<Planta>>) {
                if (response.isSuccessful) {
                    val plantas = response.body()
                    if (plantas != null && plantas.isNotEmpty()) {
                        plantaAdapter.updatePlantas(plantas)
                        // Debug log to check data
                        Log.d("AlmanaqueActivity", "Plantas fetched: ${plantas.size}")
                        plantas.forEach {
                            Log.d("AlmanaqueActivity", "Planta: ${it.nombre}, ${it.descripcion}")
                        }
                    } else {
                        Log.d("AlmanaqueActivity", "No plantas found")
                    }
                } else {
                    Log.e("AlmanaqueActivity", "Response not successful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Planta>>, t: Throwable) {
                Log.e("AlmanaqueActivity", "Error fetching plantas: ${t.message}")
            }
        })
    }
}
