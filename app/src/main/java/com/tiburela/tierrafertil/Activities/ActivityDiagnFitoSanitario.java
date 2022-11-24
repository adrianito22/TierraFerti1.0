package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.tiburela.tierrafertil.MyInterface;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlants0Semns;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlants7Semanas;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlantsAcosecha;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlantsJovenes;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.HashMap;

public class ActivityDiagnFitoSanitario extends AppCompatActivity implements View.OnClickListener {





    LinearLayout lay_container_datsGrales;
    TextView txtdATSgenrales;

    String keyprefrences="";
    public static String  keyprefrencesGlobaL="";


    MyInterface miintrtrfaz;

    Button btnGuardarzzz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagn_fito_sanitario);

        //OBTENEMOS EL KEY OPOIR AQUII


        btnGuardarzzz=findViewById(R.id.btnGuardarzzz);

        btnGuardarzzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //guardamos el formulario..

                saveValues();


                FragmentManager manager= getSupportFragmentManager();

                FragmtPlants7Semanas FRAGM= (FragmtPlants7Semanas) manager.findFragmentByTag("7semanas"); //para el primer fragment...
                FRAGM.saveDataCurrentPlants7Semanas();

                FragmtPlants0Semns FRAGMjd= (FragmtPlants0Semns) manager.findFragmentByTag("0semanas"); //para el primer fragment...
                FRAGMjd.saveDataCurrentPlants0Semanas();

                FragmtPlantsAcosecha FRAGMSDD= (FragmtPlantsAcosecha) manager.findFragmentByTag("acosecha"); //para el primer fragment...
                FRAGMSDD.saveDataCurrentPlantsAcosecha();


                FragmtPlantsJovenes FRAGMxx= (FragmtPlantsJovenes) manager.findFragmentByTag("Pjovenes"); //para el primer fragment...
                FRAGMxx.saveDataCurrentPlantsJovenes();



            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            keyprefrences = extras.getString(SharePref.keyIntent, "");

            keyprefrencesGlobaL=keyprefrences;
            //The key argument here must match that used in the other activity
        }




        //obtenemos prefrencias aqui hashmaps

        Utils.hasmapFitosnitario= (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(ActivityDiagnFitoSanitario.this,keyprefrences);


        if ( Utils.hasmapFitosnitario.size()>0) {
            setDtaInVIEWSGENRALES();


        }


        Log.i("slaerorfd","el size de hasmpa es " + Utils.hasmapFitosnitario.size() );


        lay_container_datsGrales=findViewById(R.id.lay_container_datsGrales);
        txtdATSgenrales=findViewById(R.id.txtdATSgenrales);

        addClicklister() ;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.txtdATSgenrales:
                  if(lay_container_datsGrales.getVisibility()==View.VISIBLE ) { //ocultamos

                      lay_container_datsGrales.setVisibility(View.GONE);
                  }else{

                      lay_container_datsGrales.setVisibility(View.VISIBLE);

                  }


                break;

/*
            case R.id.lay_container_datsGrales:
                break;

*/

        }

    }



    private void addClicklister() {
        txtdATSgenrales.setOnClickListener(this);

    }


    public void seetListern(MyInterface miintrtrfaz) {

        this.miintrtrfaz =miintrtrfaz;

    }


    private void setDtaInVIEWSGENRALES() {

        TextInputEditText ediFinca  = findViewById(R.id.ediFinca);
        TextInputEditText ediUbicacion  = findViewById(R.id.ediUbicacion);
        TextInputEditText ediProductor  = findViewById(R.id.ediProductor);
        TextInputEditText ediFecha = findViewById(R.id.ediFecha);
        TextInputEditText ediArea = findViewById(R.id.ediArea);
        TextInputEditText ediCodigo = findViewById(R.id.ediCodigo);

        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediFinca))) {

            ediFinca.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediFinca)));

        }

        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediUbicacion))) {

            ediUbicacion.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediUbicacion)));

        }



        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediProductor))) {

            ediProductor.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediProductor)));

        }


        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediFecha))) {

            ediFecha.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediFecha)));

        }



        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediArea))) {

            ediArea.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediArea)));

        }


        if( Utils.hasmapFitosnitario.containsKey(String.valueOf(R.id.ediCodigo))) {

            ediCodigo.setText(Utils.hasmapFitosnitario.get(String.valueOf(R.id.ediCodigo)));

        }


    }




    private void saveValues() {


        TextInputEditText ediFinca  = findViewById(R.id.ediFinca);
        TextInputEditText ediUbicacion  = findViewById(R.id.ediUbicacion);
        TextInputEditText ediProductor  = findViewById(R.id.ediProductor);
        TextInputEditText ediFecha = findViewById(R.id.ediFecha);
        TextInputEditText ediArea = findViewById(R.id.ediArea);
        TextInputEditText ediCodigo = findViewById(R.id.ediCodigo);

        Utils.hasmapFitosnitario.put(String.valueOf(ediFinca.getId()) ,  ediFinca.getText().toString() ) ;
        Utils.hasmapFitosnitario.put(String.valueOf(ediUbicacion.getId()) ,  ediUbicacion.getText().toString() ) ;
        Utils.hasmapFitosnitario.put(String.valueOf(ediProductor.getId()) ,  ediProductor.getText().toString() ) ;
        Utils.hasmapFitosnitario.put(String.valueOf(ediFecha.getId()) ,  ediFecha.getText().toString() ) ;
        Utils.hasmapFitosnitario.put(String.valueOf(ediArea.getId()) ,  ediArea.getText().toString() ) ;
        Utils.hasmapFitosnitario.put(String.valueOf(ediCodigo.getId()) ,  ediCodigo.getText().toString() ) ;


        SharePref.saveMapPreferFields( Utils.hasmapFitosnitario,keyprefrences);


    }

}