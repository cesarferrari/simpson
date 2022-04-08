package com.example.reciclerv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener{
   ArrayList<Personajes>ListDatos;
   private View.OnClickListener listener;
    public AdapterDatos(ArrayList<Personajes> listDatos) {
        ListDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         int layout=0;
       if(Utilidades.visualizacion==Utilidades.LIST){
              layout=R.layout.item_list;
       }else{
              layout=R.layout.item_grid;
       }


        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);
       view.setOnClickListener(this);


        return new ViewHolderDatos(view);
    }
    //evento onclick para el recyclerView
    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.nombre.setText(ListDatos.get(position).getName());
        if(Utilidades.visualizacion==Utilidades.LIST){
            holder.descripcion.setText(ListDatos.get(position).getDescription());
        }

     holder.foto.setImageResource(ListDatos.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return ListDatos.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }
// class viewHolderDatos creada
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
      TextView nombre,descripcion;
      CircleImageView foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            if(Utilidades.visualizacion==Utilidades.LIST){
                descripcion=(TextView) itemView.findViewById(R.id.txt_2);
            }
            nombre=(TextView) itemView.findViewById(R.id.txt_1);

            foto=(CircleImageView) itemView.findViewById(R.id.CIV_id);

        }

    }

}
