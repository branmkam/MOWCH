package com.example.mowch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;

public class UserNavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.maindrawer);
        navigationView = findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framlayout, new StartScreen2());
        fragmentTransaction.commit();


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }




    public void createPopup() {
        final Dialog mydialog = new Dialog(UserNavigationDrawerActivity.this);
        mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mydialog.setContentView(R.layout.pop_emergency);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = -20;
        params.y = 100;
        getWindow().setAttributes(params);
        mydialog.show();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.nav_home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new StartScreen2());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(menuItem.getItemId() == R.id.nav_settings){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new BlankFragment());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(menuItem.getItemId() == R.id.nav_contactAdmin){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.framlayout, new ContactFragment());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(menuItem.getItemId() == R.id.nav_notif){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new BlankFragment());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }


        if(menuItem.getItemId() == R.id.nav_report){
            Intent intent = new Intent(this, EmergencyPop.class);
            startActivity(intent);
            /*createPopup();*/
        }

        if(menuItem.getItemId() == R.id.nav_logout){
            Intent intent = new Intent(this, LogginginActivity.class);
            startActivity(intent);
        }
        /*TODO: log out here*/

        return true;
    }


    public void openDrawer(){
        drawerLayout.openDrawer(drawerLayout);
    }

}