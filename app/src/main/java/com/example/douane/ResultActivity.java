package com.example.douane;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 1 - yrajeelna el hokm wl el esm
        Intent in = getIntent();
        boolean ok = in.getBooleanExtra(Keys.build(Keys.MATRICULE, Keys.VERDICT), false);
        String nom = in.getStringExtra(Keys.build(Keys.MATRICULE, Keys.NOM));

        View root = findViewById(R.id.root_resultamin souaii);
        TextView tv = findViewById(R.id.tv_messageamin souaii);

        // 2 - tabdil el loun wl background selon l hokm
        if (ok) {
            root.setBackgroundColor(Color.parseColor("#2E7D32"));
            tv.setText("Bon voyage " + nom + " !");
        } else {
            root.setBackgroundColor(Color.parseColor("#C62828"));
            tv.setText(nom + " est en état d'arrestation temporelle");
        }

        Button btn = findViewById(R.id.btn_nouveauamin souaii);
        btn.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        });
    }
}
