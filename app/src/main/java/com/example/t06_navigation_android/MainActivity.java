package com.example.t06_navigation_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private TextView textView;
    private NavigationView navigation;
    private SwitchCompat switchCompat;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ligaEsp:
                        textView.setText("Española");
                        break;
                    case R.id.ligaAlemana:
                        textView.setText("Alemana");
                        break;
                    case R.id.ligaIng:
                        textView.setText("Inglesa");
                        break;
                }
                return false;
            }
        });
    }

    private void instancias() {
        toolbar= findViewById(R.id.toolbar);
        navigation = findViewById(R.id.navigation);
        switchCompat = (SwitchCompat) navigation.getMenu().findItem(R.id.switchNav).getActionView();

        textView= navigation.getHeaderView(0).findViewById(R.id.textoHeader);//coger elementos dentro del Header de un Navigation
        textView.setText("aqdghs");
        setSupportActionBar(toolbar);
    }
}
