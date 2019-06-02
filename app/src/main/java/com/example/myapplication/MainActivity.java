package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button loginbtn, registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the on screen variables
        getUserLoginDetails();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateParam()){
                    //verifying login details
                    if(validateUser()){
                        startActivity(new Intent(MainActivity.this ,HomeActivity.class));
                    }
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    private boolean validateUser() {
        boolean validateUser = false;
        if(username.getText().toString().equals("a") && password.getText().toString().equals("a")){
            validateUser = true;
        }
        return validateUser;
    }

    private boolean validateParam() {
        boolean validate = false;
        if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter the details",Toast.LENGTH_SHORT).show();
        }else{
            validate = true;
        }
        return validate;
    }

    private void getUserLoginDetails(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
    }
    }

