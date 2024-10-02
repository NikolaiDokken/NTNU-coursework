package com.example.simplemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu meny){
        super.onCreateOptionsMenu(meny);//kaller metoden som vi arver, er dog ikke nødvendig
        meny.add("Nikolai"); //legger til meny-valg med teksten «Valg 1»
        meny.add("Dokken");
        Log.i("onCreateOptionsMenu()","meny laget"); //skriver ut til logg, vises i LogCat
        return true; //true her gjør at menyen vil vises
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getTitle().equals("Nikolai")){
            Log.i("onOptionsItemSelected()","Nikolai er trykket av brukeren");
        }
        if (item.getTitle().equals("Dokken")){
            Log.i("onOptionsItemSelected()","Dokken er trykket av brukeren");
        }
        return true; //hvorfor true her? Se API-dokumentasjonen!!
    }
}