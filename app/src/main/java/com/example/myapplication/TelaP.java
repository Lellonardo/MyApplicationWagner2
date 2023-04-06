package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaP extends AppCompatActivity {
    EditText txtNum1, txtNum2;
    Button btnVezes, btnDividir, btnMais,btnMenos;
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

    }

    public void somar(){
        Integer Num1 = Integer.parseInt(txtNum1.getText().toString());
        Integer Num2 = Integer.parseInt(txtNum2.getText().toString());
        Integer Resul = Num1+Num2;
        txtResul.setText(Resul.toString());

    }

    public void subtrair(){
        Integer Num1 = Integer.parseInt(txtNum1.getText().toString());
        Integer Num2 = Integer.parseInt(txtNum2.getText().toString());
        Integer Resul = Num1-Num2;
        txtResul.setText(Resul.toString());
    }

    public void multiplicacao(){
        Integer Num1 = Integer.parseInt(txtNum1.getText().toString());
        Integer Num2 = Integer.parseInt(txtNum2.getText().toString());
        Integer Resul = Num1*Num2;
        txtResul.setText(Resul.toString());
    }

    public void divisao(){
        Integer Num1 = Integer.parseInt(txtNum1.getText().toString());
        Integer Num2 = Integer.parseInt(txtNum2.getText().toString());
        if(Num1 == 0 || Num2 == 0){
          txtResul.setText("Erro");
        }else {
            Integer Resul = Num1 / Num2;
            txtResul.setText(Resul.toString());
            }
        }
}