package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
ImageView imageViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.textViewResultado);
imageViewResultado=findViewById(R.id.imageView2);



        Intent i = getIntent();
      Bundle bundle =  i.getExtras();
      Log.d("Valor do IMC:", bundle.getString("imc"));

        textView.setText(bundle.getString("imc"));

        if (imc<18.5) {
            Toast.makeText(this, "Abaixo do peso", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.abaixopeso);
        } else if (imc>18.5 && imc<24.9){
            Toast.makeText(this, "Peso normal", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.normal);
        }else if (imc>24.9 && imc<29.9){
            Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade1);
        }else if (imc>30 && imc<34.9){
            Toast.makeText(this, "Obesidade grau 1", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade2);
        } else if (imc>35 && imc<39.9){
            Toast.makeText(this, "Obesidade grau 2", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade3);
        }else if (imc>40){
            Toast.makeText(this, "Obesidade grau 3", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.sobrepeso);
        }


    }
}