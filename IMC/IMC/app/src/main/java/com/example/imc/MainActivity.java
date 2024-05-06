package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.view.ViewDebug;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

        private EditText edPeso, edAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso=findViewById(R.id.edPeso);
        edAltura=findViewById(R.id.edAltura);
    }
    public void calc(View view){

      double peso = Double.parseDouble(edPeso.getText().toString());
       double altura = Double.parseDouble(edAltura.getText().toString());



       DecimalFormat df = new DecimalFormat("##,##");
       double imc = peso/(altura*altura);
        String result = df.format(imc);




Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
       intent.putExtra("imc", result);
startActivity(intent);

    }
}