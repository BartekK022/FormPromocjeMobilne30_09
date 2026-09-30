package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonOblicz;
    EditText editTextCena;
    CheckBox checkBoxPromocja;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3;
    TextView textViewWynik;
    int cena;
    boolean czyZaznaczone;
    double promocja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonOblicz = findViewById(R.id.button);
        editTextCena = findViewById(R.id.editTextNumberDecimal);
        checkBoxPromocja = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        textViewWynik = findViewById(R.id.textView2);

        editTextCena.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        cena = Integer.parseInt(charSequence.toString());
                    }
                }
        );

        checkBoxPromocja.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                        czyZaznaczone = b;
                    }
                }
        );
//        radioGroup.setOnCheckedChangeListener(
//                new RadioGroup.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
//                        Toast.makeText(MainActivity.this, ""+i,
//                                Toast.LENGTH_SHORT).show();
//                        switch (i) {
//                            case R.id.radio
//                        }
//
//                    }
//                }
//        );

        buttonOblicz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //odczyt ceny po button
                        double cena = Double.parseDouble(editTextCena.getText().toString());
                        boolean czyPromocja = checkBoxPromocja.isChecked();
                        if(czyPromocja) {
                            if(radioButton1.isChecked()) {
                                promocja = 0.1;
                            } else if(radioButton2.isChecked()) {
                                promocja = 0.3;
                            } else {
                                promocja = 0.5;
                            }
                            cena = cena*(1-promocja);
                        }
                        textViewWynik.setText("Cena wynosi:" + cena);

                    }
                }
        );



    }
}