package com.example.firebasegoogle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


        database = FirebaseDatabase.getInstance();



    }
    public void enviar_datos(View view) {
        reference = database.getReference(cajatexto.getText().toString());
    }
}
