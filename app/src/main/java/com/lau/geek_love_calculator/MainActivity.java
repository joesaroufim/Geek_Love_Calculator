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

    // Declaring Global variables
    TextView col1, col2, col3, score, message;
    EditText name;
    Spinner list;
    ImageView logo;
    TableLayout table;
    TableRow row;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the spinner object by id
        list = (Spinner) findViewById(R.id.spinner);

        //Assigning an adapter and the list as dropdown
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(myAdapter);

        // Getting the object views by their ids
        name =(EditText)findViewById(R.id.name);
        logo = (ImageView) findViewById(R.id.img);
        score = (TextView) findViewById(R.id.score);
        message = (TextView) findViewById(R.id.message);
        table = (TableLayout) findViewById(R.id.table);

        // Setting the number of columns in the table
        table.setColumnStretchable(0, true);
        table.setColumnStretchable(1, true);
        table.setColumnStretchable(2, true);

    }

    public void calculate(View v){
        // The function is invoked once the user clicks on the 'calculate' button
        // and the love percentage is calculated then stored inside the given table.

        logo.setRotation(0); // Resetting the rotation to 0 everytime the user clicks the button

        String full_name = name.getText().toString();

        if (!full_name.isEmpty()){ // Checking if the user entered his name
            message.setVisibility(View.GONE); // removing the error message is the string is not empty
            String language = list.getSelectedItem().toString();
            Random r = new Random(); // Creating a Random object
            int love_percent = r.nextInt(101); // Generating a random integer between 0 and 100
            score.setText("" + love_percent + "%");

            name.setText("");

            //display percentage
            logo.setTranslationX(1500);
            switch (language){ //Checking the language selected by the user and choosing its corresponding logo
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
            logo.animate().translationXBy(-1500).rotation(3600).setDuration(800); // adding some animation for the logo

            //Adding each time a row with 3 columns for the name, language and score respectively
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
            message.setVisibility(View.VISIBLE); // if the name is empty, print a message by setting the text to visible
    }
}