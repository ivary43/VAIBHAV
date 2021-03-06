package com.example.prajwal.vaibhav;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class codeathon extends AppCompatActivity {
    private static Button about;
    private   AlertDialog.Builder about_builder;
    private   AlertDialog.Builder rules_builder;
    private   AlertDialog.Builder judgingCriteria_builder;
    private   AlertDialog.Builder prizes_builder;
    private   AlertDialog.Builder contactUs_builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codeathon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://google.com");

                if (Build.VERSION.SDK_INT>15) {
                    CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                    intentBuilder.setToolbarColor(ContextCompat.getColor(codeathon.this, R.color.colorPrimary));
                    intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(codeathon.this, R.color.colorPrimaryDark));
                    intentBuilder.setStartAnimations(codeathon.this, android.R.anim.fade_in, android.R.anim.fade_out);
                    intentBuilder.setExitAnimations(codeathon.this, android.R.anim.fade_in, android.R.anim.fade_out);
                    CustomTabsIntent customTabsIntent = intentBuilder.build();
                    customTabsIntent.launchUrl(codeathon.this, uri);
                }else {
                    startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW,uri),"Choose Browser..."));
                }

            }
        });

    }

    public void about1(View view){
        about_builder= new AlertDialog.Builder(codeathon.this);
        about_builder.setMessage(R.string.about1);
        AlertDialog alert_about = about_builder.create();
        alert_about.setTitle("About");
        alert_about.show();

    }
    public void rules1(View view){
        rules_builder= new AlertDialog.Builder(codeathon.this);
        rules_builder.setMessage(R.string.rules1);
        AlertDialog alert_about = rules_builder.create();
        alert_about.setTitle("Rules");
        alert_about.show();

    }
    public void judgingCriteria1(View view){
        judgingCriteria_builder= new AlertDialog.Builder(codeathon.this);
        judgingCriteria_builder.setMessage(R.string.judgingCriteria1);
        AlertDialog alert_about = judgingCriteria_builder.create();
        alert_about.setTitle("Judging Criteria");
        alert_about.show();

    }
    public void prizes1(View view){
        prizes_builder= new AlertDialog.Builder(codeathon.this);
        prizes_builder.setMessage(R.string.prizes1);
        AlertDialog alert_about = prizes_builder.create();
        alert_about.setTitle("Prizes");
        alert_about.show();

    }
    public void contactUs1(View view){
        contactUs_builder= new AlertDialog.Builder(codeathon.this);
        contactUs_builder.setMessage(R.string.contactUs1);
        AlertDialog alert_about = contactUs_builder.create();
        alert_about.setTitle("Contact Us");
        alert_about.show();

    }

}

//public void onButtonClickListener(){
//    about =(Button)findViewById(R.id.about);
//   about.setOnClickListener(
//  new View.OnClickListener(){
//@Override
//public void onClick(View v){
// about_builder= new AlertDialog.Builder(placement_fever.this);
// about_builder.setMessage("ftf");
// AlertDialog alert_about = about_builder.create();
// alert_about.setTitle("About");
// alert_about.show();
//  }

//  }
//  );