package com.youlan.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton floatingActionButton;

    private Fruit[] fruits = {
            new Fruit("Apple",R.drawable.pingguo),
            new Fruit("Banana",R.drawable.xiangjiao),
            new Fruit("peach",R.drawable.taozi),
            new Fruit("Grape",R.drawable.putao),
            new Fruit("Watermelon",R.drawable.xigua),
            new Fruit("Pear",R.drawable.li),
            new Fruit("Pineapple",R.drawable.boluo),
            new Fruit("Pitaya",R.drawable.huolongguo),
            new Fruit("Orange",R.drawable.chengzi)};

    private List<Fruit> fruitList = new ArrayList<>();

    private  FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        floatingActionButton = findViewById(R.id.fab);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.navigation);
        }
        navigationView.setCheckedItem(R.id.me);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId()){
                    case R.id.me:
                        mDrawerLayout.closeDrawers();
                        break;
                     case R.id.friend:
                         mDrawerLayout.closeDrawers();
                         break;

                }
                return true;
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               /*
                Snackbar.make(view,"Data delete",Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Toast.makeText(MainActivity.this,"Data restored",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                */
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示").setMessage("确定删除？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

        initFruit();
        RecyclerView recyclerView = findViewById(R.id.recycleer_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruit(){
        fruitList.clear();
        for (int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.delete:
                Toast.makeText(this,"You clicked delete ",Toast.LENGTH_SHORT).show();
//                View popupView = getLayoutInflater().inflate(R.layout.popupwindow,null);
//                PopupWindow popupWindow = new PopupWindow(popupView,300,220);
                break;
            case R.id.add:
                //Toast.makeText(this,"You clicked add ",Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
