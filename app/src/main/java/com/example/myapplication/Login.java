package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText usuario, clave;
    private Button login,registro;
    private AdminSqlite adminSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario = findViewById(R.id.log_user);
        clave = findViewById(R.id.log_pass);
        login = findViewById(R.id.btn_login);
        registro = findViewById(R.id.log_crear);
        adminSqlite = new AdminSqlite(this);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de registro
                Intent intent = new Intent(Login.this, Registro_Login.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = clave.getText().toString();

                if (user.isEmpty()) {
                    usuario.setError("Usuario Vacio");
                    usuario.requestFocus();
                } else if (pass.isEmpty()) {
                    clave.setError("Contraseña Vacía");
                    clave.requestFocus();
                }else {
                    // verificación en la base de datos
                    if (verificarUsuario(user, pass)) {
                        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                        // Iniciar la actividad MainActivity
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Cerrar la actividad de inicio de sesión
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean verificarUsuario(String usuario, String contraseña) {
        SQLiteDatabase db = adminSqlite.getReadableDatabase();
        String[] projection = {AdminSqlite.COLUMN_PASSWORD};
        String selection = AdminSqlite.COLUMN_CORREO + " = ? AND " + AdminSqlite.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {usuario, contraseña};
        Cursor cursor = db.query(
                AdminSqlite.TABLE_USUARIOS,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
}