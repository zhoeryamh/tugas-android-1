package com.hzed.seblac;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pemesanan extends AppCompatActivity {
    Spinner spin;
    EditText text;
    TextView harga_topping, harga_admin, base1, base2, base3;
    RadioGroup admin;
    RadioButton cod, trf;
    ImageButton btn1, btn2;

    //Bundle extra = getIntent().getExtras();

    Integer top, add, up,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        final Integer base = Integer.valueOf(getIntent().getStringExtra("base"));
        setTitle("Seblac: " + getIntent().getStringExtra("title"));

        spin = (Spinner) findViewById(R.id.topping_spinner);

        harga_topping = (TextView) findViewById(R.id.harga);
        harga_admin = (TextView) findViewById(R.id.admin);
        base1 = (TextView) findViewById(R.id.base_1);
        base2 = (TextView) findViewById(R.id.base_2);
        base3 = (TextView) findViewById(R.id.base_3);

        text = (EditText) findViewById(R.id.text_1);

        admin = (RadioGroup) findViewById(R.id.group_1);
        cod = (RadioButton) findViewById(R.id.radio_1);
        trf = (RadioButton) findViewById(R.id.radio_2);

        btn1 = (ImageButton) findViewById(R.id.button_1);
        btn2 = (ImageButton) findViewById(R.id.button_2);

        btn1.setEnabled(false);
        btn1.setVisibility(View.GONE);
        btn2.setEnabled(false);
        base1.setText(String.valueOf(base));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.topping, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set data di GridView
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        top = 1000;
                        break;
                    case 1:
                        top = 1500;
                        break;
                    case 2:
                        top = 2000;
                        break;
                    case 3:
                        top = 3000;
                        break;
                    default:
                        Toast.makeText(Pemesanan.this, "Pilihan belum dikonfigurasi.", Toast.LENGTH_SHORT).show();
                }
                harga_topping.setText(String.valueOf(top));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        admin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (cod.isChecked()) {
                    add = 0;
                } else if (trf.isChecked()) {
                    add = 5000;
                }
                harga_admin.setText(String.valueOf(add));
                btn2.setEnabled(true);

                //up = top + add;
                //base2.setText(String.valueOf(up));

                //sum = base + up;
                //base3.setText(String.valueOf(sum));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(text.getText().toString())) {
                    text.setError("Isi Nama Pemesan.");
                } else {
                    up = top + add;
                    sum = base + up;

                    base2.setText(String.valueOf(up));
                    base3.setText(String.valueOf(sum));

                    cod.setEnabled(false);
                    trf.setEnabled(false);
                    spin.setEnabled(false);
                    text.setEnabled(false);

                    btn2.setVisibility(View.GONE);
                    btn1.setVisibility(View.VISIBLE);
                    btn1.setEnabled(true);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(Pemesanan.this, Final.class)).putExtra("nama",text.getText().toString()).putExtra("harga", String.valueOf(sum)).putExtra("seblak",getIntent().getStringExtra("title")));
            }
        });
    }
}
