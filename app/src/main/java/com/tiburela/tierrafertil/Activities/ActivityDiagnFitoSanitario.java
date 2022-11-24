package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiburela.tierrafertil.MyInterface;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlants7Semanas;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.HashMap;

public class ActivityDiagnFitoSanitario extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lay_container_datsGrales;
    TextView txtdATSgenrales;

    String keyprefrences="";

    MyInterface miintrtrfaz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagn_fito_sanitario);

        //OBTENEMOS EL KEY OPOIR AQUII


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            keyprefrences = extras.getString(SharePref.keyIntent, "");
            //The key argument here must match that used in the other activity
        }




        //obtenemos prefrencias aqui

        Utils.hasmapFitosnitario= (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(ActivityDiagnFitoSanitario.this,keyprefrences);


        if(Utils.hasmapFitosnitario.size()>0) {
            // FragmtPlants7Semanas fragment = new FragmtPlants7Semanas();
            // ((FragmtPlants7Semanas).fragment().
            //&& llamaos a los metodos del fragmts

            FragmentManager manager= getSupportFragmentManager();
            FragmtPlants7Semanas FRAGM= (FragmtPlants7Semanas) manager.findFragmentByTag("7semanas");

            FRAGM.saveDataCurrentPlants7Semanas();

            //FragmtPlants7Semanas frgamnet=(FragmtPlants7Semanas) getFragmentManager().findFragmentByTag("");

        }


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

}