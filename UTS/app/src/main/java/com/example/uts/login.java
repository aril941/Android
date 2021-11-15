package com.example.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;
    TextView register;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        preferences = getSharedPreferences("UserInfo",0);
    }
    public void login(View v){
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String registeredUsername = preferences.getString("username","");
        String registeredPassword = preferences.getString("password","");
        if(usernameValue.equals(registeredUsername) &&
                passwordValue.equals(registeredPassword)){
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(login.this, "Gagal,Username atau Password salah",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void register(View v) {
        Intent intent = new Intent(login.this, register.class);
        startActivity(intent);
    }

}
