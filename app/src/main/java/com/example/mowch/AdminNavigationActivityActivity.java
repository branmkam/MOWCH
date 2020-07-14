package com.example.mowch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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

import java.util.Objects;

public class AdminNavigationActivityActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_navigation_activity);

        toolbar = findViewById(R.id.toolbar);
        /*toolbar.setLogo(R.drawable.logocropped);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
*/

        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.maindrawer2);
        navigationView = findViewById(R.id.navview2);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        /*fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framlayout, new ContactFragment());
        fragmentTransaction.commit();*/

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
        final Dialog mydialog = new Dialog(AdminNavigationActivityActivity.this);
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
        if(menuItem.getItemId() == R.id.nav_allroutes){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new BlankFragment());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(menuItem.getItemId() == R.id.nav_alldrivers){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new ListofDrivers());
            fragmentTransaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if(menuItem.getItemId() == R.id.nav_home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new ContactFragment());
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

        if(menuItem.getItemId() == R.id.nav_notif){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framlayout, new ContactFragment());
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
}