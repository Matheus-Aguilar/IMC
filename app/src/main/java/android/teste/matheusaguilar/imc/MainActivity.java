package android.teste.matheusaguilar.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Ciclo de Vida", getClass().getName() + ".onCreate()");

        setContentView(R.layout.activity_main);
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

    public void clickRelatorioButton(View view){

        EditText nomeText = (EditText) findViewById(R.id.nomeInput);
        EditText idadeText = (EditText) findViewById(R.id.idadeInput);
        EditText pesoText = (EditText) findViewById(R.id.pesoInput);
        EditText alturaText = (EditText) findViewById(R.id.alturaInput);

        String nome, classificacao;
        int idade;
        double peso, altura, imc;

        setError(""); //Clear errors log

        /*Impedindo que o formulario possa ser submetido com valores vazios*/
        if(nomeText.getText().toString().equals("")){
            setError("O campo nome não pode ficar vazio");
            return;
        }
        if(idadeText.getText().toString().equals("")){
            setError("O campo idade não pode ficar vazio");
            return;
        }
        if(pesoText.getText().toString().equals("")) {
            setError("O campo peso não pode ficar vazio");
            return;
        }
        if(alturaText.getText().toString().equals("")){
            setError("O campo altura não pode ficar vazio");
            return;
        }

        nome = nomeText.getText().toString();
        idade = Integer.parseInt(idadeText.getText().toString());
        peso = Double.parseDouble(pesoText.getText().toString());
        altura = Double.parseDouble(alturaText.getText().toString());

        if(altura == 0.0){
            setError("Erro: A altura deve ser maior do que zero!!!");
            return;
        }

        imc = Math.floor(100.0 * peso/(altura * altura))/100.0; //Set to decimal cases

        if(imc < 18.5)
            classificacao = "Abaixo do Peso";
        else if(imc < 25)
            classificacao = "Saudável";
        else if(imc < 30)
            classificacao = "Sobrepeso";
        else if(imc < 35)
            classificacao = "Obesidade Grau I";
        else if(imc < 40)
            classificacao = "Obesidade Grau II (severa)";
        else
            classificacao = "Obesidade Grau III (mórbida)";

        Intent it = new Intent(getBaseContext(), Relatorio.class);
        Bundle params = new Bundle();

        params.putString("nome", nome);
        params.putInt("idade", idade);
        params.putDouble("peso", peso);
        params.putDouble("altura", altura);
        params.putDouble("imc", imc);
        params.putString("classificacao", classificacao);

        it.putExtras(params);

        startActivity(it);
    }

    private void setError(String msg){
        TextView errorsText = (TextView) findViewById(R.id.errorsText);
        errorsText.setText(msg);
    }
}