package com.tiburela.tierrafertil.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.utils.Utils;
import com.tiburela.tierrafertil.utils.Variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DialogFragmentx extends DialogFragment {

    String keyPreferencesThisForm ="";

    Map<String, String> currentDataHhasmap = new HashMap<>();

    View vista;
    private EditText mEditTextTextPersonName20;

    TextInputEditText[] globalTexinputEditex;

    private ArrayList<Integer>milistCategoriesSelectedIndices= new ArrayList<>();


    private TextInputEditText ediProductor;
    private TextInputEditText ediFinca;
    private TextInputEditText ediFecha;
    private TextInputEditText ediLugar;
    private TextInputEditText ediSemana;
    private TextInputEditText odiCodigO;



    private TextInputEditText mEdiEnfundeAtiempo;
    private TextInputEditText mEdiAmarreDeFunda;
    private TextInputEditText mEdiUsoDeFunda;
    private TextInputEditText mEdiIdentificacionDeEdad;
    private TextInputEditText mEdiToldeDeFunda;
    private TextInputEditText  mEdiLimpiezaRacimos2;


    private  TextInputEditText mEdiDaipaDisco;
    private  TextInputEditText mEdiDeschive;
    private  TextInputEditText mEdiCirugiaDeDedos;
    private  TextInputEditText mEdiEnfundeBarrera;
    private  TextInputEditText mEdiRacimosCorrectos;
    private  TextInputEditText mEdiDestorex;
    private  TextInputEditText mEdiDeshoje;
    private  TextInputEditText mEdiCorteHojaCorrecto;
    private  TextInputEditText mEdiDespunte;
    private  TextInputEditText mEdiCodo;
    private  TextInputEditText mEdiHojaPuente;
    private  TextInputEditText mEdiSaneoYcirujia;
    private  TextInputEditText mEdiDesvioDeHijos;
    private  TextInputEditText mEdiEnsunche;
    private  TextInputEditText mEdiRecogePuntual;
    private  TextInputEditText mEdiUbicacionDeSuncho;
    private  TextInputEditText mEdiUbicacionDePuntal;
    private  TextInputEditText mEdiRecojeSuncho;
    private  TextInputEditText mEdiDeshijeAtiempo;
    private  TextInputEditText mEdiDirecccion;
    private  TextInputEditText mEdiUbicacion;
    private  TextInputEditText mEdiHijosDeAgua;
    private  TextInputEditText mEdiDobles;
    private  TextInputEditText mEdiResiembra;
    private  TextInputEditText mEdiNutricion;
    private  TextInputEditText mEdiManejoDeCobertura;
    private  TextInputEditText mEdiLimpiezaDePlantas;
    private  TextInputEditText mEdiRiego;
    private  TextInputEditText mEdiDrenajes;
    private  TextInputEditText mEdiLimpiezaEmpacado;
    private  TextInputEditText mEdiLimpiezaBODEGA;
    private  TextInputEditText mEdiManejoDeDesechos;



    private  TextInputEditText ediObservacionesDeshoje;
    private  TextInputEditText ediObservacionesApuntalamiento;
    private  TextInputEditText ediObservacionesEnfunde;
    private  TextInputEditText ediObservacionesOtrasLabores;
    private  TextInputEditText ediObservacionesDeshije;


    private TextInputEditText  ediObservacionesAll;
    private TextInputEditText  ediPercentAll;

    private TextInputEditText ediPercentEnfunde;
    private TextInputEditText ediPercentDeshoje;
    private TextInputEditText ediPercentApuntalamiento;
    private TextInputEditText ediPercentDeshije;
    private TextInputEditText ediPercentOtrasLabores;






    private Button mBtnGuardar;



     private ImageView imageviCloseDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            Bundle bundle = getArguments();


        }


    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        Bundle bundle = getArguments();


        if(bundle != null){
            keyPreferencesThisForm = bundle.getString(Utils.keyDialogBundle,"");
        }


        return crearDialogote();
    }


    private AlertDialog crearDialogote() {


        //ontextThemeWrapper ctw = new ContextThemeWrapper(getActivity(), R.style.fullscreenalert );
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.fullscreenalert);

        //  AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.fullscreenalert );//anterior asi y salia grande


        //AlertDialog.Builder builder= new AlertDialog.Builder( ctw );

        LayoutInflater inflater = getActivity().getLayoutInflater();
        vista = inflater.inflate(R.layout.layout_all_calid_labr_agrcls, null);
        builder.setView(vista);
        imageviCloseDialog=vista.findViewById(R.id.imageviCloseDialog);
        mBtnGuardar = vista.findViewById(R.id.btnGuardar);

        eventoBtns();
        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }


    public void cerrar_fragmentos() {

        dismiss();
    }


    //

    void initfindviewsIdsSomeViews() {


        ediProductor = vista.findViewById(R.id.ediProductor);
        ediFinca = vista.findViewById(R.id.ediFinca);
        ediFecha = vista.findViewById(R.id.ediFecha);
        ediLugar = vista.findViewById(R.id.ediLugar);
        ediSemana = vista.findViewById(R.id.ediSemana);
        odiCodigO = vista.findViewById(R.id.odiCodigO);






        mEdiEnfundeAtiempo = vista.findViewById(R.id.ediEnfundeAtiempo);
        mEdiAmarreDeFunda = vista.findViewById(R.id.ediAmarreDeFunda);
        mEdiUsoDeFunda = vista.findViewById(R.id.ediUsoDeFunda);
        mEdiIdentificacionDeEdad = vista.findViewById(R.id.ediIdentificacionDeEdad);
        mEdiToldeDeFunda = vista.findViewById(R.id.ediToldeDeFunda);
        mEdiLimpiezaRacimos2 = vista.findViewById(R.id.ediLimpiezaRacimos2);
        mEdiDaipaDisco = vista.findViewById(R.id.ediDaipaDisco);
        mEdiDeschive = vista.findViewById(R.id.ediDeschive);
        mEdiCirugiaDeDedos = vista.findViewById(R.id.ediCirugiaDeDedos);
        mEdiEnfundeBarrera = vista.findViewById(R.id.ediEnfundeBarrera);
        mEdiRacimosCorrectos = vista.findViewById(R.id.ediRacimosCorrectos);
        mEdiDestorex = vista.findViewById(R.id.ediDestorex);
        mEdiDeshoje = vista.findViewById(R.id.ediDeshoje);
        mEdiCorteHojaCorrecto = vista.findViewById(R.id.ediCorteHojaCorrecto);
        mEdiDespunte = vista.findViewById(R.id.ediDespunte);
        mEdiCodo = vista.findViewById(R.id.ediCodo);
        mEdiHojaPuente = vista.findViewById(R.id.ediHojaPuente);
        mEdiSaneoYcirujia = vista.findViewById(R.id.ediSaneoYcirujia);
        mEdiDesvioDeHijos = vista.findViewById(R.id.ediDesvioDeHijos);
        mEdiEnsunche = vista.findViewById(R.id.ediEnsunche);
        mEdiRecogePuntual = vista.findViewById(R.id.ediRecogePuntual);
        mEdiUbicacionDeSuncho = vista.findViewById(R.id.ediUbicacionDeSuncho);
        mEdiUbicacionDePuntal = vista.findViewById(R.id.ediUbicacionDePuntal);
        mEdiRecojeSuncho = vista.findViewById(R.id.ediRecojeSuncho);
        mEdiDeshijeAtiempo = vista.findViewById(R.id.ediDeshijeAtiempo);
        mEdiDirecccion = vista.findViewById(R.id.ediDirecccion);
        mEdiUbicacion = vista.findViewById(R.id.ediUbicacion);
        mEdiHijosDeAgua = vista.findViewById(R.id.ediHijosDeAgua);
        mEdiDobles = vista.findViewById(R.id.ediDobles);
        mEdiResiembra = vista.findViewById(R.id.ediResiembra);
        mEdiNutricion = vista.findViewById(R.id.ediNutricion);
        mEdiManejoDeCobertura = vista.findViewById(R.id.ediManejoDeCobertura);
        mEdiLimpiezaDePlantas = vista.findViewById(R.id.ediLimpiezaDePlantas);
        mEdiRiego = vista.findViewById(R.id.ediRiego);
        mEdiDrenajes = vista.findViewById(R.id.ediDrenajes);
        mEdiLimpiezaEmpacado = vista.findViewById(R.id.ediLimpiezaEmpacado);
        mEdiLimpiezaBODEGA = vista.findViewById(R.id.ediLimpiezaBODEGA);
        mEdiManejoDeDesechos = vista.findViewById(R.id.ediManejoDeDesechos);



           ediObservacionesDeshoje = vista.findViewById(R.id.ediObservacionesDeshoje);
           ediObservacionesApuntalamiento = vista.findViewById(R.id.ediObservacionesApuntalamiento);
           ediObservacionesEnfunde = vista.findViewById(R.id.ediObservacionesEnfunde);
           ediObservacionesOtrasLabores = vista.findViewById(R.id.ediObservacionesOtrasLabores);
           ediObservacionesDeshije = vista.findViewById(R.id.ediObservacionesDeshije);


        ediObservacionesAll = vista.findViewById(R.id.ediObservacionesAll);
        ediPercentAll = vista.findViewById(R.id.ediPercentAll);

          ediPercentEnfunde= vista.findViewById(R.id.ediPercentEnfunde);
          ediPercentDeshoje= vista.findViewById(R.id.ediPercentDeshoje);
          ediPercentApuntalamiento= vista.findViewById(R.id.ediPercentApuntalamiento);
          ediPercentDeshije= vista.findViewById(R.id.ediPercentDeshije);
          ediPercentOtrasLabores= vista.findViewById(R.id.ediPercentOtrasLabores);



        // mLayotItem = vista.findViewById(R.id.layotItem);
    }


    private TextInputEditText [] returnArryOfTextInputEditText(){
        TextInputEditText [] arrayTextInputEditText={

          ediProductor, ediFinca, ediFecha,
          ediLugar ,ediSemana ,odiCodigO,

        mEdiEnfundeAtiempo,     mEdiAmarreDeFunda,
              mEdiUsoDeFunda,     mEdiIdentificacionDeEdad,
              mEdiToldeDeFunda,     mEdiLimpiezaRacimos2,
              mEdiDaipaDisco,     mEdiDeschive,
              mEdiCirugiaDeDedos,     mEdiEnfundeBarrera,
              mEdiRacimosCorrectos,     mEdiDestorex,


                mEdiDeshoje,     mEdiCorteHojaCorrecto,
              mEdiDespunte,     mEdiCodo,     mEdiHojaPuente,     mEdiSaneoYcirujia,     mEdiDesvioDeHijos,
              mEdiEnsunche,     mEdiRecogePuntual,     mEdiUbicacionDeSuncho,     mEdiUbicacionDePuntal,
              mEdiRecojeSuncho,     mEdiDeshijeAtiempo,     mEdiDirecccion,     mEdiUbicacion,
              mEdiHijosDeAgua,     mEdiDobles,     mEdiResiembra,     mEdiNutricion,     mEdiManejoDeCobertura,
              mEdiLimpiezaDePlantas,     mEdiRiego,     mEdiDrenajes,     mEdiLimpiezaEmpacado,
              mEdiLimpiezaBODEGA,     mEdiManejoDeDesechos,

           ediObservacionesDeshoje, ediObservacionesApuntalamiento,
           ediObservacionesEnfunde, ediObservacionesOtrasLabores,
           ediObservacionesDeshije ,ediObservacionesAll,
           ediPercentAll


                //edi percent enfunde y lo demas no estan aun






      };



       return  arrayTextInputEditText;

    }



    private  TextInputEditText[][]  bydimensionalArrayCategoriesEditexts() {


        TextInputEditText[][] arrayTextInputEditText = {
                {        //ENFUNDE
                        ediProductor, ediFinca, ediFecha,
                        ediLugar, ediSemana, odiCodigO,

                        mEdiEnfundeAtiempo, mEdiAmarreDeFunda,
                        mEdiUsoDeFunda, mEdiIdentificacionDeEdad,
                        mEdiToldeDeFunda, mEdiLimpiezaRacimos2,
                        mEdiDaipaDisco, mEdiDeschive,
                        mEdiCirugiaDeDedos, mEdiEnfundeBarrera,
                        mEdiRacimosCorrectos, mEdiDestorex,
                        ediObservacionesEnfunde,ediPercentEnfunde
                },


                {       //DESHOJE
                        mEdiDeshoje, mEdiCorteHojaCorrecto,
                        mEdiDespunte, mEdiCodo, mEdiHojaPuente, mEdiSaneoYcirujia, mEdiDesvioDeHijos,
                        ediObservacionesDeshoje,ediPercentDeshoje

                },


                {       //APUNTALAMIENTO
                        mEdiEnsunche, mEdiRecogePuntual, mEdiUbicacionDeSuncho, mEdiUbicacionDePuntal,
                        mEdiRecojeSuncho, ediObservacionesApuntalamiento,ediPercentApuntalamiento

                },

                {    //DESHIJE
                        mEdiDeshijeAtiempo, mEdiDirecccion, mEdiUbicacion,
                        mEdiHijosDeAgua, mEdiDobles, mEdiResiembra, ediObservacionesDeshije,ediPercentDeshije
                },


                {       //OTRAS LABORES
                        mEdiNutricion, mEdiManejoDeCobertura,
                        mEdiLimpiezaDePlantas, mEdiRiego, mEdiDrenajes, mEdiLimpiezaEmpacado,
                        mEdiLimpiezaBODEGA, mEdiManejoDeDesechos, ediObservacionesOtrasLabores,ediPercentOtrasLabores
                }


        };



        return  arrayTextInputEditText;
    }





    private    HashMap<String,String> createHashMapWhitEditextArray(EditText [] miarrayEditext){

        HashMap<String,String>hasmpaDataPrefrences= new HashMap<>();



        for(EditText currentEditext: miarrayEditext){
            String value=currentEditext.getText().toString();


            if(!value.trim().isEmpty()){
                String key=currentEditext.getTag().toString();

                hasmpaDataPrefrences.put(key,value);

            }


        }




        return   hasmpaDataPrefrences;

    }

    @Override
    public void onStart() {
        super.onStart();

        getDataOfPreferencesAndCallSetDataInViews();



    }

    private void getDataOfPreferencesAndCallSetDataInViews() {

        if(!keyPreferencesThisForm.trim().isEmpty()) {

            currentDataHhasmap=SharePref.loadMapPreferencesDataOfFields(getActivity(), keyPreferencesThisForm);

            if(currentDataHhasmap.size()>0)  {


                initfindviewsIdsSomeViews();

                //inicimoas arrayOfViews..


                setdatainviewsBymapData(currentDataHhasmap);

                //iniciamos se data in views...


            }

        }
    }

    private void setdatainviewsBymapData(Map<String, String> currentDataHhasmap) {

        /***si hay problemas de memoria inicilizar el arary editex1 veces EN LA CLASE UTILS EN UNA LISTA O ARRAY*/

        TextInputEditText [] arrayTextInputEditText= returnArryOfTextInputEditText();


        TextInputEditText editextCurrenTdEVULETO;
        //devulve el eidtexdt que cotnien este tag

        for (Map.Entry<String, String> entry : currentDataHhasmap.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            editextCurrenTdEVULETO=Utils.returnEditextBykey(key, arrayTextInputEditText);

            if(editextCurrenTdEVULETO!=null){

                editextCurrenTdEVULETO.setText(value);


            }

        }



    }




    private boolean checkIAllDataCompleted(EditText [] miarrayEditext){


        for(EditText currentEditext: miarrayEditext){
            String value=currentEditext.getText().toString();


            if(value.trim().isEmpty()){
                currentEditext.requestFocus();
                currentEditext.setError("No puede estar vacio");
                //tambien llamar algun snackbar con un comentario... seria mejor.. o un bottomsheet

                  return false;

            }


        }


return true;
    }



    private void eventoBtns(){

        mBtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initfindviewsIdsSomeViews();
                EditText [] arrayEditex= returnArryOfTextInputEditText();


               HashMap<String ,String> hashMap= createHashMapWhitEditextArray(arrayEditex);

                if(hashMap.size()>0){


                    SharePref.init(getActivity());
                    SharePref.saveMapPreferFields(hashMap, keyPreferencesThisForm);
                    Toast.makeText(getActivity(), "Se guardo", Toast.LENGTH_SHORT).show();


                    dismiss();


                }


                else{

                    Toast.makeText(getActivity(), "no hay nada que guardar", Toast.LENGTH_SHORT).show();

                }


            }
        });


        imageviCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                dismiss();

                //


            }
        });





    }






  private void visibleLayoutByCategoriesSelected(String [] categoriesSelected){

      for(String currenCategory: categoriesSelected){

            if(currenCategory.equals("Enfunde")){
                LinearLayout   layoutEnfunde= vista.findViewById(R.id.layoutEnfunde);
                layoutEnfunde.setVisibility(View.VISIBLE);

                milistCategoriesSelectedIndices.add(0);

            }

          if(currenCategory.equals("Deshoje")){

              LinearLayout   layDeshoje= vista.findViewById(R.id.layDeshoje);
              layDeshoje.setVisibility(View.VISIBLE);
              milistCategoriesSelectedIndices.add(1);

          }


          if(currenCategory.equals("Apuntalamiento")){

              LinearLayout   layApuntalamiento= vista.findViewById(R.id.layApuntalamiento);
              layApuntalamiento.setVisibility(View.VISIBLE);
              milistCategoriesSelectedIndices.add(2);

          }



          if(currenCategory.equals("Deshije")){
              LinearLayout   layDeshije= vista.findViewById(R.id.layDeshije);
              layDeshije.setVisibility(View.VISIBLE);
              milistCategoriesSelectedIndices.add(3);
          }


          if(currenCategory.equals("Otras labores")){
              LinearLayout   layOtrasLabores= vista.findViewById(R.id.layOtrasLabores);
              layOtrasLabores.setVisibility(View.VISIBLE);
              milistCategoriesSelectedIndices.add(4);
          }

        }
  }



  ///vamos hacer operacion


    private void doPercenteCategorie(int categorieSelected){   ///

        if(categorieSelected== Variables.ENFUNDE){
          //Realizamos la operacion percent...

            globalTexinputEditex=bydimensionalArrayCategoriesEditexts()[0];


        }



        else if(categorieSelected== Variables.DESHOJE){

            globalTexinputEditex=bydimensionalArrayCategoriesEditexts()[1];


        }

        else if(categorieSelected== Variables.DESHIJE){


            globalTexinputEditex=bydimensionalArrayCategoriesEditexts()[3];

        }

        else if(categorieSelected== Variables.APUNTALAMIENTO){
            globalTexinputEditex=bydimensionalArrayCategoriesEditexts()[2];



        }

        else if(categorieSelected== Variables.OTRAS_LABORES){

            globalTexinputEditex=bydimensionalArrayCategoriesEditexts()[4];


        }


    else if(categorieSelected== Variables.ALL_CATEGORIES){

            TextInputEditText[] [] globalTexinputEditex=bydimensionalArrayCategoriesEditexts();


        }



        if(categorieSelected!=Variables.ALL_CATEGORIES){  //si no es llactegories

             float percentCategorie=0;

            for(int indice=0; indice<globalTexinputEditex.length; indice++){


                if(indice!=globalTexinputEditex.length-1){ //menos 2 creo..

                    if(!globalTexinputEditex[indice].getText().toString().trim().isEmpty()){

                       /// percentCategorie


                    }


                    //seguimos sumando

                }else{
                    //mostramos la operacion


                }


            }

            ///itremoas ese array

        }else{   ///si es all categories



        }





    }

}

