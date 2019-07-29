package com.example.myapplicationtest.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.myapplicationtest.R;

public class PuRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler);
        mRv4 = findViewById(R.id.rv_pu);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRv4.setLayoutManager(staggeredGridLayoutManager);
        mRv4.setAdapter(new PuRecyclerAdapterActivity(PuRecyclerActivity.this, new PuRecyclerAdapterActivity.Mylistener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerActivity.this,"onClick"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
