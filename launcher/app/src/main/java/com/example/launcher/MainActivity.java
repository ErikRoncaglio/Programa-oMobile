package com.example.launcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando ListView
        ListView listView = findViewById(R.id.listview_apps);

        // Obtendo informações sobre os aplicativos instalados
        PackageManager packageManager = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> appList = packageManager.queryIntentActivities(mainIntent, 0);

        // Criando uma lista de ApplicationInfo a partir dos ResolveInfo
        final List<ApplicationInfo> packageInfoList = getAppInfoList(appList, packageManager);

        // Configurando o adapter personalizado para a ListView
        AppAdapter appAdapter = new AppAdapter(this, R.layout.item_lista, packageInfoList);
        listView.setAdapter(appAdapter);

        // Configurando o onItemClick para abrir o aplicativo selecionado
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo applicationInfo = packageInfoList.get(position);
                String packageName = applicationInfo.packageName;

                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<ApplicationInfo> getAppInfoList(List<ResolveInfo> appList, PackageManager packageManager) {
        List<ApplicationInfo> packageInfoList = new ArrayList<>();
        if (appList != null) {
            for (ResolveInfo resolveInfo : appList) {
                packageInfoList.add(resolveInfo.activityInfo.applicationInfo);
            }
        }
        return packageInfoList;
    }


    public static class AppAdapter extends ArrayAdapter<ApplicationInfo> {

        public AppAdapter(MainActivity mainActivity, int item_lista, List<ApplicationInfo> packageInfoList) {
            super(mainActivity, item_lista, packageInfoList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Inflando layout do item da lista
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item_lista, parent, false);

            // Recuperando o objeto ApplicationInfo da posição atual
            ApplicationInfo applicationInfo = getItem(position);

            // Recuperando os componentes do layout
            TextView textViewAppName = view.findViewById(R.id.app_name);
            ImageView imageViewAppIcon = view.findViewById(R.id.app_icon);

            // Setando os valores nos componentes
            assert applicationInfo != null;
            imageViewAppIcon.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));
            textViewAppName.setText(applicationInfo.loadLabel(getContext().getPackageManager()));

            return view;
        }
    }
}
