package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends AppCompatActivity {

    private List<Foods> mListMovie = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        prepareMovieData();
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