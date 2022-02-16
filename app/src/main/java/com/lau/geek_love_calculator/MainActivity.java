package com.lau.geek_love_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView col1, col2, col3, score, message;
    EditText name;
    Spinner list;
    ImageView logo;
    TableLayout table;
    TableRow row;
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;

        list = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(myAdapter);

        name =(EditText)findViewById(R.id.name);

        score = (TextView) findViewById(R.id.score);

        logo = (ImageView) findViewById(R.id.img);

        message = (TextView) findViewById(R.id.message);

        table = (TableLayout) findViewById(R.id.table);
        table.setColumnStretchable(0, true);
        table.setColumnStretchable(1, true);
        table.setColumnStretchable(2, true);
        table.setColumnStretchable(3, true);

    }

    public void calculate(View v){

        counter++;
        String full_name = name.getText().toString();
        if (!full_name.isEmpty()){
            message.setVisibility(View.GONE);
            String language = list.getSelectedItem().toString();
            Random r = new Random();
            int love_percent = r.nextInt(101);
            score.setText("" + love_percent + "%");

            name.setText("");

            //display percentage
            logo.setTranslationX(1500);
            switch (language){
                case "Java":
                    logo.setImageResource(R.drawable.java);
                    break;
                case "C++":
                    logo.setImageResource(R.drawable.c_plus);
                    break;
                case "JavaScript":
                    logo.setImageResource(R.drawable.javascript);
                    break;
                case "Python":
                    logo.setImageResource(R.drawable.python);
                    break;
                case "C#":
                    logo.setImageResource(R.drawable.c_sharp);
                    break;
                case "HTML":
                    logo.setImageResource(R.drawable.html);
                    break;
                case "R":
                    logo.setImageResource(R.drawable.r);
                    break;
                case "Swift":
                    logo.setImageResource(R.drawable.swift);
                    break;
                case "PHP":
                    logo.setImageResource(R.drawable.php);
                    break;
                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

            }
            logo.animate().translationXBy(-1500).rotation(3600).setDuration(800);

            row = new TableRow(this);
            col1 = new TextView(this);
            col2= new TextView(this);
            col3 = new TextView(this);
            col1.setText(full_name);
            col1.setTextSize(20);
            col1.setGravity(Gravity.CENTER);
            col1.setTypeface(null, Typeface.BOLD);
            col2.setText(language);
            col2.setTextSize(20);
            col2.setGravity(Gravity.CENTER);
            col2.setTypeface(null, Typeface.BOLD);
            col3.setText("" + love_percent + "%");
            col3.setTextSize(20);
            col3.setGravity(Gravity.CENTER);
            col3.setTypeface(null, Typeface.BOLD);
            row.addView(col1);
            row.addView(col2);
            row.addView(col3);
            table.addView(row);
        }else
            message.setVisibility(View.VISIBLE);

    }
}