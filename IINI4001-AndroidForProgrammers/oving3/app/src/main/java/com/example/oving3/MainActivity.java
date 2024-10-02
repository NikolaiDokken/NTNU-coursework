package com.example.oving3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private int clickPos = -1;
    private Venn[] arrayVenn;
    private ArrayList<Venn> venner;
    private ArrayAdapter<Venn> adapter;
    private ListView vennerList;
    private TextView nameText;
    private TextView dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = (TextView) findViewById(R.id.editNavn);
        dateText = (TextView) findViewById(R.id.editFodselsdato);
        initierList();
        initierBtn();
    }

    private void initierList(){
        vennerList = (ListView) findViewById(R.id.vennerList);
        arrayVenn = new Venn[]{};
        venner = new ArrayList<Venn>(Arrays.asList(arrayVenn));
        adapter = new ArrayAdapter<Venn>(this, android.R.layout.simple_list_item_activated_1, venner);

        vennerList.setAdapter(adapter);
        vennerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        vennerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id){
                clickPos = vennerList.getCheckedItemPosition();
                nameText.setText(venner.get(clickPos).navn);
                dateText.setText(venner.get(clickPos).dato);
            }
        });
    }

    private void initierBtn(){
        Button addBtn = (Button) findViewById(R.id.leggTilNavnBtn);
        Button editBtn = (Button) findViewById(R.id.endreNavnBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String navn = nameText.getText().toString();
                String dato = dateText.getText().toString();

                if(navn.length() > 0 && dato.length() > 0) {
                    Venn venn = new Venn(navn, dato);
                    venner.add(venn);
                    adapter.notifyDataSetChanged();

                    nameText.setText("");
                    dateText.setText("");
                }
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if ( clickPos >= 0){
                    venner.get(clickPos).navn = nameText.getText().toString();
                    venner.get(clickPos).dato = dateText.getText().toString();

                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}

class Venn{
    public String navn;
    public String dato;

    public Venn(String n, String d){
        this.navn = n;
        this.dato = d;
    }

    public String toString(){
        return "Navn: " + this.navn + ", Dato: " + this.dato;
    }
}