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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.HashMap;
import java.util.Map;


public class DialogFragmentx extends DialogFragment {

    String keyOfThisInform="";

    Map<String, String> currentDataHhasmap = new HashMap<>();

    View vista;
    private EditText mEditTextTextPersonName20;
    private EditText mEdiEnfundeAtiempo;
    private EditText mEdiAmarreDeFunda;
    private EditText mEdiUsoDeFunda;
    private EditText mEdiIdentificacionDeEdad;
    private EditText mEdiToldeDeFunda;
    private EditText mEdiLimpiezaRacimos2;
    private EditText mEdiDaipaDisco;
    private EditText mEdiDeschive;
    private EditText mEdiCirugiaDeDedos;
    private EditText mEdiEnfundeBarrera;
    private EditText mEdiRacimosCorrectos;
    private EditText mEdiDestorex;
    private EditText mEdiDeshoje;
    private EditText mEdiCorteHojaCorrecto;
    private EditText mEdiDespunte;
    private EditText mEdiCodo;
    private EditText mEdiHojaPuente;
    private EditText mEdiSaneoYcirujia;
    private EditText mEdiDesvioDeHijos;
    private EditText mEdiEnsunche;
    private EditText mEdiRecogePuntual;
    private EditText mEdiUbicacionDeSuncho;
    private EditText mEdiUbicacionDePuntal;
    private EditText mEdiRecojeSuncho;
    private EditText mEdiDeshijeAtiempo;
    private EditText mEdiDirecccion;
    private EditText mEdiUbicacion;
    private EditText mEdiHijosDeAgua;
    private EditText mEdiDobles;
    private EditText mEdiResiembra;
    private EditText mEdiNutricion;
    private EditText mEdiManejoDeCobertura;
    private EditText mEdiLimpiezaDePlantas;
    private EditText mEdiRiego;
    private EditText mEdiDrenajes;
    private EditText mEdiLimpiezaEmpacado;
    private EditText mEdiLimpiezaBODEGA;
    private EditText mEdiManejoDeDesechos;
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
        assert bundle != null;
        keyOfThisInform= bundle.getString(Utils.keyDialogBundle,"");

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
       // mLayotItem = vista.findViewById(R.id.layotItem);
    }


    private EditText [] returnArryOfEditext(){
      EditText [] arrayEditext={
              mEditTextTextPersonName20,
              mEdiEnfundeAtiempo,     mEdiAmarreDeFunda,
              mEdiUsoDeFunda,     mEdiIdentificacionDeEdad,
              mEdiToldeDeFunda,     mEdiLimpiezaRacimos2,
              mEdiDaipaDisco,     mEdiDeschive,
              mEdiCirugiaDeDedos,     mEdiEnfundeBarrera,
              mEdiRacimosCorrectos,     mEdiDestorex,     mEdiDeshoje,     mEdiCorteHojaCorrecto,
              mEdiDespunte,     mEdiCodo,     mEdiHojaPuente,     mEdiSaneoYcirujia,     mEdiDesvioDeHijos,
              mEdiEnsunche,     mEdiRecogePuntual,     mEdiUbicacionDeSuncho,     mEdiUbicacionDePuntal,
              mEdiRecojeSuncho,     mEdiDeshijeAtiempo,     mEdiDirecccion,     mEdiUbicacion,
              mEdiHijosDeAgua,     mEdiDobles,     mEdiResiembra,     mEdiNutricion,     mEdiManejoDeCobertura,
              mEdiLimpiezaDePlantas,     mEdiRiego,     mEdiDrenajes,     mEdiLimpiezaEmpacado,
              mEdiLimpiezaBODEGA,     mEdiManejoDeDesechos,
      };



       return  arrayEditext;

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

        if(!keyOfThisInform.trim().isEmpty()) {

            currentDataHhasmap=SharePref.loadMapPreferencesDataOfFields(getActivity(),keyOfThisInform);

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

        EditText [] arrayEditext=returnArryOfEditext();
        EditText editextCurrenTdEVULETO;
        //devulve el eidtexdt que cotnien este tag

        for (Map.Entry<String, String> entry : currentDataHhasmap.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            editextCurrenTdEVULETO=Utils.returnEditextBykey(key, arrayEditext);

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
                EditText [] arrayEditex=returnArryOfEditext();


               HashMap<String ,String> hashMap= createHashMapWhitEditextArray(arrayEditex);

                if(hashMap.size()>0){
                    SharePref.init(getActivity());
                    SharePref.saveMapPreferFields(hashMap,keyOfThisInform);

                }else{

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



}

