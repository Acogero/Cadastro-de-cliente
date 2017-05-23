package com.tipiniquim.ica03_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tipiniquim.ica03_04.DAO.ClienteDAO;
import com.tipiniquim.ica03_04.modelo.Cliente;

public class InserirActivity extends AppCompatActivity {

    EditText nome, email, idade, endereco, cpf;
    Button cadastrar, voltar;
    private ClienteDAO dao;
    Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);
        iniciar();

        dao = new ClienteDAO(this);
        dao.abrir();
    }


    public void cadastro(View v){
        cliente.setNome(nome.getText().toString());
        cliente.setEmail(email.getText().toString());
        cliente.setIdade(Integer.parseInt(idade.getText().toString()));
        cliente.setEndereco(endereco.getText().toString());
        cliente.setCpf(Integer.parseInt(cpf.getText().toString()));

        dao.criar(cliente);
        finish();
    }

    public void voltar(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void iniciar(){
        nome = (EditText) findViewById(R.id.edtNome);
        email = (EditText) findViewById(R.id.edtEmail);
        idade = (EditText) findViewById(R.id.edtIdade);
        endereco = (EditText) findViewById(R.id.edtEnde);
        cpf = (EditText) findViewById(R.id.edtCPF);
        cadastrar = (Button)findViewById(R.id.btnCadastrar);
        voltar = (Button)findViewById(R.id.btnVoltar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dao.abrir();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dao.fechar();
    }
}
