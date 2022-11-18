package com.tiburela.tierrafertil.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.models.AllFormsModel;
import com.tiburela.tierrafertil.utils.Typeinforms;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.Map;

public class MainActivityCenter extends AppCompatActivity {

    LinearLayout layCalidLabresAgriocolas;
    LinearLayout layDiagnotiscoFitosa;
    int tipoInformeSelecionado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_center);


         layCalidLabresAgriocolas=findViewById(R.id.layCalidLabresAgriocolas);
         layDiagnotiscoFitosa=findViewById(R.id.layDiagnotiscoFitosa);
        eventosBtn();

    }

    private void eventosBtn() {

        layCalidLabresAgriocolas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intencion = new Intent(MainActivityCenter.this,ActivityCalidadLaboresAgricolas.class );

                tipoInformeSelecionado=Typeinforms.CALIDAD_LABRES_AGRICOLAS;
                sheetOptionsForm(intencion,tipoInformeSelecionado);

            }
        });


        layDiagnotiscoFitosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipoInformeSelecionado=Typeinforms.INFORM_FITOSANITARIO;



                Intent intencion = new Intent(MainActivityCenter.this,ActivityDiagnFitoSanitario.class );

             sheetOptionsForm(intencion,tipoInformeSelecionado);



            }
        });

    }


    private void sheetOptionsForm(Intent intencion,int typeInform){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivityCenter.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_options);


        Button btnAddNewinform=bottomSheetDialog.findViewById(R.id.btnAddNewinform);

        Button btnVerInforms=bottomSheetDialog.findViewById(R.id.btnVerInforms);


       // ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);
      //  bottomSheetDialog.setCancelable(false);


        btnVerInforms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intencion = new Intent(MainActivityCenter.this,ActivityAllinformsCreates.class);
                 intencion.putExtra(Utils.keyIntentXtraAllinforms, typeInform);
                 startActivity(intencion);

                bottomSheetDialog.dismiss();


            }
        });



        btnAddNewinform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**aqui agregamos el tipo de informe que queremos agregar por ahorasoloagudaremos uno  INFORM_FITOSANITARIO*/

                sheetBootomInformNew(typeInform,intencion);


               //  startActivity(intencion);
                bottomSheetDialog.dismiss();


            }
        });




        bottomSheetDialog.show();

    }


    private void sheetBootomInformNew(int informType,Intent intencion){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivityCenter.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_data_inform);


        EditText ediData2=bottomSheetDialog.findViewById(R.id.ediData2);
        EditText ediData1=bottomSheetDialog.findViewById(R.id.ediData1);


        Button btnCreateInform=bottomSheetDialog.findViewById(R.id.btnCreateInform);

        //ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);
      //8  bottomSheetDialog.setCancelable(false);


        btnCreateInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nota="";

                if(ediData1.getText().toString().trim().isEmpty()  ) {
                    ediData1.requestFocus();
                    ediData1.setError("Este valor no pued estar vacio");
                     return;
                }


                if(! ediData2.getText().toString().trim().isEmpty() ) {

                    nota=ediData2.getText().toString();

                }

                 SharePref.init(MainActivityCenter.this);

                //creamos el objeto
                AllFormsModel object=new AllFormsModel(ediData1.getText().toString(),informType,nota );



                //obtebnemos el mapa
                Map<String, AllFormsModel> mapaOfPREFERENces= SharePref.loadMapPreferencesDataOfFields(SharePref.KEY_AllINFORMS_SHAREP);

                mapaOfPREFERENces.put(object.getUniqueIDkeyInformAndKeYSharePref(),object);

                SharePref.saveMapAlLINFORMS(mapaOfPREFERENces,SharePref.KEY_AllINFORMS_SHAREP);



                //empezamos intencion

                //decide a donde ir


                Toast.makeText(MainActivityCenter.this, "INFORME GUARDADO", Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();


            }
        });





        bottomSheetDialog.show();

    }


    private void decideIRActivity(int informType){
        if(informType ==Typeinforms.CALIDAD_LABRES_AGRICOLAS){

           Intent intencion = new Intent(MainActivityCenter.this,ActivityCalidadLaboresAgricolas.class);

            intencion.putExtra(Utils.KEY_INTEN_LABORES_AGROICOLAS,123);
            startActivity(intencion);

        }

        else if(informType ==Typeinforms.INFORM_FITOSANITARIO){


        }

    }

}