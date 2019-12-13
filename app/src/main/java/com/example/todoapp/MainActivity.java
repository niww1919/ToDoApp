package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.AbsListView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SharedPreferences preferences;
    Set<String> stringSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvViewToDo);
        preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        /**
         loadRecycleView();
         */
        recyclerView = findViewById(R.id.rvViewToDo);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ToDoAdapter adapter = new ToDoAdapter();
        recyclerView.setAdapter(adapter);

    }

}
