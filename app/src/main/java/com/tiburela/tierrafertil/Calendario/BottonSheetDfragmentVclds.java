package com.tiburela.tierrafertil.Calendario;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tiburela.tierrafertil.R;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BottonSheetDfragmentVclds extends BottomSheetDialogFragment {
        public static final String TAG = "ActionBottomDialog";
        private View vista;
        Context context;
        static int idDondevinoActivity=0;
    ProgressDialog      progress;

    RecyclerView mirecyclerViewAtach;
    Spinner spinnerSelectrodate;
    TextView txtAdviseer;
    TextView txtAdviserDesvicunlar;
    ImageView imgClose;
    TextView txtNumReportsVinclds;
 boolean esReportsVinculadosMod=false;



    public static BottonSheetDfragmentVclds newInstance(int idDondevinoActivityx) {
        idDondevinoActivity=idDondevinoActivityx;
           // formullarioSelect=tipoFormulario;
            return new BottonSheetDfragmentVclds();
        }
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            vista= inflater.inflate(R.layout.bottom_sheet_ver_atachx2, container, false);


            mirecyclerViewAtach =vista.findViewById(R.id.mirecyclerViewAtach);
            spinnerSelectrodate =vista.findViewById(R.id.spinnerSelectrodate);

            txtAdviseer =vista.findViewById(R.id.txtAdviseer);
            txtAdviserDesvicunlar =vista.findViewById(R.id.txtAdviserDesvicunlar);
            imgClose=vista.findViewById(R.id.imgClose);

            // context = getActivity();
            Log.i("ontatch","se ejecuto onCreateView");



            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //en la ac56ividad actualizamos elnume reportes vinculados y actualisamos el txt de rechzados y el iobjeto report parte 1 al;goasi


                    dismiss();


                }
            });




            return  vista;


        }
        @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.i("ontatch","se ejecuto onViewCreated");

            //  view.findViewById(R.id.textView4).setOnClickListener(this);
        }


        @Override
        public void onAttach(Context context) {
            super.onAttach(context);

        }

        @Override
        public void onDetach() {
            super.onDetach();


        }





/*
        public interface ItemClickListener {
            void onItemClick(boolean esNEW);
        }


*/

    @Override
    public void onStart() {
        super.onStart();


        try {
            progress.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        }




        Log.i("ontatch","se ejecuto onStart");

    }









    @Override
    public void onDismiss(DialogInterface dialog)
    {
        Log.i("dbuhehjr","el user a dado en dismiss ");

   // checkActivityDondeVinoAndCaLLmETHODofActivity(idDondevinoActivity);

        try {
            progress.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        }


        super.onDismiss(dialog);

        //
//aqwuillmoasel metodo actualizarr

     //  checkActivityDondeVinoAndCaLLmETHODofActivity(idDondevinoActivity);

        // this works fine but fires one time too often for my use case, it fires on screen rotation as well, although this is a temporarily dismiss only
      ///  Toast.makeText(MainApp.get(), "DISMISSED", Toast.LENGTH_SHORT).show();
    }






}

