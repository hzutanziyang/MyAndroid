package com.youlan.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author : Hashub小晖
 * email  : hashubng@163.com
 * date   : 2019/9/3 14:34
 * desc   :
 */
public class FruitAdapter_toolbar extends RecyclerView.Adapter<FruitAdapter_toolbar.ViewHolder>
{
    private Context mContext;

    private List<Fruit> mFruitList;

    //private Fruit checkFruit;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        LinearLayout mlinearLayout;
        //View mView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            //mView = itemView;
            cardView = (CardView) itemView;
            mlinearLayout = itemView.findViewById(R.id.cardview_lt);
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter_toolbar(List<Fruit> fruitList){
        this.mFruitList = fruitList;
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i)
    {
        if(mContext == null) {
            mContext = viewGroup.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent intent = new Intent(mContext,FruitActivity.class);
                intent.putExtra(FruitToolbar.FRUIT_NAME,fruit.getName());
                intent.putExtra(FruitToolbar.FRUIT_IMAGE_ID,fruit.getImageid());
                mContext.startActivity(intent);
            }
        });

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


//        holder.mlinearLayout.setOnClickListener(new View.OnClickListener()
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
