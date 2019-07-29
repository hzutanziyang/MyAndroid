package com.example.myapplicationtest.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/19.
 */

public class RecyclerAdapterActivity extends RecyclerView.Adapter {
    private Context mcontext;
    private Mylistener mylistener;
    public RecyclerAdapterActivity(Context context,Mylistener listener){
        this.mcontext = context;
        this.mylistener = listener;
    }
    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new linerviewHolder(LayoutInflater.from(mcontext).inflate(R.layout.recycler_adapter_text,parent,false));
        }else{
            return new linerviewHolder2(LayoutInflater.from(mcontext).inflate(R.layout.recycler_adapter_text2,parent,false));
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            if (getItemViewType(position) == 0){
                ((RecyclerAdapterActivity.linerviewHolder)holder).mtv.setText("你好！");
            }
            else{
                ((RecyclerAdapterActivity.linerviewHolder2)holder).mtv1.setText("你好！");
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylistener.onClick(position);
                }
            });
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 ==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class linerviewHolder extends RecyclerView.ViewHolder{
        private TextView mtv;
        public linerviewHolder(View itemView) {
            super(itemView);
            mtv = itemView.findViewById(R.id.m_tv);
        }
    }

    class linerviewHolder2 extends RecyclerView.ViewHolder{
        private TextView mtv1;
        private ImageView imv;
        public linerviewHolder2(View itemView) {
            super(itemView);
            mtv1 = itemView.findViewById(R.id.m_tv1);
            imv = itemView.findViewById(R.id.rv_img);
        }
    }
    public interface Mylistener {
        void onClick(int pos);
    }
}
