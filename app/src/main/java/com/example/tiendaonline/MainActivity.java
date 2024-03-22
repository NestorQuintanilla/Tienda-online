package com.example.tiendaonline;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton dom;
    CheckBox op1, op2, op3, op4, op5, op6, op7, op8;
    TextView ttotal;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dom = findViewById(R.id.rbdomicilio);
        op1 = findViewById(R.id.checkBoxPupusas);
        op2 = findViewById(R.id.checkBoxEnchiladas);
        op3 = findViewById(R.id.checkBoxTortilla);
        op4 = findViewById(R.id.checkBoxDesTipico);
        op5 = findViewById(R.id.checkBoxChocolate);
        op6 = findViewById(R.id.checkBoxCafe);
        op7 = findViewById(R.id.checkBoxLicuado);
        op8 = findViewById(R.id.checkBoxJugo);
        ttotal = findViewById(R.id.texttotal);
        btnCancelar = findViewById(R.id.btncancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restablecer todas las selecciones a su estado inicial
                dom.setChecked(false);
                op1.setChecked(false);
                op2.setChecked(false);
                op3.setChecked(false);
                op4.setChecked(false);
                op5.setChecked(false);
                op6.setChecked(false);
                op7.setChecked(false);
                op8.setChecked(false);

                // Limpiar el texto del total
                ttotal.setText("Total $: 0.00");
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void setBcalcular(View w) {
        int totalCents = 0;
        if (dom.isChecked())
            totalCents += 500; // 5 dólares
        if (op1.isChecked())
            totalCents += 75; // 0.75 dólares
        if (op2.isChecked())
            totalCents += 45; // 0.45 dólares
        if (op3.isChecked())
            totalCents += 70; // 0.70 dólares
        if (op4.isChecked())
            totalCents += 350; // 3.50 dólares
        if (op5.isChecked())
            totalCents += 50; // 0.50 dólares
        if (op6.isChecked())
            totalCents += 85; // 0.85 dólares
        if (op7.isChecked())
            totalCents += 225; // 2.25 dólares
        if (op8.isChecked())
            totalCents += 175; // 1.75 dólares

        double totalDollars = totalCents / 100.0; // Convertir a dólares
        ttotal.setText("Total $: " + String.format("%.2f", totalDollars)); // Mostrar el total con dos decimales
    }
}

