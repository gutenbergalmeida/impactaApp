package com.impacta.app.brewerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nome_senha = (EditText)findViewById(R.id.nome_senha);
        final EditText nome_usuario = (EditText)findViewById(R.id.nome_usuario);

        Button btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = nome_usuario.getText().toString();

                Toast.makeText(MainActivity.this, usuario, Toast.LENGTH_LONG).show();
                Bundle dados = new Bundle();

                dados.putString("usuario", usuario);

                Intent  it = new Intent(MainActivity.this, ListaProdutosActivity.class);
                it.putExtras(dados);

                startActivity(it);
            }
        });
    }
}
