package com.example.myprojectui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Log.d("Check",CommonUtility.firstName);
        ImageButton complaint = (ImageButton)findViewById(R.id.button6);
        complaint.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ComplaintForm.class);
                startActivity(intent);
            }
        });
        ImageButton complaintList = (ImageButton)findViewById(R.id.button7);
        complaintList.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(homepage.this,"jkj",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),ComplaintList.class);
                startActivity(intent);
            }
        });
        ImageButton typesOfCases = (ImageButton)findViewById(R.id.button8);
        typesOfCases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(homepage.this,"lkj",Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(this, TypesOfCases.class);
                Intent i = new Intent();
                i.setClass(homepage.this, TypesOfCases.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int curId= item.getItemId();
        switch(curId){
            case R.id.menu_home:

                //Intent intent = new Intent(getApplicationContext(),homepage.class);
                //startActivity(intent);

                break;
            case R.id.menu_editprofile:
                Intent intent1 = new Intent(getApplicationContext(),user_register_edit.class);
                intent1.putExtra("fromedit",true);
                startActivity(intent1);

                break;

            case R.id.menu_logout:
                Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent2);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
