package com.tipiniquim.ica03_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tipiniquim.ica03_04.DAO.ClienteDAO;
import com.tipiniquim.ica03_04.modelo.Cliente;

import java.util.List;

public class PesquisarActivity extends AppCompatActivity {

    ListView listaCliente;
    ClienteDAO dao = new ClienteDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);
        listaCliente = (ListView)findViewById(R.id.listaCliente);

        dao.abrir();
        List<Cliente> c = dao.todos();
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, c);
        listaCliente.setAdapter(adapter);
        dao.fechar();

        listaCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                abreAlteraExcluir((Cliente) parent.getItemAtPosition(position));
            }
        });
    }

    public void abreAlteraExcluir(Cliente c){
        EditarActivity.cliente = c;
        startActivity(new Intent(this, EditarActivity.class));
    }

    public void PesqCadastrar(View v){
        startActivity(new Intent(this, InserirActivity.class));
    }

    public void PesqVoltar(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onPause() {
        dao.fechar();
        super.onPause();
    }
}
