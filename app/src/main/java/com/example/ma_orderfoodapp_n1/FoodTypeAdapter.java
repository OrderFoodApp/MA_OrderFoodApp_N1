package com.example.ma_orderfoodapp_n1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodTypeAdapter extends RecyclerView.Adapter<FoodTypeAdapter.MyViewHolder> {
    private List<FoodType> foodList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FoodTypeAdapter(Context context, List<FoodType> foodList) {
        this.foodList = foodList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgFoodType);
            name = (TextView) itemView.findViewById(R.id.tvFoodTypeName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, name.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(mContext, "Long item clicked " + name.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }


    @Override
    public FoodTypeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.type_list, parent, false);
        return new FoodTypeAdapter.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(FoodTypeAdapter.MyViewHolder holder, int position) {
        FoodType foodType = foodList.get(position);
        holder.imageView.setBackgroundResource(foodType.getTypeId());
        holder.name.setText(foodType.getTypeName());
    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
