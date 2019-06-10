package com.example.masjidmasjid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final List<HashMap<String,String>> list = new ArrayList<>();
        for(int i = 0; i<DataList.foto.length;i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("foto", String.valueOf(DataList.foto[i]));
            map.put("namaMasjid", DataList.nama[i]);
            map.put("keteranganMasjid", DataList.keterangan[i]);
            list.add(map);
        }

        String[] from = {"foto", "namaMasjid", "keteranganMasjid"};

        int[] to = {R.id.ivFoto, R.id.tvNamaMasjid, R.id.tvKeteranganMasjid};

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                list,
                R.layout.items,
                from,
                to
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, HeheActivity.class);
                intent.putExtra("foto", list.get(i).get("foto"));
                intent.putExtra("namaMasjid", list.get(i).get("namaMasjid"));
                intent.putExtra("keteranganMasjid", list.get(i).get("keteranganMasjid"));
            }
        });
    }
}
