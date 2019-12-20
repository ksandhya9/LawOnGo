package com.example.myprojectui;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ComplaintForm extends AppCompatActivity {

    TextView username, passport, phone, email, address, dob;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_form);
        populateUserDetails();
        myDb = new DatabaseHelper(this);
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

    public void populateUserDetails() {
        username = (TextView)findViewById(R.id.userFullName);
        passport = (TextView)findViewById(R.id.passPortNo);
        phone = (TextView)findViewById(R.id.phone);
        email = (TextView)findViewById(R.id.email);
        dob = (TextView)findViewById(R.id.dob);
        address = (TextView)findViewById(R.id.adrs);

        username.setText(CommonUtility.firstName+" "+CommonUtility.lastName);
        passport.setText(CommonUtility.passPort);
        phone.setText(CommonUtility.phone);
        email.setText(CommonUtility.email);
        dob.setText(CommonUtility.dob);
        address.setText(CommonUtility.adrs);

    }

    public void cancelComplaint(View v){
        Intent intent = new Intent(getApplicationContext(),homepage.class);
        startActivity(intent);
    }

    public void submitComplaint(View view){

        showokDialog();


    }

    private void showokDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                dialog.dismiss();
                submitForm();

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
    private void submitForm(){
        EditText respondent = (EditText) findViewById(R.id.editTextofRespondent);
        EditText complaint_date = (EditText) findViewById(R.id.complaint_date);
        EditText typeOfComplaint = (EditText) findViewById(R.id.typeOfComplaint);
        EditText briefLine = (EditText) findViewById(R.id.brief_line);
        EditText incident_summary = (EditText) findViewById(R.id.incident_summary);
        EditText dateOfIncident = (EditText) findViewById(R.id.dateOfIncident);
        EditText location = (EditText) findViewById(R.id.locationOfIncident);

        ContentValues complaintDetails = new ContentValues();
        complaintDetails.put("RESPONDENT_NAME", respondent.getText().toString());
        complaintDetails.put("FILED_DATE", complaint_date.getText().toString());
        complaintDetails.put("TYPE_OF_CMPLNT", typeOfComplaint.getText().toString());
        complaintDetails.put("BRIEF_LINE", briefLine.getText().toString());
        complaintDetails.put("INCIDENT_SUM", incident_summary.getText().toString());
        complaintDetails.put("DofIncident", dateOfIncident.getText().toString());
        complaintDetails.put("LocationOfIncident", location.getText().toString());
        complaintDetails.put("USER_ID", CommonUtility.id);
        myDb.insertComplaint(complaintDetails);
        Intent intent = new Intent(getApplicationContext(), homepage.class);
        startActivity(intent);
    }
}
