package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterPlant;
import com.tiburela.tierrafertil.dialogs.DialogFragmentx;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.models.ProductorTierraFertil;
import com.tiburela.tierrafertil.utils.Utils;
import com.tiburela.tierrafertil.utils.Variables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActivityPlantCaldLbrs extends AppCompatActivity {
  ///aquimostramos en un recilcerlos objetos plant...

     LinearLayout lay_container_datsGrales;
    TextView txtDtsGenrales;
    LinearLayout layotl1;
    LinearLayout  layotl2;

    String codigoProductor;
    TextInputEditText ediProductor;
    TextInputEditText ediFinca;
    TextInputEditText ediFecha;
    TextInputEditText ediLugar;
    TextInputEditText ediSemana;
    TextInputEditText odiCodigO;
    TextInputEditText ediFirmaTec;
    TextInputEditText ediObservacionesAll;
    TextInputEditText ediPercentAll;
     String keyextradata;

      Spinner spInnerFinca;
      Spinner spinnerUbicacion;


    RecyclerView mireciclerView;
   int tipoInformCurrent=0;
   String keySharePrefeItem="";


   Button btnSaveAndCalc;


    Map<String,Plant> mapPlants = new HashMap<>();
      ImageView btnAdnewPlant;


      ArrayList<Plant>milist= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ediFecha=findViewById(R.id.ediFecha);
        ediFecha.setKeyListener(null);

        Calendar  calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String date = dateFormat.format(calendar.getTime());
        ediFecha.setText(date);

         spInnerFinca=findViewById(R.id.spInnerFinca);
         spinnerUbicacion=findViewById(R.id.spinnerUbicacion);
        findViewsIds();

        int semanaNum= Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

        ediSemana.setText(String.valueOf(semanaNum));

        //colccamos la semana..


        ediFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selecionaFecha();

            }
        });



        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            tipoInformCurrent = extras.getInt(Utils.keyIntentXtraInformsPlant);
            keySharePrefeItem = extras.getString(SharePref.keyIntent);
            keyextradata=extras.getString(SharePref.keyIntenExtraData);

            codigoProductor=extras.getString(SharePref.keyCodigoProd,"");

            //The key argument here must match that used in the other activity
        }

        Log.i("misfinca","el key aqui es "+keySharePrefeItem);



        /**obtebnemos nuestro objeto Current**/

        try {

            if(Variables.allProductores.size()>0){
                Log.i("nosood","se ejecto el if ");
                getProductorByID(codigoProductor,Variables.allProductores);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        Utils.hasmapDataGlobal = (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(ActivityPlantCaldLbrs.this,keyextradata);
        /***si tenemos data en preferences*/

        if ( Utils.hasmapDataGlobal.size()>0) {

            Log.i("misfinca","SE EJECUTO EL if");
            setDtaInVIEWSGENRALESBySharePreferences();


        } else {


            Log.i("misfinca","SE EJECUTO EL ELSE");

            addDataGeneralInViews();  //agregamos la data...

        }

        ///obtenemos una lista con las plantas...
        //obtenemos la lista.......

       /// opbtenmos plantas que cotneienn esteid...




        txtDtsGenrales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lay_container_datsGrales.getVisibility()==View.VISIBLE) {

                    lay_container_datsGrales.setVisibility(View.GONE);

                    layotl1.setVisibility(View.GONE);
                    layotl2.setVisibility(View.GONE);

                }else{

                    lay_container_datsGrales.setVisibility(View.VISIBLE);

                    layotl1.setVisibility(View.VISIBLE);
                    layotl2.setVisibility(View.VISIBLE);
                }



            }
        });




        SharePref.init(ActivityPlantCaldLbrs.this);
        mapPlants =  SharePref.getMapOfPlantsObjects(keySharePrefeItem); /////aqui le pasmas el key del objeto all forms  que se eleciono anteriormente


        //y mostramos solo las plantas.... de este


        //agregamos la info como productor,finca ,lugar,etec...

        Map<String, String>miMapa= SharePref.loadMapPreferencesDataOfFields(ActivityPlantCaldLbrs.this,keyextradata);
        addExtradatInViews(miMapa);


        Log.i("debuggg","el size de map es "+miMapa.size());

        Log.i("debuggg","el value de inten 2 es "+keyextradata);


        if(mapPlants != null) {

            milist=Utils.arraListByHASMPA(mapPlants);

            setDataRecyclerView(milist);

            ///llamaos recicler

            Log.i("debuggg.","no es nuelo");
        }else
        {
              ///si tinee data lo ponemos en el recicler...

            Log.i("debuggg.","es nulo");


        }



        btnAdnewPlant=findViewById(R.id.btnAdnewPlant);
        btnAdnewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deploySheetaddNewPlant();



            }
        });

        btnSaveAndCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addmMoreDataOfFormAndSave();

                //mostramos el formulario de planta
                Intent intencion= new Intent(ActivityPlantCaldLbrs.this, ActivityResultCtrLabr.class);
                intencion.putExtra(Utils.keyextraGLObal,keySharePrefeItem);
                startActivity(intencion);


                //deploySheetaddNewPlant();


            }
        });



    }


    private void getProductorByID(String idSearch,ArrayList<ProductorTierraFertil>listGlobal){

        for(int index=0;index<listGlobal.size();index++){

            if(listGlobal.get(index).getCodigo().equalsIgnoreCase(idSearch)){

                Variables.currentProductorBJECt= listGlobal.get(index);
            }


        }



    }


    private void setDataRecyclerView(ArrayList<Plant>list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityPlantCaldLbrs.this);
        AdapterPlant adapter = new AdapterPlant(ActivityPlantCaldLbrs.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireciclerView.setLayoutManager(layoutManager);
        mireciclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterPlant.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {


                if(position==0){

                    Utils.esPrimerItemPlanta=true;

                }else{

                    Utils.esPrimerItemPlanta=false;


                }

             //abrimos dialog

                Log.i("elcicklerxdff","el click es llamado aqui ...");




                FragmentManager fm = getSupportFragmentManager();
                DialogFragmentx dialog = new DialogFragmentx();


                Bundle bundle = new Bundle();
                bundle.putString(Utils.keyDialogBundle,v.getTag().toString());
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(),"My  FragmentDIalog");

              //  deploySheetaddNewPlant();




            }
        });




    }


    private void deploySheetaddNewPlant(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityPlantCaldLbrs.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ver_atachx);

        CheckBox checkBox1=bottomSheetDialog.findViewById(R.id.checkBox1);
        CheckBox checkBox2=bottomSheetDialog.findViewById(R.id.checkBox2);
        CheckBox checkBox3=bottomSheetDialog.findViewById(R.id.checkBox3);
        CheckBox checkBox4=bottomSheetDialog.findViewById(R.id.checkBox4);
        CheckBox checkBox5=bottomSheetDialog.findViewById(R.id.checkBox5);

        /**MARCAMOS TODOS POR DEFECTO*/
        checkBox1.setChecked(true);
        checkBox2.setChecked(true);
        checkBox3.setChecked(true);
        checkBox4.setChecked(true);
        checkBox5.setChecked(true);



        Button btnActualizar=bottomSheetDialog.findViewById(R.id.btnActualizar);
        ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);



        bottomSheetDialog.setCancelable(false);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox [] checkBoxs={checkBox1,checkBox2,checkBox3,checkBox4,checkBox5};

             //confirguramos el nuevo objeto

                String nombrePlanta="Planta Num "+ mapPlants.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();



                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                    //agregamos un nuevo objeto



               Plant plantObject=new Plant("","",categoriresVinculadosMap,false);
                mapPlants.put(UUID.randomUUID().toString(),plantObject);
                 milist.add(plantObject);


                 //guardamos nuevo objeto planta en hasmap

                  SharePref.saveHashMapOfHashmapWhitPlatsObject(mapPlants,keySharePrefeItem);


                //lalamos recicler
                setDataRecyclerView(milist);





                bottomSheetDialog.dismiss();


            }
        });



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.dismiss();


            }
        });
        bottomSheetDialog.show();

    }



    private void createSet(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityPlantCaldLbrs.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ver_atachx);

        CheckBox checkBox1=bottomSheetDialog.findViewById(R.id.checkBox1);
        CheckBox checkBox2=bottomSheetDialog.findViewById(R.id.checkBox2);
        CheckBox checkBox3=bottomSheetDialog.findViewById(R.id.checkBox3);
        CheckBox checkBox4=bottomSheetDialog.findViewById(R.id.checkBox4);
        CheckBox checkBox5=bottomSheetDialog.findViewById(R.id.checkBox5);

        Button btnActualizar=bottomSheetDialog.findViewById(R.id.btnActualizar);
        ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);



        bottomSheetDialog.setCancelable(false);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox [] checkBoxs={checkBox1,checkBox2,checkBox3,checkBox4,checkBox5};

                //confirguramos el nuevo objeto

                String nombrePlanta="Planta Num "+ mapPlants.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();


                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                //agregamos un nuevo objeto

             //   mapPlants.add( new Plant("",nombrePlanta,categoriresVinculadosMap,false));



                //lalamos recicler
              //  setDataRecyclerView(mapPlants);


                bottomSheetDialog.dismiss();


            }
        });



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.dismiss();


            }
        });
        bottomSheetDialog.show();

    }

    void selecionaFecha(){


        final Calendar cldr = Calendar.getInstance();
        int year = cldr.get(Calendar.YEAR);
        int daySemana = cldr.get(Calendar.DAY_OF_WEEK);
        int mes = cldr.get(Calendar.MONTH);

        // time picker dialog
        DatePickerDialog picker = new DatePickerDialog(ActivityPlantCaldLbrs.this,
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


    private void addmMoreDataOfFormAndSave(){



        Utils.miMapaToSaveMoreInfoPlants.put("productor",ediProductor.getText().toString());

        if(spInnerFinca.getVisibility()==View.VISIBLE){
            Utils.miMapaToSaveMoreInfoPlants.put("finca",spInnerFinca.getSelectedItem().toString());


        }else{
            Utils.miMapaToSaveMoreInfoPlants.put("finca",ediFinca.getText().toString());


        }



        Utils.miMapaToSaveMoreInfoPlants.put("fecha",ediFecha.getText().toString());


        if(spinnerUbicacion.getVisibility()==View.VISIBLE){
            Utils.miMapaToSaveMoreInfoPlants.put("ubicacion",spinnerUbicacion.getSelectedItem().toString());


        }else{
            Utils.miMapaToSaveMoreInfoPlants.put("ubicacion",ediLugar.getText().toString());


        }

        Utils.miMapaToSaveMoreInfoPlants.put("semana",ediSemana.getText().toString());
        Utils.miMapaToSaveMoreInfoPlants.put("codigo",odiCodigO.getText().toString());
        Utils.miMapaToSaveMoreInfoPlants.put("firma",ediFirmaTec.getText().toString());
        Utils.miMapaToSaveMoreInfoPlants.put("observaciones",ediObservacionesAll.getText().toString());
        Utils.miMapaToSaveMoreInfoPlants.put("percent",ediPercentAll.getText().toString());

        Log.i("misfinca","el key aqui es "+keySharePrefeItem);


        SharePref.init(ActivityPlantCaldLbrs.this);
       SharePref.saveMapPreferFields(Utils.miMapaToSaveMoreInfoPlants,keyextradata);


        //guardamos esto en preferencias

    }


    private void addExtradatInViews(Map<String,String> mimapa){




        TextInputEditText [] miarray={ediProductor,ediFinca,ediFecha,ediLugar,ediSemana,odiCodigO,ediFirmaTec,ediObservacionesAll,ediPercentAll};

        for(TextInputEditText editext: miarray){
            if(mimapa.containsKey(editext.getTag().toString())){
                editext.setText(mimapa.get(editext.getTag().toString()));
            }
        }


    }



/**set data of current object */


private void addDataGeneralInViews(){

    /**si existe */




    if(Variables.currentProductorBJECt==null){
        Log.i("juanala","es nulo");

    }



    if(Variables.currentProductorBJECt!=null){
        Log.i("juanala","no es nulo");


        ediProductor.setText(Variables.currentProductorBJECt.getNombre());
        odiCodigO.setText(Variables.currentProductorBJECt.getCodigo());

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

          //  spinnerUbicacion.setVisibility(View.GONE);

        }
        else{
            ediLugar.setText(Variables.currentProductorBJECt.getUbicacion());
            spinnerUbicacion.setVisibility(View.GONE);


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


    private void setDtaInVIEWSGENRALESBySharePreferences() {


        if(Utils.hasmapDataGlobal.containsKey("finca")) {

            ediFinca.setText(Utils.hasmapDataGlobal.get("finca"));
            Log.i("misfinca","SE EJECUTO EL IFHERE  Y EL TEXTO ES "+Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediFinca)));
            spInnerFinca.setVisibility(View.GONE);
            Log.i("comenzart","es finca gone spinner");


        }



        if( Utils.hasmapDataGlobal.containsKey("ubicacion")) {

           Log.i("comenzart","es ubicacion gone spinner");

            ediLugar.setText(Utils.hasmapDataGlobal.get("ubicacion"));
            spinnerUbicacion.setVisibility(View.GONE);

        }


        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediProductor))) {

            ediProductor.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediProductor)));

        }



        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediFecha))) {
            ediFecha.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediFecha)));
        }



        if( Utils.hasmapDataGlobal.containsKey(String.valueOf(R.id.ediCodigo))) {

            odiCodigO.setText(Utils.hasmapDataGlobal.get(String.valueOf(R.id.ediCodigo)));

        }




    }


    void findViewsIds(){


        mireciclerView =findViewById(R.id.mirecicler);
        btnSaveAndCalc=findViewById(R.id.btnSaveAndCalc);


        lay_container_datsGrales=findViewById(R.id.lay_container_datsGrales);
        txtDtsGenrales=findViewById(R.id.txtDtsGenrales);
        layotl1=findViewById(R.id.layotl1);
        layotl2=findViewById(R.id.layotl2);

        ediProductor=findViewById(R.id.ediProductor);
        ediFinca=findViewById(R.id.ediFinca);
        ediFecha=findViewById(R.id.ediFecha);
        ediLugar=findViewById(R.id.ediLugar);
        ediSemana=findViewById(R.id.ediSemana);
        odiCodigO=findViewById(R.id.odiCodigO);
        ediFirmaTec=findViewById(R.id.ediFirmaTec);
        ediObservacionesAll=findViewById(R.id.ediObservacionesAll);
        ediPercentAll=findViewById(R.id.ediPercentAll);

    }


    /****chekear que pasa cuando el productor no es nulo porque se seleciono de otra parte*
     *mirar
     *
     * */

}