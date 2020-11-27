package com.example.supervendas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class VendasActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendas);
        ed1 = findViewById(R.id.venProdutos);
        ed2 = findViewById(R.id.venPreços);
        ed3 = findViewById(R.id.venQuantidades);
        b1 =  findViewById(R.id.btnConfirmar1);
        b2 = findViewById(R.id.btnCancelar2);
    }
}