package com.tiburela.tierrafertil.Calendario;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.tiburela.tierrafertil.R;

public class BottonSheetDfragmentVclds extends BottomSheetDialogFragment {
        public static final String TAG = "ActionBottomDialog";
        private View vista;
        Context context;
        static int idDondevinoActivity=0;
    ProgressDialog      progress;
    ImageView imgClose;

    TextInputEditText ediV1;
    TextInputEditText ediV2;
    TextInputEditText ediV3;

    TextInputEditText ediSem9;
    TextInputEditText ediSem10;
    TextInputEditText ediSem11;
    TextInputEditText ediSem12;
    TextInputEditText ediSem13;

    TextInputEditText ediRacimosCortados;
    TextInputEditText ediRacimosRechzds;
    TextInputEditText ediTotalCajas;
    TextInputEditText ediPercentMerma;
    TextInputEditText ediRatio;
    Button btnSave;



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

            imgClose=vista.findViewById(R.id.imgClose);


             ediV1=vista.findViewById(R.id.ediV1);
             ediV2=vista.findViewById(R.id.ediV2);
             ediV3=vista.findViewById(R.id.ediV3);

             ediSem9=vista.findViewById(R.id.ediSem9);
             ediSem10=vista.findViewById(R.id.ediSem10);
             ediSem11=vista.findViewById(R.id.ediSem11);
             ediSem12=vista.findViewById(R.id.ediSem12);
             ediSem13=vista.findViewById(R.id.ediSem13);

             ediRacimosCortados=vista.findViewById(R.id.ediRacimosCortados);
             ediRacimosRechzds=vista.findViewById(R.id.ediRacimosRechzds);
             ediTotalCajas=vista.findViewById(R.id.ediTotalCajas);
             ediPercentMerma=vista.findViewById(R.id.ediPercentMerma);
             ediRatio=vista.findViewById(R.id.ediRatio);
            btnSave=vista.findViewById(R.id.btnSave);


            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ///
                }
            });




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

