package com.hzed.seblac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Array Data Seblak
    private String[] nama_seblak = new String[]{
            "Seblak Kerupuk","Seblak Makaroni", "Seblak Kwetiaw"
    };

    //Deklarasi GridView
    GridView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Objek
        view = (GridView) findViewById(R.id.view_grid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, nama_seblak);

        //Set data di GridView
        view.setAdapter(adapter);

        //Action di GridView
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity((new Intent(MainActivity.this, Pemesanan.class)).putExtra("title","Seblak Kerupuk").putExtra("base", "8000"));
                        break;
                    case 1:
                        startActivity((new Intent(MainActivity.this, Pemesanan.class)).putExtra("title","Seblak Makaroni").putExtra("base", "10000"));
                        break;
                    case 2:
                        startActivity((new Intent(MainActivity.this, Pemesanan.class)).putExtra("title","Seblak Kwetiaw").putExtra("base", "7000"));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Pilihan belum dikonfigurasi.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
