package com.example.listagemgustavo;

import android.annotation.SuppressLint;
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
private Context mContext;
private int mResource;
    public ArrayAdapterCarros(@NonNull Context context, int resource, @NonNull List<String> carros) {
        super(context, resource, carros);
        mContext=context;
        mResource=resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textViewNome = convertView.findViewById(R.id.textViewNome);

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

        return convertView;
    }
//    public int getCount(){
//        return mObjects.size();
//    }
}
