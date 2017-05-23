package com.tipiniquim.ica03_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tipiniquim.ica03_04.DAO.ClienteDAO;
import com.tipiniquim.ica03_04.modelo.Cliente;

public class EditarActivity extends AppCompatActivity {

    EditText EditNome, EditEmail, EditIdade, EditEndereco, EditCPF;
    Button btnEditar, btnVoltar;

    private ClienteDAO dao;
    public static Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        iniciar();

        if(cliente != null){
            EditNome.setText(cliente.getNome());
            EditEmail.setText(cliente.getEmail());
            EditIdade.setText(Integer.toString(cliente.getIdade()));
            EditEndereco.setText(cliente.getEndereco());
            EditCPF.setText(Integer.toString(cliente.getCpf()));
        }

        dao = new ClienteDAO(this);
        dao.abrir();
    }

    public void editar(View v){
        cliente.setNome(EditNome.getText().toString());
        cliente.setEmail(EditEmail.getText().toString());
        cliente.setIdade(Integer.parseInt(EditIdade.getText().toString()));
        cliente.setEndereco(EditEndereco.getText().toString());
        cliente.setCpf(Integer.parseInt(EditCPF.getText().toString()));

        if(cliente != null){
            dao.atualizar(cliente);
            cliente = null;
        }
        finish();
    }

    public void excluir(View v){
        if(cliente != null){
            dao.excluir(cliente);
        }
        finish();
        startActivity(new Intent(this, PesquisarActivity.class));
    }

    public void voltar(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void iniciar(){
        EditNome = (EditText)findViewById(R.id.edtEditarNome);
        EditEmail = (EditText)findViewById(R.id.edtEditarEmail);
        EditIdade = (EditText)findViewById(R.id.edtEditarIdade);
        EditEndereco = (EditText)findViewById(R.id.edtEditarEnd);
        EditCPF = (EditText)findViewById(R.id.edtEditarCPF);

        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnVoltar = (Button)findViewById(R.id.btnEditarVoltar);
    }

    @Override
    protected void onResume() {
        dao.abrir();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dao.fechar();
        super.onPause();
    }
}
