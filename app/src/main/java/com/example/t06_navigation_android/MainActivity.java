package com.example.t06_navigation_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private TextView textView;
    private NavigationView navigation;
    private SwitchCompat switchCompat;
    private DrawerLayout drawerLayout;
    private String urlPeticion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        peticionInicial();
    }

    private void peticionInicial() {
        JsonObjectRequest peticionJson= new JsonObjectRequest(Request.Method.GET, urlPeticion, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("test",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test","error en la conexion");
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(peticionJson);
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
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void instancias() {
        toolbar= findViewById(R.id.toolbar);
        urlPeticion= "https://www.thesportsdb.com/api/v1/json/1/all_leagues.php";
        drawerLayout= findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        switchCompat = (SwitchCompat) navigation.getMenu().findItem(R.id.switchNav).getActionView();

        textView= navigation.getHeaderView(0).findViewById(R.id.textoHeader);//coger elementos dentro del Header de un Navigation
        textView.setText("aqdghs");
        setSupportActionBar(toolbar);
    }
}
