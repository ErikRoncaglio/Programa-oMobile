package com.example.listagemgustavo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] carros = new String[]{ "celta", "palio", "uno", "opala", "maverick" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView);

        ArrayAdapterCarros adapter = new ArrayAdapterCarros(
                this,
                R.layout.item_lista,
                Arrays.asList(carros)
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String c = carros[i];


                Intent intent = new Intent(MainActivity.this, ExibeActivity.class);
                Bundle b = new Bundle();

                intent.putExtra("carro", c);

                startActivity(intent);
            }
        });
    }
}
