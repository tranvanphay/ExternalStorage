package com.example.hades.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
Button bt,bt1,bt2;
TextView tv;
EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.button);
        bt1=findViewById(R.id.button2);
        bt2=findViewById(R.id.button3);
        tv=findViewById(R.id.textView);
        et=findViewById(R.id.editText);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ghine();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
                tv.setText("");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docne();
            }
        });

    }
    public void ghine(){
        String chuoi=et.getText().toString();
        try {
            File duongdan= Environment.getExternalStorageDirectory();
            File taptin=new File(duongdan,"xyz.txt");
            FileOutputStream out=new FileOutputStream(taptin);
            out.write(chuoi.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void docne(){
        try {
            File duongdan= Environment.getExternalStorageDirectory();
            File taptin=new File(duongdan,"xyz.txt");
            FileInputStream in=new FileInputStream(taptin);
            byte[] buffer=new byte[in.available()];
            in.read(buffer);
            String chuoi=new String(buffer);
            tv.setText(chuoi);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
