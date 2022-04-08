package com.example.reciclerv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity5 extends AppCompatActivity {
    Personajes persona=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Bundle bundle =getIntent().getExtras();
        Personajes persona=null;
        if(bundle!=null){
            persona=(Personajes)  bundle.getSerializable("user");
            Toast.makeText(getApplicationContext(), ""+
                    persona.getDescription()+persona.getName(), Toast.LENGTH_SHORT).show();

        }
        Bundle bun= new Bundle();

        bun.putSerializable("user1",persona);

        TimerTask timer= new TimerTask(){

            @Override
            public void run() {
                Intent in =new Intent(MainActivity5.this,MainActivity2.class);

              in.putExtras(bun);
                startActivity(in);
                finish();
            }
        };
        Timer tiempo= new Timer();
        tiempo.schedule(timer,3000);
    }

}