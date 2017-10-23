package com.example.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class technical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);
    }
    public void poci(View view){
        Intent i=new Intent(this,poc.class);
        startActivity(i);
    }
    public void bori(View view){
        Intent i=new Intent(this,bor.class);
        startActivity(i);
    }
    public void aavi(View view){
        Intent i=new Intent(this,aav.class);
        startActivity(i);
    }
    public void vitric(View view){
        Intent i=new Intent(this,vitri.class);
        startActivity(i);
    }
}
