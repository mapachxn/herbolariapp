/* package com.example.yollotl;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlmanaqueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almanaque);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_plantas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PlantaApi plantaApi = RetrofitClient.getInstance().create(PlantaApi.class);
        plantaApi.getPlantas().enqueue(new Callback<List<Planta>>() {
            @Override
            public void onResponse(Call<List<Planta>> call, Response<List<Planta>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PlantaAdapter adapter = new PlantaAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Planta>> call, Throwable t) {
                Toast.makeText(AlmanaqueActivity.this, "Error al cargar datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
*/