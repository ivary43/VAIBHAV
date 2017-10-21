package com.example.prajwal.vaibhav;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;
import ss.com.bannerslider.views.indicators.IndicatorShape;

 public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
       private BannerSlider bannerSlider;
       public static final  int RC_SIGN_IN = 1;
       private FirebaseAuth mFirebaseAuth;
       private FirebaseAuth.AuthStateListener mAuthStateListener;
       private static String mUsername;

      private List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),

              new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mFirebaseAuth = FirebaseAuth.getInstance();
          mAuthStateListener = new FirebaseAuth.AuthStateListener(){
         // providers = new ArrayList<>();
              @Override
              public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                  FirebaseUser user = firebaseAuth.getCurrentUser();
                  if (user != null) {
                  //    Toast.makeText(MainActivity.this, "You're now signed in. Welcome to Vibhav.", Toast.LENGTH_SHORT).show();
                  onSignedInInitialize(user.getDisplayName());
                  }
                  else{
                      // user is signed out.
                      onSignedOutCleanup();
                      startActivityForResult(
                              AuthUI.getInstance()
                                      .createSignInIntentBuilder()
                                      .setAvailableProviders(providers)
                                      .build(),
                              RC_SIGN_IN);

                  }
              }
          };
        setupViews();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
     @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                 super.onActivityResult(requestCode, resultCode, data);
                 if (requestCode == RC_SIGN_IN) {
                         if (resultCode == RESULT_OK) {
                                 // Sign-in succeeded, set up the UI
                                        Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
                             } else if (resultCode == RESULT_CANCELED) {
                                 // Sign in was canceled by the user, finish the activity
                                         Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                                 finish();
                             }
                    }
             }
     @Override
    protected void onResume() {
                 super.onResume();
                 mFirebaseAuth.addAuthStateListener(mAuthStateListener);
            }

            @Override
    protected void onPause() {
                 super.onPause();
                 if (mAuthStateListener != null) {
                         mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
                   }
     }
     private void onSignedInInitialize(String username){
        mUsername = username;

     }
     private void onSignedOutCleanup(){
          mUsername = "ANONYMOUS";

     }
    public void events(View view){
        Intent i=new Intent(this,events.class);
        view.getContext().startActivity(i);
        Toast.makeText(this,"List of all events", Toast.LENGTH_SHORT).show();
    }
     public void timetable(View view){
         Intent i=new Intent(this,timetable.class);
          startActivity(i);
         Toast.makeText(this,"Schdeule of all events", Toast.LENGTH_SHORT).show();
     }

     private void setupViews() {
        setupBannerSlider();
        setupPageIndicatorChooser();
        setupSettingsUi();

    }

    private void setupSettingsUi() {
        bannerSlider.setInterval(5000);
        bannerSlider.setIndicatorSize(20);
        bannerSlider.setLoopSlides(true);
        bannerSlider.setMustAnimateIndicators(true);

    }

    private void setupBannerSlider(){
        bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        addBanners();

        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
            }
        });
    }
    private void addBanners(){
        List<Banner> remoteBanners=new ArrayList<>();
        //Add banners using image urls
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/22448491_495032274211552_4978162134174887194_n.jpg?oh=a27090f4fc7273fbfa1538a50b9dd207&oe=5A7F745D"
        ));
        remoteBanners.add(new RemoteBanner(
                 "https://www.hqmenshaircuts.com/wp-content/uploads/2017/05/like-us-on-facebook-button.png"
        ));
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/22365369_494583740923072_6867808831324264377_n.jpg?oh=0b0a53cc45dd5488380c229d1e697b0d&oe=5A845AD8"
        ));
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/22406266_494838707564242_5928751879476281788_n.jpg?oh=52c8723dfb328d991bdf6b338e5f2be0&oe=5A3A5FF0"
        ));
        bannerSlider.setBanners(remoteBanners);

    }

    private void setupPageIndicatorChooser(){

        bannerSlider.setDefaultIndicator(IndicatorShape.CIRCLE);




    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





     @SuppressWarnings("StatementWithEmptyBody")
     @Override
     public boolean onNavigationItemSelected(MenuItem item) {
         // Handle navigation view item clicks here.
         int id = item.getItemId();

         if (id == R.id.nav_camera) {
             // Handle the camera action
         } else if (id == R.id.nav_gallery) {

         } else if (id == R.id.nav_manage) {

         } else if (id == R.id.nav_share) {

         } else if (id == R.id.nav_send) {

         }

         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         drawer.closeDrawer(GravityCompat.START);
         return true;
     }


 }
