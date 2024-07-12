package com.example.notinhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("minhasnotinha", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR);");
        ContentValues cv = new ContentValues();

        editText = findViewById(R.id.editText);
        listView=findViewById(R.id.listView);
        findViewById(R.id.bntSalvar).setOnClickListener(view -> {
            String texto = editText.getText().toString();
            cv.put("txt", texto);
            db.insert("notas", null, cv);
            listarNotas();
        });

    }

    public void listarNotas() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<String> listatxtnotas = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            listatxtnotas.add(Integer.toString(cursor.getInt(0)) + cursor.getString(1));
            cursor.moveToNext();

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listatxtnotas);
        listView.setAdapter(adapter);
    }

}