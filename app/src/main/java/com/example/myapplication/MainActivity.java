package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.init) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.reser) {
            Intent intent = new Intent(this, Reserva.class);
            startActivity(intent);
        } else if (id == R.id.consul) {
            Intent intent = new Intent(this, Consulta.class);
            startActivity(intent);
        } else if (id == R.id.admin) {
            Intent intent = new Intent(this, Admin.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
