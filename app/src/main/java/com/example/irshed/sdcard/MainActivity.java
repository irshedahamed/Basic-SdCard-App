package com.example.irshed.sdcard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import android.view.*;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    Button save,read;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        save=(Button)findViewById(R.id.button);
        read=(Button)findViewById(R.id.button3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=t1.getText().toString();
                String data=t2.getText().toString();
                FileOutputStream fos;
                try {
                    FileOutputStream fOut = openFileOutput(fname,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = t1.getText().toString();
                try {
                    FileInputStream fin = openFileInput(filename);
                    int c;
                    String temp="";
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }

                    Toast.makeText(getBaseContext(),temp,Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }
        });
    }
}