package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText title , note;
    Button Add;
    ListView listView;
    ListviewAdapter listviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.Title);
        note = findViewById(R.id.Note);
        Add = findViewById(R.id.Add);
        listView = findViewById(R.id.listview);


        Add.setOnClickListener(v -> {
            String txt_title = title.getText().toString();
            String txt_notes = note.getText().toString();



            NoteModel nm = new NoteModel(txt_title , txt_notes , -1);
            try {
                DatabaseModel databaseModel = new DatabaseModel(MainActivity.this);
                boolean success = databaseModel.add_notes(nm);
                if (success) {
                    Toast.makeText(MainActivity.this, "Notes successfully added", Toast.LENGTH_SHORT).show();
                    

                } else {
                    Toast.makeText(MainActivity.this, "Failed to add the data", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            title.setText("");
            title.setHint("Title");
            note.setText("");
            note.setHint("Note");
        });



    }
}
/*
Clean App Architecture (MVVM)
1) Separation of concerns:
Since app activity and fragments are not under your control, you should not link your data to your activities and fragment classes.

2) Drive UI from Data Models
Data models should be made for storage of data and retrieving them and UI should be driven by the model classes.

3) Single source of truth
When a new data is recieved, your code should assign it to SSOT using which you can manage it's modification, deletion and retrieval etc. Generally it's SQLIte database.

4) Unidirectional Data Flow


# Architecture
UI layer ----> Domain Layer(Optional) ----> Data model
Domain layer used when multiple view models depend upon a common class or data, we make domain and layer and it's used by all the models.

UI layer implements on the basis of information recieved by the UI state layer which stors the state of the current running activity. It might have multiple streams to store the state
depending on interdependency of states we need.







*/








