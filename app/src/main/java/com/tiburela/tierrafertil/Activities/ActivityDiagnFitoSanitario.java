package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tiburela.tierrafertil.MyInterface;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlants0Semns;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlants7Semanas;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlantsAcosecha;
import com.tiburela.tierrafertil.fragments.digntiFitoSanitario.FragmtPlantsJovenes;
import com.tiburela.tierrafertil.models.ProductorTierraFertil;
import com.tiburela.tierrafertil.utils.Utils;
import com.tiburela.tierrafertil.utils.Variables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ActivityDiagnFitoSanitario extends AppCompatActivity implements View.OnClickListener {

    LinearLayout lay_container_datsGrales;
    TextView txtdATSgenrales;


    TextInputEditText ediFinca  ;
    TextInputEditText ediUbicacion  ;
    TextInputEditText ediProductor  ;
    TextInputEditText ediFecha ;
    TextInputEditText ediArea ;
    TextInputEditText ediCodigo ;

    Spinner spinnerUbicacion ;
    Spinner spInnerFinca  ;
    Spinner spinnerArea ;


    String keyprefrences="";
    String codigoProductor="";

    public static String  keyprefrencesGlobaL="";


    MyInterface miintrtrfaz;

    Button btnGuardarzzz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagn_fito_sanitario);

        //OBTENEMOS EL KEY OPOIR AQUII



        findViewsIds();


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


                finish();

            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            keyprefrences = extras.getString(SharePref.keyIntent, "");

            keyprefrencesGlobaL=keyprefrences;
            codigoProductor=extras.getString(SharePref.keyCodigoProd,"");
            //The key argument here must match that used in the other activity

        }


        /**obtebnemos nuestro objeto Current**/
               if(Variables.currentProductorBJECt==null){
                   try {

                       if(Variables.allProductores.size()>0){
                           Log.i("nosood","se ejecto el if ");
                           getProductorByID(codigoProductor,Variables.allProductores);
                       }

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }

        //obtenemos prefrencias aqui hashmaps

        Log.i("misfinca","el prefrences key es "+keyprefrences);

        Utils.hasmapDataGlobal = (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(ActivityDiagnFitoSanitario.this,keyprefrences);
               /***si tenemos data en preferences*/

        if (Utils.hasmapDataGlobal.size()>0) {

            Log.i("misfinca","SE EJECUTO EL if");


            try {
                setDtaInVIEWSGENRALESBySharePreferences();

            } catch (Exception e) {
                e.printStackTrace();
                Log.i("misfinca","la expecion 1 es "+e.getMessage());

            }

        } else {

            try {
                addDataGeneralInViews();  //agregamos la data...

            } catch (Exception e) {
                e.printStackTrace();

                Log.i("misfinca","la expecion 2 es "+e.getMessage());


            }
            Log.i("misfinca","SE EJECUTO EL ELSE");


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


    private void findViewsIds(){


        ediFinca  = findViewById(R.id.ediFinca);
        ediUbicacion  = findViewById(R.id.ediUbicacion);
        ediProductor  = findViewById(R.id.ediProductor);
        ediFecha = findViewById(R.id.ediFecha);
        ediArea = findViewById(R.id.ediArea);
        ediCodigo = findViewById(R.id.ediCodigo);

        spinnerUbicacion  = findViewById(R.id.spinnerUbicacion);
        spInnerFinca  = findViewById(R.id.spInnerFinca);
        spinnerArea  = findViewById(R.id.spinnerArea);

        ediFecha.setKeyListener(null);


         Calendar  calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String date = dateFormat.format(calendar.getTime());
        ediFecha.setText(date);



    }


    private void setDtaInVIEWSGENRALESBySharePreferences() {


        if(Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediFinca))) {

            ediFinca.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediFinca)));
            Log.i("misfinca","SE EJECUTO EL IFHERE  Y EL TEXTO ES "+Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediFinca)));
            spInnerFinca.setVisibility(View.GONE);


        }




        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediUbicacion))) {

            ediUbicacion.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediUbicacion)));
            spinnerUbicacion.setVisibility(View.GONE);

        }


        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediProductor))) {

            ediProductor.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediProductor)));

        }



        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediFecha))) {

            ediFecha.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediFecha)));

        }



        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediArea))) {

            ediArea.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediArea)));
            spinnerArea.setVisibility(View.GONE);
        }



        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediCodigo))) {

            ediCodigo.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediCodigo)));

        }



     //   addDataGeneralInViews();  //agregamos la data...


        //

    }




    private void saveValues() {


        if(spInnerFinca.getVisibility() == View.VISIBLE){

            Utils.hasmapDataGlobal.put(String.valueOf(ediFinca.getId()) ,  spInnerFinca.getSelectedItem().toString() ) ;

        }else{
            Utils.hasmapDataGlobal.put(String.valueOf(ediFinca.getId()) ,  ediFinca.getText().toString() ) ;


        }


        if(spinnerUbicacion.getVisibility() == View.VISIBLE){

            Utils.hasmapDataGlobal.put(String.valueOf(ediUbicacion.getId()) ,  spinnerUbicacion.getSelectedItem().toString() ) ;

        }else{
            Utils.hasmapDataGlobal.put(String.valueOf(ediUbicacion.getId()) ,  ediUbicacion.getText().toString() ) ;

        }


        if(spinnerArea.getVisibility() == View.VISIBLE){

            Utils.hasmapDataGlobal.put(String.valueOf(ediArea.getId()) ,  spinnerArea.getSelectedItem().toString() ) ;

        }else{
            Utils.hasmapDataGlobal.put(String.valueOf(ediArea.getId()) ,  ediArea.getText().toString() ) ;


        }


        Utils.hasmapDataGlobal.put(String.valueOf(ediProductor.getId()) ,  ediProductor.getText().toString() ) ;
        Utils.hasmapDataGlobal.put(String.valueOf(ediFecha.getId()) ,  ediFecha.getText().toString() ) ;
        Utils.hasmapDataGlobal.put(String.valueOf(ediCodigo.getId()) ,  ediCodigo.getText().toString() ) ;

        SharePref.saveMapPreferFields( Utils.hasmapDataGlobal,keyprefrences);


    }

    private void addDataGeneralInViews(){

        /**si existe */

        if(Variables.currentProductorBJECt!=null){

            ediProductor.setText(Variables.currentProductorBJECt.getNombre());
            ediCodigo.setText(Variables.currentProductorBJECt.getCodigo());
            ArrayAdapter<String> spinnerArrayAdapter;

            /**ahora con los datos que estan separados por &&*/


            if(Variables.currentProductorBJECt.getFinca().contains("&")){

                spinnerArrayAdapter= new ArrayAdapter<String>(
                        this, android.R.layout.simple_spinner_item, createListByString(Variables.currentProductorBJECt.getFinca()));
                spInnerFinca.setAdapter(spinnerArrayAdapter);
                spInnerFinca.setVisibility(View.VISIBLE);

                TextInputLayout tiLayfinca=findViewById(R.id.tiLayfinca);
                tiLayfinca.setVisibility(View.GONE);
                Log.i("misfinca","hay un & ");

                ediFinca.setVisibility(View.GONE);


            }else{
                ediFinca.setText(Variables.currentProductorBJECt.getFinca());
                spInnerFinca.setVisibility(View.GONE);
            }




            if(Variables.currentProductorBJECt.getUbicacion().contains("&")){
                spinnerArrayAdapter= new ArrayAdapter<String>(
                        this, android.R.layout.simple_spinner_item, createListByString(Variables.currentProductorBJECt.getUbicacion()) );
                spinnerUbicacion.setAdapter(spinnerArrayAdapter);
                spinnerUbicacion.setVisibility(View.VISIBLE);
                TextInputLayout tiLayUbicacion=findViewById(R.id.tiLayUbicacion);

                tiLayUbicacion.setVisibility(View.GONE);

                 ediUbicacion.setVisibility(View.GONE);

            }
            else{
                ediUbicacion.setText(Variables.currentProductorBJECt.getUbicacion());
                spinnerUbicacion.setVisibility(View.GONE);


            }


            if(Variables.currentProductorBJECt.getArea().contains("&")){

                spinnerArrayAdapter= new ArrayAdapter<String>(
                        this, android.R.layout.simple_spinner_item, createListByString(Variables.currentProductorBJECt.getArea()) );
                spinnerArea.setAdapter(spinnerArrayAdapter);
                spinnerArea.setVisibility(View.VISIBLE);

                TextInputLayout tiLayArea=findViewById(R.id.tiLayArea);
                tiLayArea.setVisibility(View.GONE);

                ediArea.setVisibility(View.GONE);

            }

            else{

                ediArea.setText(Variables.currentProductorBJECt.getArea());
                spinnerArea.setVisibility(View.GONE);

            }


        }


    }



    private ArrayList<String>createListByString(String word){

        ArrayList<String> list = new ArrayList<>();

        String[] array=word.split("&");

        for(int indice=0; indice< array.length; indice++){

            if(!array[indice].trim().isEmpty()){
                list.add(array[indice]);

            }


        }


        return  list;
    }


    private ArrayList<String> reordenamosSpinner(String valueSearch, ArrayList<String>listItems){

        int position=0;
        for(String item: listItems){

            if(item.equalsIgnoreCase(valueSearch) && ! item.trim().isEmpty()){
                String itemx= listItems.get(position);
                listItems.remove(position);
                listItems.set(0,itemx);
                break;
            }
            position++;
        }


        return listItems;

    }



    private void getProductorByID(String idSearch,ArrayList<ProductorTierraFertil>listGlobal){

        for(int index=0;index<listGlobal.size();index++){

            if(listGlobal.get(index).getCodigo().equalsIgnoreCase(idSearch)){

                Variables.currentProductorBJECt= listGlobal.get(index);
            }


        }



    }

   public void selecionaFecha(View vista){


        final Calendar cldr = Calendar.getInstance();
        int year = cldr.get(Calendar.YEAR);
        int daySemana = cldr.get(Calendar.DAY_OF_WEEK);
        int mes = cldr.get(Calendar.MONTH);

        // time picker dialog
        DatePickerDialog picker = new DatePickerDialog(ActivityDiagnFitoSanitario.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        String dateSelec=i2+"/"+i1+"/"+i;

                        ediFecha.setText(dateSelec);

                        // ediFecha.setText(daySemana+"/"+mes+"/"+year);

                    }
                }, year,  mes, daySemana);

        picker.setButton(DialogInterface.BUTTON_POSITIVE, "OK", picker);
        picker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar", picker);


        picker.show();
    }



}