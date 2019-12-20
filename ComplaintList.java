package com.example.myprojectui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ComplaintList extends AppCompatActivity {
    ListView complaint_List;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        complaint_List = (ListView)findViewById(R.id.listview);
        myDB = new DatabaseHelper(this);

        final ComplaintAdapter adapter = new ComplaintAdapter(ComplaintList.this);
        Cursor complaints = myDB.getComplaintsByUser(CommonUtility.id);
        while(complaints.moveToNext()) {
            int index;

            index = complaints.getColumnIndexOrThrow("Complaint_ID");
            int complaintId = complaints.getInt(index);

            index = complaints.getColumnIndexOrThrow("BRIEF_LINE");
            String BRIEF_LINE = complaints.getString(index);

            index = complaints.getColumnIndexOrThrow("TYPE_OF_CMPLNT");
            String TYPE_OF_CMPLNT = complaints.getString(index);
            adapter.addItem(new ComplaintItem(BRIEF_LINE,TYPE_OF_CMPLNT, complaintId+" "));
        }

        complaint_List.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public void openDialog(String complaint_status, String s) {
        CommonUtility.showOKDialog(this,complaint_status,s);
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
    class ComplaintAdapter extends BaseAdapter {
        ArrayList<ComplaintItem> items = new ArrayList<ComplaintItem>();
        Context check;
       public ComplaintAdapter(Context c){
          check = c;
        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ComplaintItemView itemView = new ComplaintItemView(getApplicationContext(), check);
            ComplaintItem item = items.get(position);
            itemView.setComplaint_id(item.getComplaint_Id());
            itemView.setSubject(item.getSubject());
            itemView.setType(item.getType());

            return itemView;
        }

        public void addItem(ComplaintItem item){
            items.add(item);
        }
    }
}
