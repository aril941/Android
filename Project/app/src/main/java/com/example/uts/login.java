package com.example.uts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class login extends AppCompatActivity {
    EditText username,password;
    Button login;
    TextView register;
    ProgressDialog progressDialog;

    List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        register = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(login.this);

        AndroidNetworking.initialize(this);
        getVerif();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.equals("") && !password.equals("")){
                    for (int i = 0;i<userList.size();i++){
                        if(username.getText().toString().equals(userList.get(i).getUsername()) && password.getText().toString().equals(userList.get(i).getPassword()) ){
                            Intent intent = new Intent(login.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                } else {
                    Toast.makeText(login.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void register(View v) {
        Intent intent = new Intent(login.this, register.class);
        startActivity(intent);
    }

    public void login(View v){
        String Username = username.getText().toString();
        String Password = password.getText().toString();

    }

    private void getVerif() {
        AndroidNetworking.get("http://10.0.2.2/android/uasppb/api/api_all_user_data.php")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            for(int i = 0 ;i<response.length();i++){
                                JSONObject jsonObject = response.getJSONObject(i);
                                User data = new User();
                                data.setUsername(jsonObject.getString("username"));
                                data.setPassword(jsonObject.getString("password"));
                                userList.add(data);
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(login.this, "Gagal Verif : "+e , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(login.this, "An Error : " +anError, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
