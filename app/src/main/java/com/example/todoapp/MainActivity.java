package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    public static final String DATA_KEY = "Data";
    RecyclerView recyclerView;
    SharedPreferences preferences;
    Set<String> stringSet;
    AppCompatEditText editText;
    AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvViewToDo);
        editText = findViewById(R.id.et);
        button = findViewById(R.id.bottomAdd);
        preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        stringSet = preferences.getStringSet(DATA_KEY, new HashSet<String>());
        Log.i("Log", String.valueOf(stringSet.size()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringSet.add(String.valueOf(editText.getText()));
                editText.setText("");

            }
        });

        /**
         loadRecycleView();
         */
        recyclerView = findViewById(R.id.rvViewToDo);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ToDoAdapter adapter = new ToDoAdapter(stringSet);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.edit().putStringSet(DATA_KEY, stringSet).apply();
    }
}
