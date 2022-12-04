package com.tiburela.tierrafertil.Calendario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tiburela.tierrafertil.Activities.ActivityAllinformsCreates;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.adapters.AdapterAllinforms;
import com.tiburela.tierrafertil.adapters.AdapterCalendario;
import com.tiburela.tierrafertil.models.AllFormsModel;

import java.util.ArrayList;

public class ActivityCalendario extends AppCompatActivity {

    RecyclerView mireciclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        mireciclerView=findViewById(R.id.mireciclerView);

        UtilsCalendario.indiceColors=0; //resetamos en cero el indice del claendario
        UtilsCalendario.initArrayColorsCinta();   //inicilziamos array de colores
        AdapterCalendario.listCalendario= new ArrayList<>(); //inicilizamos este array

        UtilsCalendario.generateCalendarioYear(2022,2);

        setDataRecyclerView(AdapterCalendario.listCalendario);

        //aqui ya debemos tener data en este aray list...AdapterCalendario.listCalendario






    }




    private void setDataRecyclerView(ArrayList<CalendarioEnf> list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityCalendario.this);
        AdapterCalendario adapter = new AdapterCalendario(ActivityCalendario.this, list);
        mireciclerView.setLayoutManager(layoutManager);
        mireciclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterCalendario.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                //abrimos dialog

                //aqui inicilizamos el informe...



                // String keySharePrefrencesItemClicked=v.getTag().toString();


               // sheetBootomInforOptions(v.getTag().toString());


                Log.i("elcickler","el click es llamado");




            }
        });




    }
}