package com.example.douane;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        Intent in = getIntent();
        nom = in.getStringExtra(Keys.build(Keys.MATRICULE, Keys.NOM));
        int naiss = in.getIntExtra(Keys.build(Keys.MATRICULE, Keys.NAISSANCE), 0);
        int dest = in.getIntExtra(Keys.build(Keys.MATRICULE, Keys.DESTINATION), 0);
        String motif = in.getStringExtra(Keys.build(Keys.MATRICULE, Keys.MOTIF));

        int age = dest - naiss;

        // 3 - affichage f chakl passeport
        ((TextView) findViewById(R.id.tv_nomamin souaii)).setText("Nom : " + nom);
        ((TextView) findViewById(R.id.tv_ageamin souaii)).setText("Âge temporel : " + age + " ans");
        ((TextView) findViewById(R.id.tv_motifamin souaii)).setText("Motif : " + motif);

        Button btnOk = findViewById(R.id.btn_approuveramin souaii);
        Button btnNo = findViewById(R.id.btn_refuseramin souaii);

        if ("Modification du passé".equals(motif) && estPremier(age)) {
            btnOk.setEnabled(false);
        }

        btnOk.setOnClickListener(v -> lancer(true));
        btnNo.setOnClickListener(v -> lancer(false));
    }

    private void lancer(boolean verdict) {
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra(Keys.build(Keys.MATRICULE, Keys.VERDICT), verdict);
        i.putExtra(Keys.build(Keys.MATRICULE, Keys.NOM), nom);
        startActivity(i);
    }

    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
