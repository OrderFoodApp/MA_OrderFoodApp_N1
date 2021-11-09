package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private List<Foods> mListMovie = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;

    private List<FoodType> mListType = new ArrayList<>();
    private RecyclerView recyclerViewType;
    private FoodTypeAdapter mAdapterType;

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prepareMovieData1();
        recyclerViewType = (RecyclerView) findViewById(R.id.recyclerAll);
        mAdapterType = new FoodTypeAdapter(this,mListType);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewType.setLayoutManager(mLayoutManager1);
        recyclerViewType.setItemAnimator(new DefaultItemAnimator());
        recyclerViewType.setAdapter(mAdapterType);

        prepareMovieData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMost);
        mAdapter = new FoodAdapter(this,mListMovie);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnClickListener(new FoodAdapter.OnClickListener() {
            @Override
            public void onItemClick(int position) {
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

    private void prepareMovieData1() {
        FoodType foodType = new FoodType(R.drawable.login, "Cơm");
        mListType.add(foodType);
        foodType = new FoodType(R.drawable.login, "Cơm");
        mListType.add(foodType);
        foodType = new FoodType(R.drawable.login, "Bún");
        mListType.add(foodType);
        foodType = new FoodType(R.drawable.login, "Cháo");
        mListType.add(foodType);
        foodType = new FoodType(R.drawable.login, "Phở");
        mListType.add(foodType);
        foodType = new FoodType(R.drawable.login, "Mì");
        mListType.add(foodType);


    }
}