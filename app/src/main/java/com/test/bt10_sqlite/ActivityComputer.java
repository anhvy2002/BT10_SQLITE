package com.test.bt10_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;

import com.test.bt10_sqlite.adapter.adapterComputer;
import com.test.bt10_sqlite.database.database;

import java.util.ArrayList;

public class ActivityComputer extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    ArrayList<Computer> arrayList;
    database database;
    adapterComputer adapterComputer;

    int maLoai = 0;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        toolbar = findViewById(R.id.toolbarComputer);
        listView = findViewById(R.id.listviewComputer);
    }
}