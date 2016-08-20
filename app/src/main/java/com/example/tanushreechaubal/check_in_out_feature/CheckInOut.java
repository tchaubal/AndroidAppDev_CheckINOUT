package com.example.tanushreechaubal.check_in_out_feature;

import android.support.v7.app.AppCompatActivity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CheckInOut extends AppCompatActivity{

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_out);

        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.numberOfPeople,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i)+" people selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onStart(){
        super.onStart();
        EditText txtDate1 = (EditText) findViewById(R.id.txtdate1);
        txtDate1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                    dialog.show(ft1, "DatePicker");
                }
            }
        });

        EditText txtDate2 = (EditText) findViewById(R.id.txtdate2);
        txtDate2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                    dialog.show(ft2, "DatePicker");
                }
            }
        });

        Button checker_button = (Button) findViewById(R.id.checkAvailability_Button);
        checker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home is Available!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
