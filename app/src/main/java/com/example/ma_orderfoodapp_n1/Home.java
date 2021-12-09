package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    private List<Foods> mListMovie = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;

    private List<FoodType> mListType = new ArrayList<>();
    private RecyclerView recyclerViewType;
    private FoodTypeAdapter mAdapterType;

    ImageButton imageButton;
    ImageButton imgMAp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getAllFoods().enqueue(new Callback<List<ResponseFoodClass>>() {
            @Override
            public void onResponse(Call<List<ResponseFoodClass>> call, Response<List<ResponseFoodClass>> response) {
                if (response.body() != null) {
                    Toast.makeText(Home.this, "List Foods", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Home.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
        apiService.getAllFoodType().enqueue(new Callback<List<ResFoodTypeClass>>() {
            @Override
            public void onResponse(Call<List<ResFoodTypeClass>> call, Response<List<ResFoodTypeClass>> response) {
                if (response.body() != null) {
                    Toast.makeText(Home.this, "List Food Type", Toast.LENGTH_SHORT).show();

                    for(int i = 0; i < response.body().size(); i++){
                        FoodType ft = new FoodType();
                        ft.setTypeId(response.body().get(i).getTypeId());
                        ft.setTypeName(response.body().get(i).getTypeName());
                        Log.e("llll", ft+"");
                        mListType.add(ft);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ResFoodTypeClass>> call, Throwable t) {
                Toast.makeText(Home.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });

//        prepareMovieData1();
        recyclerViewType = (RecyclerView) findViewById(R.id.recyclerAll);
        mAdapterType = new FoodTypeAdapter(this,mListType);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewType.setLayoutManager(mLayoutManager1);
        recyclerViewType.setItemAnimator(new DefaultItemAnimator());
        recyclerViewType.setAdapter(mAdapterType);

        //prepareMovieData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMost);
        mAdapter = new FoodAdapter(this,mListMovie);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnClickListener(new FoodAdapter.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("id +", String.valueOf(R.drawable.login));
                Intent intent = new Intent(Home.this,ProductDetails.class);
//                intent.putExtra("emp",list.get(position));
                startActivity(intent);
            }
        });

        imageButton = findViewById(R.id.omgButAll);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MenuItem.class);
                startActivity(intent);
            }
        });
        imgMAp = findViewById(R.id.omgButOrder);
        imgMAp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MapsActivity.class);
                startActivity(intent);
            }
        });

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
    }

//    private void prepareMovieData1() {
//        FoodType foodType = new FoodType(R.drawable.login, "Cơm");
//        mListType.add(foodType);
//        foodType = new FoodType(R.drawable.login, "Cơm");
//        mListType.add(foodType);
//        foodType = new FoodType(R.drawable.login, "Bún");
//        mListType.add(foodType);
//        foodType = new FoodType(R.drawable.login, "Cháo");
//        mListType.add(foodType);
//        foodType = new FoodType(R.drawable.login, "Phở");
//        mListType.add(foodType);
//        foodType = new FoodType(R.drawable.login, "Mì");
//        mListType.add(foodType);
//
//
//    }
}