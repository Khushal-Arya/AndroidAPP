package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class kilogram extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView kg, gr, mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilogram);

        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        kg = findViewById(R.id.kg);
        gr = findViewById(R.id.gr);
        mg = findViewById(R.id.mg);


        String[] arr = {"kg", "gr.", "mg"};
        unit.setAdapter(new ArrayAdapter(kilogram.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }

    private void update() {
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "kg":
                    setKm(in);
                    break;
                case "gr":
                    setKm(in/1000);
                    break;
                case "mg":
                    setKm(in/100000);
                    break;


            }
        }
    }

    private void setKm(double kg_in) {
        kg.setText(String.valueOf(kg_in));
        gr.setText(String.valueOf(kg_in*1000));
        mg.setText(String.valueOf(kg_in*100000));

    }

}