package com.example.notes_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListviewAdapter extends ArrayAdapter {
    View view;
    List<NoteModel> arrayList;

    public ListviewAdapter(@NonNull Context context, int resource, int textViewResourceId, List<NoteModel> arrayList) {
        super(context, resource, textViewResourceId, arrayList);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        if(convertView == null){
            view = layoutInflater.inflate(R.layout.activity_listeelement , parent , false);
        }else{
            view = convertView;
        }
        TextView Title = view.findViewById(R.id.title_ele);
        TextView note = view.findViewById(R.id.note_ele);





        return view;
    }
}
