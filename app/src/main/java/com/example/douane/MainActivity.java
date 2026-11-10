package com.example.douane;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNom = findViewById(R.id.et_nomamin souaii);
        EditText etNaiss = findViewById(R.id.et_naissanceamin souaii);
        EditText etDest = findViewById(R.id.et_destinationamin souaii);
        RadioGroup rgMotif = findViewById(R.id.rg_motifamin souaii);
        Button btn = findViewById(R.id.btn_inspecteramin souaii);

        btn.setOnClickListener(v -> {
            String nom = etNom.getText().toString().trim();
            String naiss = etNaiss.getText().toString().trim();
            String dest = etDest.getText().toString().trim();
            int checked = rgMotif.getCheckedRadioButtonId();

            // 2 - naamlou el check 
            if (nom.isEmpty() || naiss.isEmpty() || dest.isEmpty() || checked == -1) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }
            if (naiss.length() != 4 || dest.length() != 4) {
    Toast.makeText(this, "Les années doivent avoir 4 chiffres", Toast.LENGTH_SHORT).show();
    return;
}
            // 3 - na9rawh
            String motif = ((RadioButton) findViewById(checked)).getText().toString();

            Intent i = new Intent(this, VerificationActivity.class);
            i.putExtra(Keys.build(Keys.MATRICULE, Keys.NOM), nom);
            i.putExtra(Keys.build(Keys.MATRICULE, Keys.NAISSANCE), Integer.parseInt(naiss));
            i.putExtra(Keys.build(Keys.MATRICULE, Keys.DESTINATION), Integer.parseInt(dest));
            i.putExtra(Keys.build(Keys.MATRICULE, Keys.MOTIF), motif);
            startActivity(i);
        });
    }
}
