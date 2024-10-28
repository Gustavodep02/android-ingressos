package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.ingressos.model.Ingresso;
import br.edu.fateczl.ingressos.model.IngressoVIP;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {
    private EditText etValor, etID, etFunc, etTaxa;
    private CheckBox cbVIP;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etValor = findViewById(R.id.etValor);
        etID = findViewById(R.id.etID);
        etFunc = findViewById(R.id.etFunc);
        etTaxa = findViewById(R.id.etTaxa);
        cbVIP = findViewById(R.id.cbVIP);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> {
            calcular();
        });

    }
    public void calcular(){
        if(cbVIP.isChecked()){
            IngressoVIP ingresso = new IngressoVIP();
            ingresso.setId(etID.getText().toString());
            String id = ingresso.getId();
            ingresso.setValor(Float.parseFloat(etValor.getText().toString()));
            float valor = ingresso.getValor();
            ingresso.setFuncao(etFunc.getText().toString());
            String funcao = ingresso.getFuncao();
            float taxa = Float.parseFloat(etTaxa.getText().toString());
            float valorFinal = ingresso.valorFinal(taxa);
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putFloat("valor", valor);
            bundle.putString("funcao", funcao);
            bundle.putFloat("valorFinal", valorFinal);
            bundle.putFloat("taxa", taxa);
            bundle.putString("tipo", "VIP");
            troca(bundle);
        }else{
            Ingresso ingresso = new Ingresso();
            ingresso.setId(etID.getText().toString());
            String id = ingresso.getId();
            ingresso.setValor(Float.parseFloat(etValor.getText().toString()));
            float valor = ingresso.getValor();
            float taxa = Float.parseFloat(etTaxa.getText().toString());
            float valorFinal = ingresso.valorFinal(taxa);
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putFloat("valor", valor);
            bundle.putFloat("valorFinal", valorFinal);
            bundle.putFloat("taxa", taxa);
            bundle.putString("tipo", "Comum");
            troca(bundle);
        }


    }
    private void troca(Bundle bundle){
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        startActivity(i);
        this.finish();
    }
}