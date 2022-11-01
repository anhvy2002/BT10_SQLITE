package com.test.bt10_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.test.bt10_sqlite.ActivityLoai;
import com.test.bt10_sqlite.Loai;
import com.test.bt10_sqlite.R;

import java.util.ArrayList;

public class adapterLoai extends BaseAdapter {

    private ActivityLoai context;
    private ArrayList<Loai> ArrayList;

    public adapterLoai(ActivityLoai context, ArrayList<Loai> arrayList) {
        this.context = context;
        ArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return ArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_loai, null);

        TextView TextViewTenLoai = view.findViewById(R.id.TextViewTenLoai);
        TextView TextViewSoLuong = view.findViewById(R.id.TextViewSoLuong);
        ImageButton imageDelete = view.findViewById(R.id.loaiDelete);
        ImageButton imageInfor = view.findViewById(R.id.loaiInfor);
        ImageButton imageUpdate = view.findViewById(R.id.loaiUpdate);

        Loai loai = ArrayList.get(i);

        TextViewTenLoai.setText(loai.getTenLoai());
        TextViewSoLuong.setText(loai.getSoLuong());

        int maLoai = loai.getMaLoai();

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
        return null;
    }
}
