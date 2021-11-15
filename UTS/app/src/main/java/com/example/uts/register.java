package com.example.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    EditText username, password, nama;
    Button login, register;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        nama = findViewById(R.id.inputNama);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        preferences = getSharedPreferences("UserInfo", 0);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String namaValue = nama.getText().toString();
                if ((usernameValue.length()>1)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("nama", namaValue);
                    editor.apply();
                    Toast.makeText(register.this, "User registered!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(register.this, "Ada form yang kosong/belum di isi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener((view) -> {
            back();
        });
    }
    public void back(){
        Intent p=new Intent(register.this,login.class);
        startActivity(p);
    }
}
