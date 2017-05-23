package com.tipiniquim.ica03_04.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marco on 22/05/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String BD = "cadastro_cliente";

    /* TABELA DE CLIENTES */
        public static final String TABELA_USER = "cliente";
        public static final String ID_USER = "idCliente";
        public static final String NOME_USER = "nome";
        public static final String EMAIL_USER = "email";
        public static final String IDADE_USER = "idade";
        public static final String ENDE_USER = "endereco";
        public static final String CPF_USER = "cpf";

        private static final String CREATE_TABLE_USER = TABELA_USER + " (" + ID_USER +
                " integer primary key autoincrement, " + NOME_USER + " text not null, " + EMAIL_USER +
                " text not null, " + IDADE_USER + " integer, " + ENDE_USER + " text, " + CPF_USER +
                " integer)";
    /* ######################### */

    private static final int VERSAO = 1;

    public DBHelper(Context context) {
        super(context, BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABELA_USER);

        onCreate(db);
    }
}
