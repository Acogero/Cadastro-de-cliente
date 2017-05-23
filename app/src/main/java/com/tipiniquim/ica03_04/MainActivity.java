package com.tipiniquim.ica03_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserir(View v){
        startActivity(new Intent(this, InserirActivity.class));
    }

    public void pesquisar(View v){
        startActivity(new Intent(this, PesquisarActivity.class));
    }

    public void atualizar(View v){
        startActivity(new Intent(this, EditarActivity.class));
    }

    public void deletar(View v){
        startActivity(new Intent(this, InserirActivity.class));
    }
}
