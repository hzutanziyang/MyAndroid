package com.example.myapplicationtest.RecyclerView;

import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplicationtest.R;

public class HorRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler);
        mRv2 = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRv2.setLayoutManager(linearLayoutManager);
        mRv2.setAdapter(new HorRecyclerAdapterActivity(HorRecyclerActivity.this, new HorRecyclerAdapterActivity.Mylistener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorRecyclerActivity.this,"onClick"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
        mRv2.addItemDecoration(new  MyhorDecoration());
    }
    class MyhorDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.divideheight),0);
        }
    }
}
