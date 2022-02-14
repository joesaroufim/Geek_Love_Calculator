package com.lau.geek_love_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Spinner list;
    TableLayout table;
    TableRow row;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(myAdapter);

        name =(EditText)findViewById(R.id.name);

        table = (TableLayout) findViewById(R.id.table);

    }

    public void calculate(View v){
        String full_name = name.getText().toString();
        String language = list.getSelectedItem().toString();
        Random r = new Random();
        int love_percent = r.nextInt(101);


    }
}