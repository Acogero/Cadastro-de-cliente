package com.tipiniquim.ica03_04.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.tipiniquim.ica03_04.dbhelper.DBHelper;
import com.tipiniquim.ica03_04.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 22/05/2017.
 */

public class ClienteDAO {

    private SQLiteDatabase db;
    private DBHelper helper;
    private String[] colunas = {DBHelper.ID_USER, DBHelper.NOME_USER, DBHelper.EMAIL_USER,
            DBHelper.IDADE_USER, DBHelper.ENDE_USER, DBHelper.CPF_USER};

    public ClienteDAO(Context context){
        helper = new DBHelper(context);
    }

    public void abrir() throws SQLException{
        db = helper.getWritableDatabase();
    }

    public void fechar(){
        helper.close();
    }

    public void criar(Cliente c){
        ContentValues values = new ContentValues();

        values.put(DBHelper.NOME_USER, c.getNome());
        values.put(DBHelper.EMAIL_USER, c.getEmail());
        values.put(DBHelper.IDADE_USER, c.getIdade());
        values.put(DBHelper.ENDE_USER, c.getEndereco());
        values.put(DBHelper.CPF_USER, c.getCpf());

        long insertID = db.insert(DBHelper.TABELA_USER, null, values);
        Cursor cursor = db.query(DBHelper.TABELA_USER, colunas, DBHelper.ID_USER + " = " + insertID, null, null, null, null);
        cursor.moveToFirst();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(cursor.getInt(0));
        cliente.setNome(cursor.getString(1));
        cliente.setEmail(cursor.getString(2));
        cliente.setIdade(cursor.getInt(3));
        cliente.setEndereco(cursor.getString(4));
        cliente.setCpf(cursor.getInt(5));

        cursor.close();
    }

    public Cliente atualizar(Cliente c){
        ContentValues values = new ContentValues();

        values.put(DBHelper.NOME_USER, c.getNome());
        values.put(DBHelper.EMAIL_USER, c.getEmail());
        values.put(DBHelper.IDADE_USER, c.getIdade());
        values.put(DBHelper.ENDE_USER, c.getEndereco());
        values.put(DBHelper.CPF_USER, c.getCpf());

        db.update(DBHelper.TABELA_USER, values, DBHelper.ID_USER+"=?", new String[]{"" + c.getidCliente()});

        Cursor cursor = db.query(DBHelper.TABELA_USER, colunas, DBHelper.ID_USER + " = " + c.getidCliente(), null, null, null, null);
        cursor.moveToFirst();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(cursor.getInt(0));
        cliente.setNome(cursor.getString(1));
        cliente.setEmail(cursor.getString(2));
        cliente.setIdade(cursor.getInt(3));
        cliente.setEndereco(cursor.getString(4));
        cliente.setCpf(cursor.getInt(5));

        return cliente;
    }

    public void excluir(Cliente c){
        long id = c.getidCliente();
        db.delete(DBHelper.TABELA_USER, DBHelper.ID_USER + " = " + id, null);
    }

    public int pegouID(String nome){
        Cliente c = new Cliente();
        ContentValues values = new ContentValues();
        values.put(DBHelper.NOME_USER, nome);

        try{
            Cursor cursor = db.query(DBHelper.TABELA_USER, colunas, DBHelper.NOME_USER + " like " + nome, null, null, null, null);
            cursor.moveToFirst();

            c.setIdCliente(cursor.getInt(0));
            cursor.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return c.getidCliente();
    }

    public List<Cliente> todos(){
        List<Cliente> clientes = new ArrayList<Cliente>();

        try{
            Cursor cursor = db.query(DBHelper.TABELA_USER, colunas, null, null, null, null, DBHelper.NOME_USER);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setEmail(cursor.getString(2));
                cliente.setIdade(cursor.getInt(3));
                cliente.setEndereco(cursor.getString(4));
                cliente.setCpf(cursor.getInt(5));

                clientes.add(cliente);
                cursor.moveToNext();
            }
            cursor.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> todos(int idCliente){
        List<Cliente> clientes = new ArrayList<Cliente>();

        try{
            Cursor cursor = db.query(DBHelper.TABELA_USER, colunas, DBHelper.ID_USER + "=" + idCliente, null, null, null, null);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setEmail(cursor.getString(2));
                cliente.setIdade(cursor.getInt(3));
                cliente.setEndereco(cursor.getString(4));
                cliente.setCpf(cursor.getInt(5));

                clientes.add(cliente);
                cursor.moveToNext();
            }
            cursor.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return clientes;
    }
}
