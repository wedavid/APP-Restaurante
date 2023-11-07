package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqlite extends SQLiteOpenHelper {
    private static final String DB_NAME = "tu_base_de_datos";
    private static final int DB_VERSION = 1;

    // Tabla "usuarios"
    static final String TABLE_USUARIOS = "usuarios";
    static final String COLUMN_ID = "id";
    static final String COLUMN_NOMBRE = "nombre";
    static final String COLUMN_CEDULA = "cedula";
    static final String COLUMN_DIRECCION = "direccion";
    static final String COLUMN_TELEFONO = "telefono";
    static final String COLUMN_CORREO = "correo";
    static final String COLUMN_PASSWORD = "password";

    // Tabla "mesas"
    static final String TABLE_MESAS = "mesas";
    static final String COLUMN_MESA_ID = "mesa_id";
    static final String COLUMN_NUMERO_SILLAS = "numero_sillas";

    // Tabla "reserva"
    static final String TABLE_RESERVA = "reserva";
    static final String COLUMN_RESERVA_ID = "reserva_id";
    static final String COLUMN_USUARIO_ID = "usuario_id";
    static final String COLUMN_MESA_ID_RESERVA = "mesa_id";
    static final String COLUMN_CANTIDAD_USUARIOS = "cantidad_user";
    static final String COLUMN_HORA = "hora";
    static final String COLUMN_FECHA = "fecha";

    public AdminSqlite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabla "usuarios"
        db.execSQL("CREATE TABLE " + TABLE_USUARIOS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " VARCHAR(100) NOT NULL, " +
                COLUMN_CEDULA + " VARCHAR(100) NOT NULL, " +
                COLUMN_DIRECCION + " VARCHAR(100) NOT NULL, " +
                COLUMN_TELEFONO + " VARCHAR(100) NOT NULL, " +
                COLUMN_CORREO + " VARCHAR(100) NOT NULL, " +
                COLUMN_PASSWORD + " VARCHAR(100) NOT NULL);");

        // Tabla "mesas"
        db.execSQL("CREATE TABLE " + TABLE_MESAS + " (" +
                COLUMN_MESA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NUMERO_SILLAS + " VARCHAR(100) NOT NULL);");

        // Tabla "reserva"
        db.execSQL("CREATE TABLE " + TABLE_RESERVA + " (" +
                COLUMN_RESERVA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USUARIO_ID + " INTEGER, " +
                COLUMN_MESA_ID_RESERVA + " INTEGER, " +
                COLUMN_CANTIDAD_USUARIOS + " INTEGER, " +
                COLUMN_HORA + " TIME, " +
                COLUMN_FECHA + " TEXT, " +
                "FOREIGN KEY (" + COLUMN_USUARIO_ID + ") REFERENCES " + TABLE_USUARIOS + " (" + COLUMN_ID + "), " +
                "FOREIGN KEY (" + COLUMN_MESA_ID_RESERVA + ") REFERENCES " + TABLE_MESAS + " (" + COLUMN_MESA_ID + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes manejar actualizaciones de la base de datos si es necesario
    }
}
