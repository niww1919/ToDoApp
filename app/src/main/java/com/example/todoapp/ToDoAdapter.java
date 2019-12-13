package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Iterator;
import java.util.Set;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    Set<String> textFromSet;
    Iterator<String> iterator;


    public ToDoAdapter(Set<String> text) {
        this.textFromSet = text;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //todo what is it
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.todo_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        iterator = textFromSet.iterator();
//        while (iterator.hasNext()) {
//
//            holder.textView.setText(iterator.next());
////            holder.linearLayout.addView(holder.textView);
//        }

            holder.textView.setText(textFromSet.toString());



    }

    @Override
    public int getItemCount() {

        return textFromSet.size();//fixme display content
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvViewToDo);
//            textView = new TextView(itemView.getContext());
//            linearLayout = itemView.findViewById(R.id.ll);
        }

        void setTextView(String text) {
            textView.setText(text);

        }
    }
}
