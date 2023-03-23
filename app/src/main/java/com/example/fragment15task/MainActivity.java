package com.example.fragment15task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//CREAR JAVA CLASS PARA SI Y EMI Y LUEGO GENERAR BUTTONS EN MAINACTIVITY- semidone
//EN CADA CLASE CREAR LOS EDIT TEXT PARA LUEGO TOMARLOS AL CREAR EL OBJETO Y CALCULAR - semidone
//AGREGAR SWITCH AL CLICKEAR EN BOTON PARA QUE CAMBIE DE PESTAÑA - not yet
public class MainActivity extends AppCompatActivity {

    Button buttonShowSIPage, buttonShowEMIPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShowSIPage=findViewById(R.id.buttonShowSIPage);
        buttonShowEMIPage=findViewById(R.id.buttonShowEMIPage);

        buttonShowSIPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //replace existing fragment in fragment container with SIFrag
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                //animations provided
                transaction.setCustomAnimations(R.anim.slide_in,R.anim.fade_in,
                        R.anim.fade_out,R.anim.slide_out);

                transaction.replace(R.id.fragmentContainer, new SIFrag());
                transaction.commit();
            }
        });

        buttonShowEMIPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //replace existing fragment in fragment container with EMIFrag
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                //animations provided
                transaction.setCustomAnimations(R.anim.slide_in,R.anim.fade_in,
                        R.anim.fade_out,R.anim.slide_out);

                transaction.replace(R.id.fragmentContainer, new EMIFrag());
                transaction.commit();
            }
        });


    }



}










