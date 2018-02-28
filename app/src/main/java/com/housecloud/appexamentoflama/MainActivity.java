package com.housecloud.appexamentoflama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.etNumero);

    }

    public void letsGo (View view){
        int limite = 0;
        boolean valorValido = true;
        try{
            limite = Integer.parseInt(num.getText().toString());
            if(limite<=0){
                valorValido = false;
            }
        } catch (NumberFormatException e){
            valorValido = false;
        }

        if (valorValido){
            Intent i = new Intent(this, ListaPeliculasActivity.class);
            i.putExtra("Limite", limite);
            startActivity(i);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Tu! Subnormal, el 'id:' debe ser mayor que 0");
            builder.create().show();
        }

    }
}
