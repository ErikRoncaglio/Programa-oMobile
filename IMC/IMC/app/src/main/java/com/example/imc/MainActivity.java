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

       if (imc<18.5) {
           Toast.makeText(this, "Abaixo do peso", Toast.LENGTH_SHORT).show();
       } else if (imc>18.5 && imc<24.9){
           Toast.makeText(this, "Peso normal", Toast.LENGTH_SHORT).show();
       }else if (imc>24.9 && imc<29.9){
           Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show();
       }else if (imc>30 && imc<34.9){
           Toast.makeText(this, "Obesidade grau 1", Toast.LENGTH_SHORT).show();
       } else if (imc>35 && imc<39.9){
           Toast.makeText(this, "Obesidade grau 2", Toast.LENGTH_SHORT).show();
       }else if (imc>40){
           Toast.makeText(this, "Obesidade grau 3", Toast.LENGTH_SHORT).show();
       }


Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
       intent.putExtra("imc", result);
startActivity(intent);

    }
}