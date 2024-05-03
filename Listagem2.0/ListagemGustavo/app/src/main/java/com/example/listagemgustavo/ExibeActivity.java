package com.example.listagemgustavo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeActivity extends AppCompatActivity {

    ImageView ImageViewIMG;
    TextView textViewExibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);
        Intent i =getIntent();
        Bundle b=i.getExtras();
        String carro =i.getStringExtra("position");
        ImageViewIMG=findViewById(R.id.imageView2);

if(carro.equals("maverick")){
    ImageViewIMG.setImageResource(R.drawable.maverick);
    textViewExibe.setText("Maverick");
}else if(carro.equals("palio")) {
    ImageViewIMG.setImageResource(R.drawable.palio);
    textViewExibe.setText("Palio");
}else if(carro.equals("uno")) {
    ImageViewIMG.setImageResource(R.drawable.uno);
    textViewExibe.setText("Uno");
}else if(carro.equals("celta")) {
    ImageViewIMG.setImageResource(R.drawable.celta);
    textViewExibe.setText("celta");
}else if(carro.equals("opala")) {
    ImageViewIMG.setImageResource(R.drawable.opala);
    textViewExibe.setText("Opala");
}


    }

}
