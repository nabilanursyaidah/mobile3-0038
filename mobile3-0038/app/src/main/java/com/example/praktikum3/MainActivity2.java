package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if (intent != null) {
            TextView stambukTextView = findViewById(R.id.textView9);
            TextView namaTextView = findViewById(R.id.textView10);
            TextView angkatanTextView = findViewById(R.id.textView11);
            TextView prodiTextView = findViewById(R.id.textView12);
            TextView minatTextView = findViewById(R.id.textView13);

            stambukTextView.setText(intent.getStringExtra("stambuk"));
            namaTextView.setText(intent.getStringExtra("nama"));
            angkatanTextView.setText(intent.getStringExtra("angkatan"));
            prodiTextView.setText(intent.getStringExtra("prodi"));

            // Menampilkan CheckBox yang dicentang di TextView
            StringBuilder minat = new StringBuilder();
            if (intent.getBooleanExtra("bem", false)) {
                minat.append("- Badan Eksekutif Mahasiswa\n");
            }
            if (intent.getBooleanExtra("penulisan", false)) {
                minat.append("- Penulisan Karya Ilmiah\n");
            }
            if (intent.getBooleanExtra("kewirausahaan", false)) {
                minat.append("- Kewirausahaan\n");
            }
            if (intent.getBooleanExtra("kesenian", false)) {
                minat.append("- Kesenian\n");
            }
            if (intent.getBooleanExtra("jurnalistik", false)) {
                minat.append("- Jurnalistik\n");
            }
            if (intent.getBooleanExtra("olahraga", false)) {
                minat.append("- Olahraga\n");
            }
            minatTextView.setText(minat.toString());
        }
    }
}
