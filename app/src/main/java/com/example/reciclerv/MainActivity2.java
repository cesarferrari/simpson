package com.example.reciclerv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText nombre,apellido,nacionalidad;
    Fragment fragment_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragment_perfil=new perfilFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,fragment_perfil).commit();
        nombre=(EditText)findViewById(R.id.txt_nombreYY);
        apellido=(EditText)findViewById(R.id.txt_apellidoY);
        nacionalidad=(EditText)findViewById(R.id.txt_nacionalidadX);
        nacionalidad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(nacionalidad.getText().toString().equalsIgnoreCase("mexicana")){
                    Toast.makeText(getApplicationContext(), "similar", Toast.LENGTH_SHORT).show();
                    nacionalidad.setText("");

                }
            }
        });
        Bundle bundle = new Bundle();

        Personajes per=null;
        Bundle bdle=getIntent().getExtras();
        if(bdle!=null){
            per=(Personajes) bdle.getSerializable("user1");
            nombre.setText(per.getName());
            apellido.setText(per.getDescription());
        }
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        bundle.putString("user2", per.getDescription().toString());
        fragment_perfil.setArguments(bundle);
    }
}