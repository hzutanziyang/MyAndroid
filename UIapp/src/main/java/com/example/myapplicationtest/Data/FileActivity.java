package com.example.myapplicationtest.Data;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtest.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText editText;
    private Button mbtsave,mbtshow;
    private TextView mtv;
    private final String mFilename = "text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        editText = findViewById(R.id.m_et1);
        mbtsave = findViewById(R.id.bt_save1);
        mbtshow = findViewById(R.id.bt_show1);
        mtv = findViewById(R.id.m_tv3);
        mbtsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(editText.getText().toString());
            }
        });
        mbtshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtv.setText(read());
            }
        });

    }
    private void save(String string){
        FileOutputStream fileOutputStream = null;
        try {
//            内部存储
//            fileOutputStream = openFileOutput(mFilename,MODE_PRIVATE);

            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(),"skypan");
            if(!dir.exists()){
                dir.mkdirs();
            }
            //创建文件
            File file = new File(dir,mFilename);
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(string.getBytes());

        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream !=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    private String read(){
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = openFileInput(mFilename);

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan",mFilename);
            fileInputStream = new FileInputStream(file);
            byte []b = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len=fileInputStream.read(b))>0){
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream !=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
