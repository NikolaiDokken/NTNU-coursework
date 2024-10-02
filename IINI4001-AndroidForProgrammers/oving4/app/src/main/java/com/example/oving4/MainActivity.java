package com.example.oving4;

import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ColorListFragment.TeleListListener {

    private ColorImageFragment image;
    private long ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id){
        ID = id;
        image = new ColorImageFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        image.setID(id);
        ft.replace(R.id.fragment_image, image);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next:
                Toast.makeText(getApplicationContext(),"Next",Toast.LENGTH_SHORT).show();
                if(ID < 2) itemClicked( ID+1);
                return true;
            case R.id.forrige:
                Toast.makeText(getApplicationContext(),"Previous",Toast.LENGTH_SHORT).show();
                if(ID > 0) itemClicked( ID-1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}