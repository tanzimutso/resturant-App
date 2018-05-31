package com.example.utso.myrestaurantapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class Main2Activity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private FavouriteFragment favouriteFragment;
    private NotificationFragment notificationFragment;
    private TrendingFragment trendingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mMainFrame = (FrameLayout)findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        mMainNav.setOnNavigationItemSelectedListener(naviListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HomeFragment()).commit();
    }
    
   private BottomNavigationView.OnNavigationItemSelectedListener naviListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           Fragment selectedFragment = null;

           switch (item.getItemId()) {
               case R.id.nav_home:
                   selectedFragment = new HomeFragment();
                   break;
               case R.id.nav_cart:
                   selectedFragment = new CartFragment();
                   break;
               case R.id.nav_favourites:
                   selectedFragment = new FavouriteFragment();
                   break;
               case R.id.nav_notification:
                   selectedFragment = new NotificationFragment();
                   break;
               case R.id.nav_trending:
                   selectedFragment = new TrendingFragment();
                   break;
           }

           getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedFragment).commit();

           return true;
       }
   };
}
