package com.example.calculadora;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
* Referências: http://4xdroid.blogspot.com/2017/07/criando-uma-calculadora-usando-o.html
* Referências: https://www.youtube.com/watch?v=jTuxCv_XjlA
* */

public class MainActivity extends Activity implements View.OnClickListener{

    private double num1, num2;

    private String sinal;

    private Button button_resultado, button_ponto, button_adicao, button_ce,
            button_subtracao, button_divisao, button_multiplicacao,
            button_zero, button_um, button_dois, button_tres,
            button_quatro, button_cinco, button_seis, button_sete, button_oito, button_nove;
    private EditText editTextVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarCalculadora();

        button_zero.setOnClickListener(this);
        button_um.setOnClickListener(this);
        button_dois.setOnClickListener(this);
        button_tres.setOnClickListener(this);
        button_quatro.setOnClickListener(this);
        button_cinco.setOnClickListener(this);
        button_seis.setOnClickListener(this);
        button_sete.setOnClickListener(this);
        button_oito.setOnClickListener(this);
        button_nove.setOnClickListener(this);
        button_resultado.setOnClickListener(this);
        button_adicao.setOnClickListener(this);
        button_ce.setOnClickListener(this);
        button_subtracao.setOnClickListener(this);
        button_divisao.setOnClickListener(this);
        button_multiplicacao.setOnClickListener(this);
        button_ponto.setOnClickListener(this);


    }

    //Inicializa todos os objetos da tela
    private void inicializarCalculadora(){
        button_resultado = (Button) findViewById(R.id.button_resultado);
        button_adicao = (Button) findViewById(R.id.button_adicao);
        button_ce = (Button) findViewById(R.id.button_ce);
        button_subtracao = (Button) findViewById(R.id.button_subtracao);
        button_divisao = (Button) findViewById(R.id.button_divisao);
        button_multiplicacao = (Button) findViewById(R.id.button_multiplicacao);
        button_ponto = (Button) findViewById(R.id.button_ponto);
        button_zero = (Button) findViewById(R.id.button_zero);
        button_um = (Button) findViewById(R.id.button_um);
        button_dois = (Button) findViewById(R.id.button_dois);
        button_tres = (Button) findViewById(R.id.button_tres);
        button_quatro = (Button) findViewById(R.id.button_quatro);
        button_cinco = (Button) findViewById(R.id.button_cinco);
        button_seis = (Button) findViewById(R.id.button_seis);
        button_sete = (Button) findViewById(R.id.button_sete);
        button_oito = (Button) findViewById(R.id.button_oito);
        button_nove = (Button) findViewById(R.id.button_nove);
        editTextVisor = findViewById(R.id.editTextVisor);
    }

    //Exibe no visor os números selecionados
    private void teclado(int num) {

        if (editTextVisor.getText().toString().trim().equals("")) {
            limparVisor();
            editTextVisor.setText(editTextVisor.getText().toString() + String.valueOf(num));
        } else {
            editTextVisor.setText(editTextVisor.getText().toString() + String.valueOf(num));
        }

    }

    //Acrescenta um "." ao valor
    private void ponto(String ponto) {
        editTextVisor.setText(editTextVisor.getText().toString() + ponto);
    }

    //Limpa o visor, e cancela a operação, iniciando uma nova
    private void limparVisor() {
        editTextVisor.setText("");
    }

    //Recebe o sinal da operação
    private void operacoes(String sinal) {

        this.sinal = sinal;

        if (sinal == "+") {
            num1 = Double.parseDouble(editTextVisor.getText().toString().trim());
            limparVisor();
        } else if (sinal == "-") {
            num1 = Double.parseDouble(editTextVisor.getText().toString().trim());
            limparVisor();
        } else if (sinal == "*") {
            num1 = Double.parseDouble(editTextVisor.getText().toString().trim());
            limparVisor();
        } else if (sinal == "/") {
            num1 = Double.parseDouble(editTextVisor.getText().toString().trim());
            limparVisor();
        }

    }

    //Efetua o calculo conforme o operador selecionado, e retorna o resultado da operação
    private void resultado() {
        if(!editTextVisor.getText().toString().trim().equals("")){

            if (sinal == "+") {
                num2 = (num1 + Double.parseDouble(editTextVisor.getText().toString().trim()));
            } else if (sinal == "-") {
                num2 = (num1 - Double.parseDouble(editTextVisor.getText().toString().trim()));
            } if (sinal == "*") {
                num2 = (num1 * Double.parseDouble(editTextVisor.getText().toString().trim()));
            } else if (sinal == "/") {
                if(num1 == 0) {
                    num2 = 0;
                } else {
                    num2 = (num1 / Double.parseDouble(editTextVisor.getText().toString().trim()));
                }
            }

        } else {
            num2 = 0;
        }

        editTextVisor.setText(String.valueOf(num2));

    }

    //Passa o valor selecionado para a sua devida classe
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_zero:
                teclado(0);
                break;

            case R.id.button_um:
                teclado(1);
                break;

            case R.id.button_dois:
                teclado(2);
                break;

            case R.id.button_tres:
                teclado(3);
                break;

            case R.id.button_quatro:
                teclado(4);
                break;

            case R.id.button_cinco:
                teclado(5);
                break;

            case R.id.button_seis:
                teclado(6);
                break;

            case R.id.button_sete:
                teclado(7);
                break;

            case R.id.button_oito:
                teclado(8);
                break;

            case R.id.button_nove:
                teclado(9);
                break;

            case R.id.button_adicao:
                operacoes("+");
                break;

            case R.id.button_subtracao:
                operacoes("-");
                break;

            case R.id.button_divisao:
                operacoes("/");
                break;

            case R.id.button_multiplicacao:
                operacoes("*");
                break;

            case R.id.button_resultado:
                resultado();
                break;

            case R.id.button_ponto:
                ponto(".");
                break;

            case R.id.button_ce:
                limparVisor();
                break;
        }
    }
}
