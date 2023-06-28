package com.erevis.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {

    private RecyclerView recycler;

    private ArrayList <Dataclass> list;

    DataAdapter adapter;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recycler=findViewById(R.id.recycler);

        reference= FirebaseDatabase.getInstance().getReference().child("My Details");

        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list=new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    Dataclass data= snapshot.getValue(Dataclass.class);
                    list.add(0,data);
                }

                adapter=new DataAdapter(getApplicationContext(),list);
                adapter.notifyDataSetChanged();
                recycler.setLayoutManager(recycler.getLayoutManager());
                recycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}