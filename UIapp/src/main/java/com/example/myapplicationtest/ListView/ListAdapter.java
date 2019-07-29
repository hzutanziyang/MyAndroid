package com.example.myapplicationtest.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/6.
 */

public class ListAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutInflater;

    public ListAdapter(Context context){
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class MyHolder{
        public ImageView mimageView;
        public TextView mtitle,mtime,mtext;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder = null;
        if (view == null){
            view = mlayoutInflater.inflate(R.layout.layout_list,null);
            holder = new MyHolder();
            holder.mtitle = view.findViewById(R.id.tv_title);
            holder.mtime = view.findViewById(R.id.tv_time);
            holder.mtext = view.findViewById(R.id.tv_context);
            holder.mimageView = view.findViewById(R.id.im_list);
            view.setTag(holder);
        }else{
            holder = (MyHolder) view.getTag();
        }
        holder.mtext.setText("这是内容");
        holder.mtime.setText("10:46");
        holder.mtitle.setText("这是标题");
        Glide.with(mcontext).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(holder.mimageView);
        return view;
    }
}
