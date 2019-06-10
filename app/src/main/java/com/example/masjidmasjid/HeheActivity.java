package com.example.masjidmasjid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HeheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ivFoto = (ImageView) findViewById(R.id.ivFoto);
        TextView tvNamaMasjid = (TextView) findViewById(R.id.tvNamaMasjid);
        TextView tvKeteranganMasjid = (TextView) findViewById(R.id.tvKeteranganMasjid);

        Intent intent = getIntent();
        int foto = Integer.valueOf(intent.getStringExtra("foto"));
        String namaMasjid = intent.getStringExtra("namaMasjid");
        String keteranganMasjid = intent.getStringExtra("keteranganMasjid");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), foto);
        ivFoto.setImageBitmap(bitmap);
        tvNamaMasjid.setText(namaMasjid);
        tvKeteranganMasjid.setText(keteranganMasjid);
    }
}
