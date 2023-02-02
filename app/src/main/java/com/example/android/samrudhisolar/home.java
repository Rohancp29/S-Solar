package com.example.android.samrudhisolar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class home extends AppCompatActivity  {


    ChipNavigationBar navBar;
    FragmentManager fragmentManager;
    public DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navigation_btn;
    TextView logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.bottomnav);
        navigation_btn=findViewById(R.id.navigation_btn);
        drawerLayout=findViewById(R.id.drawerlayout);
        // Click listener of menu items
        navigationView=findViewById(R.id.navigationview);
        logout_btn = findViewById(R.id.logout);

        //To open the navigation drawer
        navigation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        //Menu button clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.END);
                switch (item.getItemId())
                {
                    case R.id.about_us:
                        Toast.makeText(home.this, "This is about us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.privacy:
                        Toast.makeText(home.this, "This is privacy", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.refund:
                        Toast.makeText(home.this, "This is refund", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(home.this, "This is share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.contact:
                        Toast.makeText(home.this, "This is contact", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(home.this, "Logout", Toast.LENGTH_SHORT).show();
            }
        });

        navBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                Fragment fragment = null;
                switch (i) {
                    case R.id.cummunity_frag:
                        fragment = new community_fragg();
                        break;

                    case R.id.home_frag:
                        fragment = new Home_Fragment();
                        break;

                    case R.id.profile_frag:
                        fragment = new profile_Fragment();
                        break;


                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container , fragment)
                            .commit();
                } else {
                    Toast.makeText(home.this , "Toast error" , Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}