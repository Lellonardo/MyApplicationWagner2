package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class TelaCadastro extends AppCompatActivity {
    EditText txtConfirmaSenha, txtSenha, txtLogin2;
    Button btnCadastrar;
    SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        txtLogin2 = (EditText) findViewById(R.id.txtLogin2);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtConfirmaSenha = (EditText) findViewById(R.id.txtConfirmaSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar2);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
                abrirTelaLogin();
            }
        });
    }

    public void cadastrar(){
        if(!TextUtils.isEmpty(txtLogin2.getText().toString())){
            try{
                bancoDados = openOrCreateDatabase("usuario", MODE_PRIVATE, null);
                String sql = "INSERT INTO users (login,senha) VALUES (?,?)";
                SQLiteStatement stmt = bancoDados.compileStatement(sql);
                stmt.bindString(1,txtLogin2.getText().toString());
                stmt.bindString(2,txtSenha.getText().toString());

                if(txtSenha.getText().toString().equals(txtConfirmaSenha.getText().toString())) {
                    stmt.executeInsert();
                    bancoDados.close();
                    finish();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void abrirTelaLogin(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        }
    }