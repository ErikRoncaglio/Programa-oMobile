package com.example.listagemgustavo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayAdapterCarros extends ArrayAdapter<String> {

    public ArrayAdapterCarros(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_lista, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewNome = view.findViewById(R.id.textViewNome);

        String carro = getItem(position);
        textViewNome.setText(carro);

        // Aqui você deve definir a imagem correta para cada carro
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
        }

        return view;
    }
}
