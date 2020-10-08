package android.teste.matheusaguilar.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Relatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        Log.i("Ciclo de Vida", getClass().getName() + ".onCreate()");

        Intent it = getIntent();

        TextView nomeText = (TextView) findViewById(R.id.textNome);
        TextView idadeText = (TextView) findViewById(R.id.textIdade);
        TextView pesoText = (TextView) findViewById(R.id.textPeso);
        TextView alturaText = (TextView) findViewById(R.id.textAltura);
        TextView imcText = (TextView) findViewById(R.id.textIMC);
        TextView classificacaoText = (TextView) findViewById(R.id.textClassificao);

        nomeText.setText(Html.fromHtml("<b> Nome: </b> " + it.getStringExtra("nome")));
        idadeText.setText(Html.fromHtml("<b> Idade: </b> " + it.getIntExtra("idade", 0) + " anos"));
        pesoText.setText(Html.fromHtml("<b> Peso: </b> " + it.getDoubleExtra("peso", 0.0) + " Kg"));
        alturaText.setText(Html.fromHtml("<b> Altura: </b> " + it.getDoubleExtra("altura", 0.0) + " m"));
        imcText.setText(Html.fromHtml("<b> IMC: </b> " + it.getDoubleExtra("imc", 0.0) + " Kg/m<sup><small>2</small></sup>"));
        classificacaoText.setText(Html.fromHtml("<b> Classificação: </b> " + it.getStringExtra("classificacao")));
    }

    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", getClass().getName() + ".onStart()");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", getClass().getName() + ".onRestart()");
    }

    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", getClass().getName() + ".onResume()");
    }

    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", getClass().getName() + ".onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", getClass().getName() + ".onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", getClass().getName() + ".onDestroy()");
    }

    public void novoCalculoButton(View view){

        /*Gera muitos problemas ao se utilizar o botão voltar*/

        //Intent it = new Intent(getBaseContext(), MainActivity.class);
        //it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        //startActivity(it);

        finish(); //Método mais seguro
    }

}