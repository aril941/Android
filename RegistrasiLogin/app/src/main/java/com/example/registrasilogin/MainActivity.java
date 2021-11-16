package com.example.registrasilogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login,register;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        preferences = getSharedPreferences("UserInfo",0);
    }
    public void login(View v){
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String registeredUsername = preferences.getString("username","");
        String registeredPassword = preferences.getString("password","");
        if(usernameValue.equals(registeredUsername) &&
                passwordValue.equals(registeredPassword)){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Gagal,Username atau Password salah",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void register(View v){
        Intent intent = new Intent(MainActivity.this,register.class);
        startActivity(intent);
    }
}
