package com.example.noteinternalstorageschedular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String STORETEXT="notesku";
    EditText txtEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEditor=findViewById(R.id.text);
    }

    public void save (View view){
        try{
            OutputStreamWriter out=new OutputStreamWriter(openFileOutput(STORETEXT,0));
            out.write(txtEditor.getText().toString());
            out.close();
            Toast.makeText(this,"Notes Successfully Saved",Toast.LENGTH_LONG).show();
        }catch (Throwable e){
            Toast.makeText(this,"Exception : "+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void read(View view){
        try {
            InputStream in = openFileInput(STORETEXT);
            if (in != null) {
                InputStreamReader a = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(a);
                String str;
                StringBuilder buf = new StringBuilder();

                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                }
                in.close();
                txtEditor.setText(buf.toString());
            }
        }catch(java.io.FileNotFoundException q) {
            Toast.makeText(this,"Exception : "+q.toString(),Toast.LENGTH_LONG).show();
        }catch (Throwable e){
            Toast.makeText(this,"Exception : "+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void saveSDC(View view){
        try{
            File myfile=new File("/sdcard/note.txt");
            myfile.createNewFile();
            FileOutputStream fileOut=new FileOutputStream(myfile);
            OutputStreamWriter myOutWriter= new OutputStreamWriter(fileOut);
            myOutWriter.append(txtEditor.getText());
            myOutWriter.close();
            fileOut.close();
            Toast.makeText(this,"Saved tp SD Card/note.txt".toString(),Toast.LENGTH_LONG).show();
        }catch (Exception a){
            Toast.makeText(this,"Exception : "+a.toString(),Toast.LENGTH_LONG).show();
        }
    }
}