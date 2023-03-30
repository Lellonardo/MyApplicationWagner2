package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public SQLiteDatabase bancoDados;
    EditText txtLogin, txtSenha;
    Button btnCadastrar, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtLogin = (EditText) findViewById(R.id.txtLogin);

        criarbancoDados();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaCadastro();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logar();
            }
        });
    }

    public void abrirTelaCadastro(){
        Intent intent = new Intent(this,TelaCadastro.class);
        startActivity(intent);
    }

    public void criarbancoDados() {
        try {
            bancoDados = openOrCreateDatabase("usuario", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS users(" +
                    "  id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", login VARCHAR" +
                    ", senha VARCHAR)");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Logar(){
       /* try{
            bancoDados = openOrCreateDatabase("usuario", MODE_PRIVATE, null);


            }
        }*/
    }
}