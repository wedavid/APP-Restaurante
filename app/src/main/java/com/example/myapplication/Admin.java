package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    private Button btnopendialo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        btnopendialo=findViewById(R.id.btn_mesas);
        btnopendialo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialo_mesas Dialo_mesas=new Dialo_mesas();
                Dialo_mesas.show(getSupportFragmentManager(),"dialogo");

            }
        });
    }
}