package com.example.myprojectui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class user_register_edit extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText firstName,lastName,phoneNo,email,username,password,passportNo,dob,adrs;
    boolean fromEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_user_register_edit);
         firstName = (EditText)findViewById(R.id.firstName);
         lastName = (EditText)findViewById(R.id.editTextLastName);
         phoneNo = (EditText)findViewById(R.id.phone);
         email = (EditText)findViewById(R.id.email);
         username = (EditText)findViewById(R.id.username);
         password = (EditText)findViewById(R.id.password);
         passportNo = (EditText)findViewById(R.id.passPortNo);
         dob = (EditText)findViewById(R.id.dob);
         adrs = (EditText)findViewById(R.id.address);
         myDb = new DatabaseHelper(this);
         Intent intent = getIntent();
         fromEdit = intent.getExtras().getBoolean("fromedit");
         if(fromEdit){
            firstName.setText(CommonUtility.firstName);
            lastName.setText(CommonUtility.lastName);
            phoneNo.setText(CommonUtility.phone);
            email.setText(CommonUtility.email);
            username.setText(CommonUtility.loginName);
            dob.setText(CommonUtility.dob);
            passportNo.setText(CommonUtility.passPort);
            adrs.setText(CommonUtility.adrs);
            password.setText(CommonUtility.password);
         }
         Button submitButton = (Button)findViewById(R.id.submitButton);
         submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues userInfo = new ContentValues();
                userInfo.put("PASSPORT_NO",passportNo.getText().toString());
                userInfo.put("FIRSTNAME",firstName.getText().toString());
                userInfo.put("LASTNAME",lastName.getText().toString());
                userInfo.put("MOBILE_NO",phoneNo.getText().toString());
                userInfo.put("EMAIL",email.getText().toString());
                userInfo.put("LOGIN_NAME",username.getText().toString().toLowerCase());
                userInfo.put("DOB",dob.getText().toString());
                userInfo.put("PASSWORD",password.getText().toString());
                userInfo.put("ADRS",adrs.getText().toString());

                if(fromEdit){
                    myDb.updateUserInfo(userInfo);
                    updateCommonUtils(userInfo);
                    CommonUtility.showOKDialog(user_register_edit.this,"User Details","Your Details Are Updated Successfully");
                }
                else {
                    myDb.insertIntoUserInfo(userInfo);
                    Log.d("Sign Up","user signed up successfully ");
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                Log.d("Sign Up","user signed up successfully ");
            }
         });
    }

    private void updateCommonUtils(ContentValues userInfo) {
        CommonUtility.lastName = userInfo.getAsString("LASTNAME");
        CommonUtility.firstName = userInfo.getAsString("FIRSTNAME");
        CommonUtility.loginName =userInfo.getAsString("LOGIN_NAME");
        CommonUtility.dob = userInfo.getAsString("DOB");
        CommonUtility.passPort= userInfo.getAsString("PASSPORT_NO");
        CommonUtility.phone= userInfo.getAsString("MOBILE_NO");
        CommonUtility.email= userInfo.getAsString("EMAIL");
        CommonUtility.password= userInfo.getAsString("PASSWORD");
        CommonUtility.adrs= userInfo.getAsString("ADRS");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(fromEdit) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
            return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curId= item.getItemId();
        switch(curId){
            case R.id.menu_home:
                Intent intent = new Intent(getApplicationContext(),homepage.class);
                startActivity(intent);
                // Toast.makeText(this , "Home Icon", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_editprofile:
                Intent intent1 = new Intent(getApplicationContext(),user_register_edit.class);
                intent1.putExtra("fromedit",true);
                startActivity(intent1);
                //Toast.makeText(this , "Edit user", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_logout:
                Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent2);
                //Toast.makeText(this , "Logout", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
