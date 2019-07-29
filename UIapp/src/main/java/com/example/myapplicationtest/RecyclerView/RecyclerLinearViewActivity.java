package com.example.myapplicationtest.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/18.
 */

public class RecyclerLinearViewActivity extends AppCompatActivity {
    private RecyclerView mRev;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerlinearview_text);
        mRev = findViewById(R.id.rv_linear);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.divider_drawable));
        mRev.addItemDecoration(divider);
        //mRev.addItemDecoration(new Mydecoration());

        //mRev.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRev.setLayoutManager(new LinearLayoutManager(RecyclerLinearViewActivity.this));
        mRev.setAdapter(new RecyclerAdapterActivity(RecyclerLinearViewActivity.this, new RecyclerAdapterActivity.Mylistener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerLinearViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class Mydecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.divideheight));
        }
    }
}
