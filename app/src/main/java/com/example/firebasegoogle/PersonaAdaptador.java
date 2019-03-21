package com.example.firebasegoogle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.viewHolder> {
    ArrayList<Persona> lp;

    public PersonaAdaptador(List<Persona> lp) {
        this.lp = (ArrayList<Persona>) lp;
    }

    @NonNull
    @Override
    public PersonaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.desingpersonas, viewGroup,false);
        viewHolder holder = new viewHolder(v);
        Log.d("holder",holder.toString());
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.viewHolder viewHolder, int i) {
        Persona persona = lp.get(i);
        viewHolder.nombre.setText(persona.getNombre());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class viewHolder extends RecyclerView.ViewHolder
    {
        TextView nombre;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
        }
    }
}
