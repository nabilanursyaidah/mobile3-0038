package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.angkatan_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText stambukEditText = findViewById(R.id.editTextText);
                EditText namaEditText = findViewById(R.id.editTextText2);
                Spinner angkatanSpinner = findViewById(R.id.spinner);
                RadioGroup prodiRadioGroup = findViewById(R.id.radioGroup);
                CheckBox bemCheckBox = findViewById(R.id.checkBox);
                CheckBox penulisanCheckBox = findViewById(R.id.checkBox2);
                CheckBox kewirausahaanCheckBox = findViewById(R.id.checkBox3);
                CheckBox kesenianCheckBox = findViewById(R.id.checkBox4);
                CheckBox jurnalistikCheckBox = findViewById(R.id.checkBox5);
                CheckBox olahragaCheckBox = findViewById(R.id.checkBox6);

                // Ambil nilai yang dipilih dari Spinner dan RadioGroup
                String angkatan = angkatanSpinner.getSelectedItem().toString();
                String prodi = "";
                int selectedId = prodiRadioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton radioButton = findViewById(selectedId);
                    prodi = radioButton.getText().toString();
                }

                // Buat intent untuk pindah ke activity_main2 dan kirim data
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("stambuk", stambukEditText.getText().toString());
                intent.putExtra("nama", namaEditText.getText().toString());
                intent.putExtra("angkatan", angkatan);
                intent.putExtra("prodi", prodi);
                intent.putExtra("bem", bemCheckBox.isChecked());
                intent.putExtra("penulisan", penulisanCheckBox.isChecked());
                intent.putExtra("kewirausahaan", kewirausahaanCheckBox.isChecked());
                intent.putExtra("kesenian", kesenianCheckBox.isChecked());
                intent.putExtra("jurnalistik", jurnalistikCheckBox.isChecked());
                intent.putExtra("olahraga", olahragaCheckBox.isChecked());

                // Jalankan intent
                startActivity(intent);
            }
        });
    }
}
