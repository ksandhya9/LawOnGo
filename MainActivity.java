package com.example.myprojectui;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }
    public void onSignUp(View view){
        Intent intent = new Intent(getApplicationContext(),user_register_edit.class);
        intent.putExtra("fromedit",false);
        startActivity(intent);
    }
    public void onLogin(View view){
        EditText username,password;
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        String user = username.getText().toString().toLowerCase();
        String pwd = password.getText().toString();
        if(user.isEmpty()){
            Log.d("USER NAME","Please enter User Name");
            CommonUtility.showOKDialog(this,"Login","Please enter User Name");
        }
        else if(pwd.isEmpty()){
            CommonUtility.showOKDialog(this,"Login","Please enter Password");
        }
        else {
            Cursor resultData = myDb.authenticateUser(user,pwd);
            if(resultData!=null) {
                if(resultData.moveToFirst()) {
                    String firstname, lastname, loginName, passport, email, adrs, phone,dob;
                    int id;
                    firstname = resultData.getString(2);
                    lastname= resultData.getString(3);
                    loginName = resultData.getString(8);
                    passport = resultData.getString(1);
                    dob = resultData.getString(4);
                    phone = resultData.getString(5);
                    email = resultData.getString(6);
                    adrs = resultData.getString(7);
                    id = resultData.getInt(0);
                    CommonUtility utility = new CommonUtility(firstname,lastname,loginName,pwd,passport,phone,adrs,email,dob,id);
                    Intent intent = new Intent(getApplicationContext(), homepage.class);
                    intent.putExtra("ID",resultData.getInt(0));
                    startActivity(intent);
                }
                else{
                    Log.d("Authentication","Credentials are not valid");
                    CommonUtility.showOKDialog(this,"Login","Credentials are not valid");
                }
            }
            else{
                Log.d("Authentication","Credentials are not valid");
                CommonUtility.showOKDialog(this,"Login","Credentials are not valid");
            }
        }
    }
}
