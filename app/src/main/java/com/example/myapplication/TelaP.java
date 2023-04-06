package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaP extends AppCompatActivity {
    EditText txtNum1, txtNum2;
    Button btnVezes, btnDividir, btnMais,btnMenos, btnLogOut;
    TextView txtResul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_p);

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        btnMais = (Button) findViewById(R.id.btnMais);
        btnMenos = (Button) findViewById(R.id.bntMenos);
        btnVezes = (Button) findViewById(R.id.bntVezes);
        btnLogOut = (Button) findViewById(R.id.bntLogOut);
        btnDividir = (Button) findViewById(R.id.btntDividir);
        txtResul = (TextView) findViewById(R.id.txtResul);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                somar();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtrair();
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divisao();
            }
        });

        btnVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicacao();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
            }
        });
    }

    public void somar(){
        Double Num1 = Double.parseDouble(txtNum1.getText().toString());
        Double Num2 = Double.parseDouble(txtNum2.getText().toString());
        Double Resul = Num1+Num2;
        txtResul.setText(Resul.toString());

    }

    public void subtrair(){
        Double Num1 = Double.parseDouble(txtNum1.getText().toString());
        Double Num2 = Double.parseDouble(txtNum2.getText().toString());
        Double Resul = Num1-Num2;
        txtResul.setText(Resul.toString());
    }

    public void multiplicacao(){
        Double Num1 = Double.parseDouble(txtNum1.getText().toString());
        Double Num2 = Double.parseDouble(txtNum2.getText().toString());
        Double Resul = Num1*Num2;
        txtResul.setText(Resul.toString());
    }

    public void divisao(){
        Double Num1 = Double.parseDouble(txtNum1.getText().toString());
        Double Num2 = Double.parseDouble(txtNum2.getText().toString());
        if(Num1 == 0 || Num2 == 0){
          txtResul.setText("Erro");
        }else {
            Double Resul = Num1 / Num2;
            txtResul.setText(Resul.toString());
            }
        }

    public void LogOut(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}