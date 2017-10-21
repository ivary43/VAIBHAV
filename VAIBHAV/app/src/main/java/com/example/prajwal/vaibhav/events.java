package com.example.prajwal.vaibhav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

    }
    public void workshop(View view) {
        Intent i = new Intent(this, Workshop.class);
        startActivity(i);

    }
    public void gaming(View view){
        Intent i=new Intent(this,Gaming.class);
        startActivity(i);

    }
    public void placementfever(View view){
        Intent i=new Intent(this,placement_fever.class);
        startActivity(i);
    }
    public void codeathon(View view){
        Intent i=new Intent(this,codeathon.class);
        startActivity(i);
    }
}
