package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
ImageView imageViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textViewResultado);
imageViewResultado=findViewById(R.id.imageView2);

        imageViewResultado.setImageResource(R.drawable.abaixopeso);

        Intent i = getIntent();
      Bundle bundle =  i.getExtras();
      Log.d("Valor do IMC:", bundle.getString("imc"));

        textView.setText(bundle.getString("imc"));

    }
}