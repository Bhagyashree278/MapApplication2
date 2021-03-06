package com.example.mapapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationListActivity extends AppCompatActivity {
DBHelper dbHelper;
ListView l_view;
ArrayList<String> alldata=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        l_view=(ListView)findViewById(R.id.list_view);
        dbHelper=new DBHelper(LocationListActivity.this);
        try{
            alldata=dbHelper.getAllCotacts();
            if (alldata==null){
                Toast.makeText(LocationListActivity.this, "No data To show", Toast.LENGTH_SHORT).show();
            }
            else{
                final ArrayAdapter adapter = new ArrayAdapter(LocationListActivity.this, R.layout.list_layout, R.id.product_name,alldata );
                l_view.setAdapter(adapter);
                l_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        l_view.getSelectedItem();

                        String BrandSelected = l_view.getItemAtPosition(position).toString().trim();
                        Toast.makeText(LocationListActivity.this, "value:  "+BrandSelected, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }catch (Exception e){
            Toast.makeText(LocationListActivity.this, "No data To show", Toast.LENGTH_SHORT).show();
        }





    }
}