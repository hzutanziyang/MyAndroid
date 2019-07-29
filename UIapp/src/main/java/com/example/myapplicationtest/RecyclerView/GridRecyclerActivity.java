package com.example.myapplicationtest.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplicationtest.R;

public class GridRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRv_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler);
        mRv_grid = findViewById(R.id.rv_grid);
        mRv_grid.setLayoutManager(new GridLayoutManager(GridRecyclerActivity.this,3));
        mRv_grid.setAdapter(new GridRecyclerAdapterActivity(GridRecyclerActivity.this, new GridRecyclerAdapterActivity.Mylistener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerActivity.this,"onClick"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
