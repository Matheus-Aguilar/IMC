package android.teste.matheusaguilar.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickRelatorioButton(View view){

        EditText nomeText = (EditText) findViewById(R.id.nomeInput);
        EditText idadeText = (EditText) findViewById(R.id.idadeInput);
        EditText pesoText = (EditText) findViewById(R.id.pesoInput);
        EditText alturaText = (EditText) findViewById(R.id.alturaInput);

        String nome, classificacao;
        int idade;
        double peso, altura, imc;

        /*Impedindo que o formulario possa ser submetido com valores vazios*/
        if(nomeText.getText().toString().equals("")) return;
        if(idadeText.getText().toString().equals("")) return;
        if(pesoText.getText().toString().equals("")) return;
        if(alturaText.getText().toString().equals("")) return;

        nome = nomeText.getText().toString();
        idade = Integer.parseInt(idadeText.getText().toString());
        peso = Double.parseDouble(pesoText.getText().toString());
        altura = Double.parseDouble(alturaText.getText().toString());
        imc = peso/(altura * altura);

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
}