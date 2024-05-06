package com.example.listagemgustavo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textViewExibe);

        // Recebe o nome do carro selecionado da MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String carro = intent.getStringExtra("carro");
            exibirDetalhesCarro(carro);
        }
    }

    private void exibirDetalhesCarro(String carro) {
        textView.setText(carro);

        // Define a imagem com base no nome do carro
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
                // Se o carro não for encontrado, você pode definir uma imagem padrão ou tratar isso de outra forma
                imageView.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
    }
}
