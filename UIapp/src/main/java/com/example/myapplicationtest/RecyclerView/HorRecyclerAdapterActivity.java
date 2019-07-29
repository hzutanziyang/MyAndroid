package com.example.myapplicationtest.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/19.
 */

public class HorRecyclerAdapterActivity extends RecyclerView.Adapter<HorRecyclerAdapterActivity.linerviewHolder> {
    private Context mcontext;
    private Mylistener mylistener;
    public HorRecyclerAdapterActivity(Context context, Mylistener listener){
        this.mcontext = context;
        this.mylistener = listener;
    }
    @NonNull
    @Override

    public HorRecyclerAdapterActivity.linerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new linerviewHolder(LayoutInflater.from(mcontext).inflate(R.layout.horrecycler_adapter_text,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorRecyclerAdapterActivity.linerviewHolder holder, final int position) {
            holder.mtv.setText("hello！");
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
        private TextView mtv;
        public linerviewHolder(View itemView) {
            super(itemView);
            mtv = itemView.findViewById(R.id.m_tv);
        }
    }
    public interface Mylistener {
        void onClick(int pos);
    }
}
