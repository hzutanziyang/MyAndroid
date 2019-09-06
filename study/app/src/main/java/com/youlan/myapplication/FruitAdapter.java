package com.youlan.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author : Hashub小晖
 * email  : hashubng@163.com
 * date   : 2019/9/3 14:34
 * desc   :
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>
{
    private Context mContext;

    private List<Fruit> mFruitList;

    //private Fruit checkFruit;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        //View mView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            //mView = itemView;
            cardView = (CardView) itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        this.mFruitList = fruitList;
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        if(mContext == null) {
            mContext = viewGroup.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
//        holder.cardView.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent)
//            {
//                int position = holder.getAdapterPosition();
//                Log.d("------ Position ------", String.valueOf(position));
//                Fruit fruit = mFruitList.get(position);
//                Toast.makeText(view.getContext(),"你点击了: " + fruit.getName(),Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int position = holder.getAdapterPosition();
                Log.d("------ Position ------", String.valueOf(position));
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"你点击了: " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                int position = holder.getAdapterPosition();
//                Log.d("------ Position ------", String.valueOf(position));
//                Fruit fruit = mFruitList.get(position);
//                Toast.makeText(view.getContext(),"你点击了: " + fruit.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }

    @Override
   public  void  onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        Fruit fruit = mFruitList.get(i);
        //checkFruit = fruit;
        viewHolder.fruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageid()).into(viewHolder.fruitImage);

    }


    @Override
    public int getItemCount()
    {
        return mFruitList.size();
    }
}
