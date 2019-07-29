package com.example.myapplicationtest.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/19.
 */

public class PuRecyclerAdapterActivity extends RecyclerView.Adapter<PuRecyclerAdapterActivity.linerviewHolder> {
    private Context mcontext;
    private Mylistener mylistener;
    public PuRecyclerAdapterActivity(Context context, Mylistener listener){
        this.mcontext = context;
        this.mylistener = listener;
    }
    @NonNull
    @Override

    public PuRecyclerAdapterActivity.linerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new linerviewHolder(LayoutInflater.from(mcontext).inflate(R.layout.purecycler_adapter_text,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuRecyclerAdapterActivity.linerviewHolder holder, final int position) {

            if(position % 2 == 0)
            {
                holder.img.setImageResource(R.drawable.leimu);
            }
            else
            {
                holder.img.setImageResource(R.drawable.yangtuo);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylistener.onClick(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class linerviewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public linerviewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
    public interface Mylistener {
        void onClick(int pos);
    }
}
