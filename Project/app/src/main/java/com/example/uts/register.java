package com.example.uts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

public class register extends AppCompatActivity {
    EditText username, password, nama;
    Button login, register;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        nama = findViewById(R.id.inputNama);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(register.this);

        AndroidNetworking.initialize(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fusername = username.getText().toString();
                String fpassword = password.getText().toString();
                if(fusername.equals("") || fpassword.equals("")){
                    Toast.makeText(getApplicationContext(), "Data harus diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    User data = new User();
                    data.setUsername(fusername);
                    data.setPassword(fpassword);
                    registerNow(data);
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

    private void registerNow(User data) {
        AndroidNetworking.post("http://10.0.2.2/android/uasppb/api/api_add_user_data.php")
                .addBodyParameter("username", data.getUsername())
                .addBodyParameter("password", data.getPassword())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(register.this, "Berhasil register! ", Toast.LENGTH_SHORT).show();
                        Intent r = new Intent(register.this,MainActivity.class);
                        startActivity(r);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(register.this, "Gagal Register: "+anError , Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
