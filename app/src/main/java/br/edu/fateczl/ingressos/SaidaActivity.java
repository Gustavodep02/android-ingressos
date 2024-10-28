package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class SaidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSaida = findViewById(R.id.tvSaida);
        tvSaida.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle.getString("tipo").equals("VIP") ){
            tvSaida.setText("Ingresso VIP\nID: " + bundle.getString("id") + "\nValor: R$ " + bundle.getFloat("valor") + "\nFunção: " + bundle.getString("funcao") + "\nTaxa: R$ " + bundle.getFloat("taxa") + "\nValor Final: R$ " + bundle.getFloat("valorFinal"));
        } else {
            tvSaida.setText("Ingresso Comum\nID: " + bundle.getString("id") + "\nValor: R$ " + bundle.getFloat("valor") + "\nTaxa: R$ " + bundle.getFloat("taxa") + "\nValor Final: R$ " + bundle.getFloat("valorFinal"));
        }

        btnVoltar.setOnClickListener(op -> {
            Intent i = new Intent(this, MainActivity.class);
            this.startActivity(i);
            this.finish();
        });
    }
}