package com.impacta.app.brewerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class ListaProdutosActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_EXAMPLE = 0x9345;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);


        Button btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(ListaProdutosActivity.this, CadastrarProdutoActivity.class);
                startActivityForResult(it, REQUEST_CODE_EXAMPLE);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView_teste);
    }
    @Override
    public void onActivityResult(int requestCode, int resCode, Intent dt) {
        super.onActivityResult(requestCode, resCode, dt);

        if(requestCode == REQUEST_CODE_EXAMPLE) {
            if(resCode == Activity.RESULT_OK) {
                this.Lista(dt);
            }
        }
    }
    private void Lista(Intent it) {

        String nome = it.getStringExtra(CadastrarProdutoActivity.NOME_P);
        String cat = it.getStringExtra(CadastrarProdutoActivity.CATEGORIA_P);
        double val = Double.parseDouble(it.getStringExtra(CadastrarProdutoActivity.VAL_P));
        boolean fav = (it.getStringExtra(CadastrarProdutoActivity.FAV_P)).equals("true");
        //Log.e("rola" , ""+fav);
        this.criaP(nome, cat, val, fav);
    }
    private void criaP(String nome, String cat, double val, boolean fav) {
        LinearLayout l = (LinearLayout) findViewById(R.id.meuLayout);

        this.criaTxtV(l, nome);
        this.criaTxtV(l, cat);
        this.criaTxtV(l, String.valueOf(val));


        if(fav) {
            imageView.setImageResource(R.drawable.estrela);
        }

    }


    public TextView criaTxtV(LinearLayout l, String valor) {
        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        textView1.setText(valor);
        l.addView(textView1);

        return textView1;
    }

}

