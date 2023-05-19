package com.example.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    EditText name,city,number,bg;
    Button reg_btn;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        city=findViewById(R.id.city);
        number=findViewById(R.id.phone);
        bg=findViewById(R.id.BG);
        reg_btn=findViewById(R.id.button);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> m =new HashMap<String,Object>();
                m.put("Name", name.getText().toString());
                m.put("City", city.getText().toString());
                m.put("Number", number.getText().toString());
                m.put("Blood Group", bg.getText().toString());
                firebaseDatabase.getInstance().getReference().child("User").setValue(m);

                Toast.makeText(MainActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}