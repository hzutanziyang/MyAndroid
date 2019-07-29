package com.example.myapplicationtest2.Fruit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplicationtest2.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Fruit> mfruitList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        recyclerView = findViewById(R.id.Rv_fruit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(mfruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    public void initData(){
        for (int i=0;i<2;i++){
            Fruit apple = new Fruit("apple",R.drawable.apple);
            mfruitList.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana);
            mfruitList.add(banana);
            Fruit orange = new Fruit("orange",R.drawable.orange);
            mfruitList.add(orange);
            Fruit grape = new Fruit("grape",R.drawable.grape);
            mfruitList.add(grape);
            Fruit peach = new Fruit("peach",R.drawable.peach);
            mfruitList.add(peach);
            Fruit pear = new Fruit("pear",R.drawable.pear);
            mfruitList.add(pear);
        }
    }
}
