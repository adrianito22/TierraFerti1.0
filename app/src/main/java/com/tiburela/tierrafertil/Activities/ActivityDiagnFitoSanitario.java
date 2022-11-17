package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiburela.tierrafertil.R;

public class ActivityDiagnFitoSanitario extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lay_container_datsGrales;
    TextView txtdATSgenrales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagn_fito_sanitario);

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


}