package com.example.ma_orderfoodapp_n1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context context;
    private int layout;
    private ArrayList<Foods> listFood;

    public ListAdapter(Context context, int layout, ArrayList<Foods> listFood) {
        this.context = context;
        this.layout = layout;
        this.listFood = listFood;
    }

    @Override
    public int getCount() {
        return listFood.size();
    }

    @Override
    public Object getItem(int position) {
        return listFood.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);

        ImageView imagesFood = convertView.findViewById(R.id.imgHinh);
        TextView foodName = convertView.findViewById(R.id.tvNameFC);
        TextView foodDes = convertView.findViewById(R.id.tvDesFC);
        TextView foodPrice = convertView.findViewById(R.id.tvPriceFC);
        TextView foodPromo = convertView.findViewById(R.id.tvPromoFC);

        Foods foods = listFood.get(position);
        imagesFood.setImageResource(foods.getImageId());
        foodName.setText(foods.getFoodName());
        foodDes.setText(foods.getDescription());
        foodPrice.setText("$ " +foods.getFoodPrice());
        foodPromo.setText(foods.getFoodSale() + "%"+" off");

        return convertView;
    }
}
