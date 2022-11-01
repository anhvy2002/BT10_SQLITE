package com.test.bt10_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.test.bt10_sqlite.ActivityComputer;
import com.test.bt10_sqlite.ActivityLoai;
import com.test.bt10_sqlite.Computer;
import com.test.bt10_sqlite.Loai;
import com.test.bt10_sqlite.R;

import java.util.ArrayList;

public class adapterComputer extends BaseAdapter {
    private ActivityComputer context;
    private ArrayList<Computer> arrayList;

    public adapterComputer(ActivityComputer context, ArrayList<Computer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_loai, null);

        TextView TextViewTenMay = view.findViewById(R.id.TextViewTenMay);
        TextView TextViewGia = view.findViewById(R.id.TextViewGia);
        ImageButton imageDelete = view.findViewById(R.id.mayDelete);
        ImageButton imageInfor = view.findViewById(R.id.mayInfor);
        ImageButton imageUpdate = view.findViewById(R.id.mayUpdate);

        Computer computer = arrayList.get(i);

        TextViewTenMay.setText(computer.getTenMay());
        TextViewGia.setText(computer.getGia());

        int maMay = computer.getMaMay();

        imageInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}
