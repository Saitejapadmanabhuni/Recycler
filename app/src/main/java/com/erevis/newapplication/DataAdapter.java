package com.erevis.newapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewAdapter> {


    private final Context context;
    private final ArrayList<Dataclass> list;

    public DataAdapter(Context context, ArrayList<Dataclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DataAdapter.DataViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new DataViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewAdapter holder, int position) {
        final Dataclass CurrentItem=list.get(position);

        holder.name.setText(CurrentItem.getName());
        holder.course.setText(CurrentItem.getCourse());
        holder.college.setText(CurrentItem.getCollege());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DataViewAdapter extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView course;
        private final TextView college;
        public DataViewAdapter(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            course=itemView.findViewById(R.id.course);
            college=itemView.findViewById(R.id.college);
        }
    }
}

