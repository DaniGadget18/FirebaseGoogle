package com.example.firebasegoogle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference reference;
    Button enviar;
    EditText cajatexto;
    RecyclerView rvfirebase;
    List<Persona> lp;
    PersonaAdaptador personadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvfirebase = findViewById(R.id.lista_persona);
        enviar = findViewById(R.id.btn_enviar);
        cajatexto = findViewById(R.id.edit_dato);

        reference = FirebaseDatabase.getInstance().getReference();
        FirebaseApp.initializeApp(this);

        rvfirebase.setLayoutManager(new LinearLayoutManager(this));

        lp = new ArrayList<>();

        personadapter = new PersonaAdaptador(lp) ;



    }
    public void enviar_datos(View view) {
        String nombre = cajatexto.getText().toString();

        String id = reference.push().getKey();

        Persona persona = new Persona(nombre);

        reference.child("Persona").child(id).setValue(persona);

        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
    }


    public void btn_mostrar(View view) {
        rvfirebase.setAdapter(personadapter);
        database.child("Persona").getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Datos",dataSnapshot.toString());
                lp.removeAll(lp);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    Persona persona = snapshot.getValue(Persona.class);
                    Toast.makeText(MainActivity.this, "Mostrando personas", Toast.LENGTH_SHORT).show();
                    lp.add(persona);
                }
                personadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
