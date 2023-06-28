package com.erevis.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText Name,Course,College;
    Button Upload;
    FloatingActionButton floatbtn;

    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.Name);
        floatbtn=findViewById(R.id.floatbtn);
        Course=findViewById(R.id.Course);
        College=findViewById(R.id.College);
        Upload=findViewById(R.id.Upload);

        reference=FirebaseDatabase.getInstance().getReference("My Details");

        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Recycler.class));
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });



    }

    private void uploadData(){
        String name=Name.getText().toString();
        String course=Course.getText().toString();
        String college=College.getText().toString();

        Dataclass uploadData = new Dataclass(name,course,college);

        reference.push().setValue(uploadData);

        Toast.makeText(this, "Details Uploaded", Toast.LENGTH_SHORT).show();
    }


}