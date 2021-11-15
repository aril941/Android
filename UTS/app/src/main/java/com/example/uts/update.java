package com.example.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class update extends AppCompatActivity {
    EditText password, username;
    Button update, cancel;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        password = findViewById(R.id.inputPassword);
        username = findViewById(R.id.inputUser);
        update = findViewById(R.id.btnUpdate);
        cancel = findViewById(R.id.btnCancel);
        preferences = getSharedPreferences("UserInfo", 0);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                if ((usernameValue.length()>1)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.apply();
                    Toast.makeText(update.this, "User Updated!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(update.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(update.this, "Ada form yang kosong/belum di isi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener((view) -> {
            back();
        });
    }
    public void back(){
        Intent p=new Intent(update.this,MainActivity.class);
        startActivity(p);
    }

}
