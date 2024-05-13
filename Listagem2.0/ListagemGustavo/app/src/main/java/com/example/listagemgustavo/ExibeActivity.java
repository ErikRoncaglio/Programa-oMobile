package com.example.listagemgustavo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ExibeActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textViewExibe);

        // Recebe o nome do carro enviado pela MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String carro = extras.getString("carro");

            // Define o nome do carro na TextView
            textView.setText(carro);

            // Define a imagem do carro na ImageView
            switch (carro) {
                case "maverick":
                    imageView.setImageResource(R.drawable.maverick);
                    break;
                case "palio":
                    imageView.setImageResource(R.drawable.palio);
                    break;
                case "uno":
                    imageView.setImageResource(R.drawable.uno);
                    break;
                case "celta":
                    imageView.setImageResource(R.drawable.celta);
                    break;
                case "opala":
                    imageView.setImageResource(R.drawable.opala);
                    break;
                default:
                    // Defina uma imagem padrão ou trate outros casos, se necessário
                    break;
            }
        }

    }

    private void onclick() {
        Intent intent = new Intent(ExibeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
