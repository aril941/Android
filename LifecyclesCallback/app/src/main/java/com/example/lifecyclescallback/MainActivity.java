package com.example.lifecyclescallback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTodo;
    Button finish;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTodo=(TextView) findViewById(R.id.txtTodo);
        finish=(Button) findViewById(R.id.finish);
        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate");

        String info="Lifecycle Guide \n"
                +"1.New App (onCreate,onResume)\n"
                +"2.Back (onPause,onDestroy)\n"
                +"3.Finish(onStop,onDestroy)\n"
                +"4.Reopen(onResume,onStart,onRestart)\n"
        ;

        txtTodo.setText(info);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Toast.makeText(getBaseContext(),"onCreate",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
        Toast.makeText(getBaseContext(),"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
        Toast.makeText(getBaseContext(),"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
        Toast.makeText(getBaseContext(),"onDestroy ",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
        Toast.makeText(getBaseContext(),"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
        Toast.makeText(getBaseContext(),"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
        Toast.makeText(getBaseContext(),"onRestart",Toast.LENGTH_LONG).show();
    }
}