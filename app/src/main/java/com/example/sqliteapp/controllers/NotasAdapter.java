package com.example.sqliteapp.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.sqliteapp.R;
import com.example.sqliteapp.models.Nota;

public class NotasAdapter extends ArrayAdapter<Nota> {

    int layoutResourceId;

    public NotasAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        layoutResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            Nota item = getItem(position);
            View v = null;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                v = inflater.inflate(layoutResourceId, null);

            } else {
                v = convertView;
            }

            TextView description = (TextView) v.findViewById(R.id.textViewItem);

            description.setText(item.getDesc());

            return v;
        } catch (Exception ex) {
            return null;
        }
    }

}
