package com.example.myapplicationtest2.Fruit;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationtest2.R;

import java.util.List;

/**
 * Created by 洋 on 2019/7/9.
 */

public class FruitAdapter extends RecyclerView.Adapter <FruitAdapter.ViewHolder>{

    List<Fruit> mFruitList;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitText;
        public ViewHolder(View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.iv_1);
            fruitText = itemView.findViewById(R.id.tv_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        this.mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Fruit fruit = mFruitList.get(position);
            holder.fruitText.setText(fruit.getFruitName());
            holder.fruitImage.setImageResource(fruit.getFruitImgID());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
