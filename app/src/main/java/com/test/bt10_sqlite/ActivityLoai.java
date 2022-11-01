package com.test.bt10_sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.test.bt10_sqlite.adapter.adapterLoai;
import com.test.bt10_sqlite.database.database;

import java.util.ArrayList;

public class ActivityLoai extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ArrayList<Loai> arrayList;
    database database;
    adapterLoai adapterLoai;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai);

        toolbar = findViewById(R.id.toolbarLoai);
        listView = findViewById(R.id.listviewLoai);

        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);

        arrayList = new ArrayList<>();

        Cursor cursor = database.getDataLoai();
        while (cursor.moveToNext()){
            int maLoai = cursor.getInt(0);
            String tenLoai = cursor.getString(1);
            int soLuong = cursor.getInt(2);

            arrayList.add(new Loai(maLoai, tenLoai, soLuong));
        }
        adapterLoai = new adapterLoai(ActivityLoai.this, arrayList);
        listView.setAdapter(adapterLoai);
        cursor.moveToFirst();
        cursor.close();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityLoai.this, ActivityComputer.class);
                int id = arrayList.get(i).getMaLoai();
                intent.putExtra("maLoai", id);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuadd:
                Intent intent = new Intent(ActivityLoai.this, ActivityAddLoai.class);
                startActivity(intent);
                break;
            default:
                Intent intent1 = new Intent(ActivityLoai.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        count++;
        if(count>=1){
            Intent intent = new Intent(ActivityLoai.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}