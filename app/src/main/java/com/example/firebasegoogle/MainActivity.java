package com.example.firebasegoogle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    Button enviar;
    EditText cajatexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.btn_enviar);
        cajatexto = findViewById(R.id.edit_dato);

        reference = FirebaseDatabase.getInstance().getReference();
        FirebaseApp.initializeApp(this);



    }
    public void enviar_datos(View view) {
        String nombre = cajatexto.getText().toString();

        String id = reference.push().getKey();

        Persona persona = new Persona(nombre);

        reference.child("Persona").child(id).setValue(persona);

        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
    }
}
