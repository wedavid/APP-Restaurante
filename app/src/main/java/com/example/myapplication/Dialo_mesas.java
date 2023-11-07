package com.example.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialo_mesas extends DialogFragment {
    private EditText etSillas;
    private Button guardar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialo_mesas, container, false);

        etSillas = view.findViewById(R.id.et_sillas);
        guardar = view.findViewById(R.id.but2_guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatosEnBaseDeDatos();
            }
        });

        return view;
    }

    private void guardarDatosEnBaseDeDatos() {
        String sillas = etSillas.getText().toString();

        if (sillas.isEmpty()) {
            Toast.makeText(requireContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            guardarRegistro(sillas);
        }
    }

    private void guardarRegistro(String sillas) {
        AdminSqlite admin = new AdminSqlite(requireContext());
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues datos = new ContentValues();
        datos.put(AdminSqlite.COLUMN_NUMERO_SILLAS, sillas);

        // Insertamos en la tabla TABLE_MESAS
        db.insert(AdminSqlite.TABLE_MESAS, null, datos);

        Toast.makeText(requireContext(), "Sillas Registradas", Toast.LENGTH_SHORT).show();
        etSillas.setText("");
    }
}
