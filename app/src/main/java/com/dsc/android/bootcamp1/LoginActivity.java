package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
        btnLogin.setOnClickListener(this);
    }
    public void initview(){
        etEmail=findViewById(R.id.etEmail);
        etPassword =findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View v) {

    }
}
