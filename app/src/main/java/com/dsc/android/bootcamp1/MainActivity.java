package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etMobileNumber;
    private tinyDB db;
    private Button btnRegister;
    private String name,email,password,confirmpassword,mobilenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new tinyDB(this);
        initView();
        btnRegister.setOnClickListener(this);

    }
    //we are initialising UI component here..
    private void initView() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        btnRegister = findViewById(R.id.btnRegister);
       
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegister:
                getInfo();
                register();
                break;
        }
    }
    private void getInfo(){
        name=etName.getText().toString().trim();
        email=etEmail.getText().toString().trim();
        password=etPassword.getText().toString();
        confirmpassword=etConfirmPassword.getText().toString();
        mobilenumber=etMobileNumber.getText().toString().trim();
    }
    private void register() {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty() || mobilenumber.isEmpty()) {
            Toast.makeText(this, "one or more field is missing!!", Toast.LENGTH_SHORT).show();
        } else{
            if (!password.equals(confirmpassword)) {
            Toast.makeText(this, "Password  does not match with confirm password", Toast.LENGTH_SHORT).show();
        }
        else{
           db.putString("name",name);
           db.putString("email",email);
           db.putString("password",password);
           db.putString("mobileNumber",mobilenumber);
                Toast.makeText(this, "successfully registered!!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
            }
    }
    }
}
