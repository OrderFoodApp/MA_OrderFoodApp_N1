package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuItem extends AppCompatActivity {

    private List<Foods> mListMovie = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getAllFoods().enqueue(new Callback<List<ResponseFoodClass>>() {
            @Override
            public void onResponse(Call<List<ResponseFoodClass>> call, Response<List<ResponseFoodClass>> response) {
                if (response.body() != null) {
                    Toast.makeText(MenuItem.this, "List Foods", Toast.LENGTH_SHORT).show();
                    Log.e("llll", response.body().toString());
                    for(int i = 0; i < response.body().size(); i++){
                        Foods f = new Foods();
                        f.setImageId(response.body().get(i).getImageId());
                        f.setFoodName(response.body().get(i).getFoodName());
                        f.setDescription(response.body().get(i).getDescription());
                        f.setFoodPrice(response.body().get(i).getFoodPrice());
                        f.setFoodSale(response.body().get(i).getFoodSale());
                        mListMovie.add(f);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ResponseFoodClass>> call, Throwable t) {
                Toast.makeText(MenuItem.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });

//        prepareMovieData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerProduct);
        mAdapter = new FoodAdapter(this,mListMovie);

       // RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
    private void prepareMovieData() {
        Foods foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        mListMovie.add(foods);
    }
}