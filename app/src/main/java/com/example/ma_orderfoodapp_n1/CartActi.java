package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActi extends AppCompatActivity {

    ArrayList<Foods> arrayList;
    private ListAdapter listAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        arrayList = new ArrayList<>();

        Foods foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        arrayList.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        arrayList.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        arrayList.add(foods);
        foods = new Foods(R.drawable.login, "Cơm trưa", "Tươi ngon", 120, 40);
        arrayList.add(foods);

        listAdapter = new ListAdapter(CartActi.this,R.layout.list_cart,arrayList);
        listView = findViewById(R.id.lvCart);
        listView.setAdapter(listAdapter);
    }
}