package com.hzed.seblac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    TextView seblak, harga, nama;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        setTitle("Selesai");

        nama = (TextView) findViewById(R.id.nama);
        seblak = (TextView) findViewById(R.id.seblak);
        harga = (TextView) findViewById(R.id.harga);

        nama.setText(getIntent().getStringExtra("nama"));
        seblak.setText(getIntent().getStringExtra("seblak"));
        harga.setText(getIntent().getStringExtra("harga"));

        exit = (Button) findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Final.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }
}
