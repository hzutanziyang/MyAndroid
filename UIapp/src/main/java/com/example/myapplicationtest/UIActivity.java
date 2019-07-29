package com.example.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest.Fragment.ConstainerActivity;
import com.example.myapplicationtest.Jump.JumpActivity;
import com.example.myapplicationtest.ListView.ListViewActivity;
import com.example.myapplicationtest.RecyclerView.RecyclerviewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mbt_imageView;
    private Button mbt_editText;
    private Button mbt_listView;
    private Button mbt_recyclerView;
    private Button mbt_webView;
    private Button mbt_toast;
    private Button mbt_alertDialog;
    private Button mbt_progress;
    private Button mbt_customdialog;
    private Button mbt_jump;
    private Button mbt_fragment;
    private Button mbt_popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mbt_imageView = findViewById(R.id.bt_imageView);
        mbt_editText = findViewById(R.id.bt_editText);
        mbt_listView = findViewById(R.id.bt_listView);
        mbt_recyclerView = findViewById(R.id.bt_recyclerview);
        mbt_webView = findViewById(R.id.bt_webview);
        mbt_toast =findViewById(R.id.bt_Toast);
        mbt_alertDialog = findViewById(R.id.bt_Alertdialog);
        mbt_progress = findViewById(R.id.bt_Progress);
        mbt_customdialog = findViewById(R.id.bt_Custom_Dialog);
        mbt_jump = findViewById(R.id.bt_jump);
        mbt_fragment = findViewById(R.id.bt_Fragment);
        mbt_popup = findViewById(R.id.bt_popup);
        setOnClick();
    }

    private void setOnClick(){
        OnClick onClick = new OnClick();
        mbt_imageView.setOnClickListener(onClick);
        mbt_editText.setOnClickListener(onClick);
        mbt_listView.setOnClickListener(onClick);
        mbt_recyclerView.setOnClickListener(onClick);
        mbt_webView.setOnClickListener(onClick);
        mbt_toast.setOnClickListener(onClick);
        mbt_alertDialog.setOnClickListener(onClick);
        mbt_progress.setOnClickListener(onClick);
        mbt_customdialog.setOnClickListener(onClick);
        mbt_jump.setOnClickListener(onClick);
        mbt_fragment.setOnClickListener(onClick);
        mbt_popup.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        Intent intent = null;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_imageView:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.bt_editText:
                    intent = new Intent(UIActivity.this,EditTextActivity.class);
                    break;
                case R.id.bt_listView:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.bt_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerviewActivity.class);
                    break;
                case R.id.bt_webview:
                    intent = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.bt_Toast:
                    intent = new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.bt_Alertdialog:
                   intent = new Intent(UIActivity.this,AlertDialogActivity.class);
                    break;
                case R.id.bt_Progress:
                    intent = new Intent(UIActivity.this,ProgressActivity.class);
                    break;
                case R.id.bt_Custom_Dialog:
                    intent = new Intent(UIActivity.this,CustomDialogActivity.class);
                    break;
                case R.id.bt_jump:
                    intent = new Intent(UIActivity.this, JumpActivity.class);
                    break;
                case R.id.bt_Fragment:
                    intent = new Intent(UIActivity.this, ConstainerActivity.class);
                    break;
                case R.id.bt_popup:
                    intent = new Intent(UIActivity.this,PopupActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
