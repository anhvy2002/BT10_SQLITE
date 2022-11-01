package com.test.bt10_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.bt10_sqlite.database.database;

public class ActivityAddLoai extends AppCompatActivity {
    Button btAdd;
    EditText edtLoaiTen, edtLoaiSL, edtMa;
    com.test.bt10_sqlite.database.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loai);

        edtLoaiTen = findViewById(R.id.editTextLoaiTen);
        edtLoaiSL = findViewById(R.id.editTextLoaiSoLuong);
        edtMa =findViewById(R.id.editTextLoaiMa);
        btAdd = findViewById(R.id.buttonAddLoai);

        database = new database(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loai loai=  CreateLoai();
                database.AddLoai(loai);

                Intent intent= new Intent(ActivityAddLoai.this, ActivityLoai.class);
                startActivity(intent);

                Toast.makeText(ActivityAddLoai.this, "thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private Loai CreateLoai(){
        int loaiMa = Integer.parseInt(edtMa.getText().toString().trim());
        String loaiTen = edtLoaiTen.getText().toString().trim();
        int loaiSL = Integer.parseInt(edtLoaiSL.getText().toString().trim());
        Loai loai = new Loai(loaiMa,loaiTen, loaiSL);
        return loai;
    }
}