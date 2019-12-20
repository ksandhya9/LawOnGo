package com.example.myprojectui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TypesOfCases extends AppCompatActivity {

    CasesListFragment fragment1;
    AboutCaseViewerFragment fragment2;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_cases);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment2 = new AboutCaseViewerFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.container,fragment2).commit();
        final TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Criminal")); // adding Tabs to TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Domestic"));
        tabLayout.addTab(tabLayout.newTab().setText("Consumer"));
        tabLayout.addTab(tabLayout.newTab().setText("Traffic"));

        tabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                int position = tabLayout.getSelectedTabPosition();
                onImageClick(position);
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    public void onImageClick(int i) {
       // Toast.makeText(this,"image button pressed"+i,Toast.LENGTH_LONG).show();
        fragment2.setTextInFragment(i);
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
