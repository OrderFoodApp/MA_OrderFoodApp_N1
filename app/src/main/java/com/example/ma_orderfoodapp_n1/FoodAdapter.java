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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private List<Foods> foodList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private OnClickListener mListener;

    public interface OnClickListener {
        void onItemClick(int position);
    }

    public void setOnClickListener(OnClickListener mListener) {
        this.mListener = mListener;
    }

    public FoodAdapter(Context context, List<Foods> foodList) {
        this.foodList = foodList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView name, description, price, promo;

        public MyViewHolder(View itemView, OnClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgFood);
            name = (TextView) itemView.findViewById(R.id.tvFoodName);
            description = (TextView) itemView.findViewById(R.id.tvFoodDes);
            price = (TextView) itemView.findViewById(R.id.tvFoodPrice);
            promo = (TextView) itemView.findViewById(R.id.tvFoodPromo);

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.food_list, parent, false);
        return new MyViewHolder(item, mListener);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.MyViewHolder holder, int position) {
        Foods foods = foodList.get(position);
        holder.imageView.setBackgroundResource(foods.getImageId());
        holder.name.setText(foods.getFoodName());
        holder.description.setText(foods.getDescription());
        holder.price.setText("$ " +String.valueOf(foods.getFoodPrice()) );
        holder.promo.setText(foods.getFoodSale() +"%" +" off");
    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
