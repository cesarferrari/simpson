package com.example.reciclerv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    ArrayList<Personajes> ListDatos;
    RecyclerView recyclerView;
   private Fragment frag;
   private RequestQueue queve;
  private  ProgressDialog progress;
   private String url="http://192.168.1.69/padel/jugador2.php";
    private JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag=new perfilFragment();
        queve= Volley.newRequestQueue(this);
      //  getSupportFragmentManager().beginTransaction().add(R.id.).commit();
        construirRecycler();
    }

    private void llenarPersonajes(){
        ListDatos.add(new Personajes("barny","barnygomez borracho",R.drawable.barny));
        ListDatos.add(new Personajes("milhouse","el cuatro ojos y amigo de bart ",R.drawable.milhouse));
        ListDatos.add(new Personajes("moe","provededor de chupe",R.drawable.moe));
        ListDatos.add(new Personajes("nelson","el bravucon de la escuela",R.drawable.nelson));
        ListDatos.add(new Personajes("sr.burns","rico empresario de la ciudad",R.drawable.sr_burns));
        ListDatos.add(new Personajes("tony","mafioso de la ciudad",R.drawable.tony));
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_lista:Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.btn_grid:Utilidades.visualizacion=Utilidades.GRID;
        }
        construirRecycler();
    }
    private void construirRecycler(){
         ListDatos= new ArrayList<Personajes>();
         recyclerView=(RecyclerView) findViewById(R.id.recycler_id);
        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        }
        ListDatos=new ArrayList<Personajes>();
        recyclerView=(RecyclerView) findViewById(R.id.recycler_id);

        llenarPersonajes();
        AdapterDatos adapterDatos = new AdapterDatos(ListDatos);
        recyclerView .setAdapter(adapterDatos);
        adapterDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ListDatos.get(recyclerView.getChildAdapterPosition(v)).getName()!=null){
                   Personajes person=ListDatos.get(recyclerView.getChildAdapterPosition(v));
                    Intent intent = new Intent(getApplicationContext(),MainActivity5.class);


                    Bundle budle= new Bundle();
                    budle.putSerializable("user",person);
                    intent.putExtras(budle);
                    startActivity(intent);
                }

            }
        });
    }
    public void ejecuta_servicio(){

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
