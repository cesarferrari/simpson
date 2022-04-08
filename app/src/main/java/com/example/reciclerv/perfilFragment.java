package com.example.reciclerv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.net.ResponseCache;


public class perfilFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener  {
   EditText nombre,apell;
   Personajes personajes=null;
   String persona;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  if (getArguments() != null) {
           persona=getArguments().getString("user2","valor 0 ");

            Toast.makeText(getActivity(), "pe"+persona, Toast.LENGTH_SHORT).show();
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_perfil, container, false);
       nombre=vista.findViewById(R.id.txt_nombreYY);
        apell=vista.findViewById(R.id.txt_apellidoY);
        nombre.setText(persona);
        apell.setText(persona);
        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}