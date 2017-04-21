package com.impacta.app.brewerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.impacta.app.brewerapp.R.id.favorito;

public class CadastrarProdutoActivity extends AppCompatActivity {
    EditText nomeP, categoriaP, valP;
    CheckBox favP;

    public static final String NOME_P = "NOME_P";
    public static final String CATEGORIA_P= "CATEGORIA_P";
    public static final String VAL_P = "VAL_P";
    public static final String FAV_P = "FAV_P";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        final EditText nomeProduto= (EditText)findViewById(R.id.nomeProduto);
        final EditText valorProduto = (EditText)findViewById(R.id.valorProduto);
        final EditText categoriaProduto = (EditText)findViewById(R.id.categoriaProduto);
        final CheckBox favorito = (CheckBox)findViewById(R.id.favorito);

        Button btn_salvar = (Button) findViewById(R.id.btn_salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String nome_produto      = nomeProduto.getText().toString();
                String valor_produto     = valorProduto.getText().toString();
                String categoria_produto = categoriaProduto.getText().toString();
                String fav               = favorito.isChecked() ? "true" : "false";

                final Intent it = new Intent();
                it.putExtra(NOME_P, nome_produto);
                it.putExtra(CATEGORIA_P, categoria_produto);
                it.putExtra(VAL_P, valor_produto);
                it.putExtra(FAV_P, fav);

                setResult(Activity.RESULT_OK, it);
                finish();


            }
        });





    }
}
