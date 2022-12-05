package com.tiburela.tierrafertil.calendario;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.utils.Variables;

public class BottonSheetCalendarioEnf extends BottomSheetDialogFragment {
        public static final String TAG = "ActionBottomDialog";
        private View vista;
        static int idDondevinoActivity=0;
    // ImageView imgClose;

    TextInputEditText ediV1;
    TextInputEditText ediV2;
   // TextInputEditText ediV3;

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



    public static BottonSheetCalendarioEnf newInstance() {
       // idDondevinoActivity=idDondevinoActivityx;
           // formullarioSelect=tipoFormulario;
            return new BottonSheetCalendarioEnf();
        }
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            vista= inflater.inflate(R.layout.bottom_sheet_ver_atachx2, container, false);

           // imgClose=vista.findViewById(R.id.imgClose);


             ediV1=vista.findViewById(R.id.ediV1);
             ediV2=vista.findViewById(R.id.ediV2);
           //  ediV3=vista.findViewById(R.id.ediV3);

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

            setDatInVIEWS(Variables.currentCalEnfundeoBJECt);



            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

               Log.i("serte","se presiono ");

                    Drawable myIcon=ContextCompat.getDrawable(getActivity(), R.drawable.border_item);
                  //  Drawable myIcon = getResources().getDrawable( R.drawable.button );
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.BLACK);
                    myIcon.setColorFilter(filter);

                    ediSem10.setBackgroundDrawable(myIcon);
                  saveUpadateItem(Variables.currentCalEnfundeoBJECt);

                  dismiss();

                    ///
                }
            });


/*

            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //en la ac56ividad actualizamos elnume reportes vinculados y actualisamos el txt de rechzados y el iobjeto report parte 1 al;goasi


                    dismiss();


                }
            });
*/



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




        Log.i("ontatch","se ejecuto onStart");

    }









    @Override
    public void onDismiss(DialogInterface dialog)
    {
        Log.i("dbuhehjr","el user a dado en dismiss ");

   // checkActivityDondeVinoAndCaLLmETHODofActivity(idDondevinoActivity);




        super.onDismiss(dialog);

        //
//aqwuillmoasel metodo actualizarr

     //  checkActivityDondeVinoAndCaLLmETHODofActivity(idDondevinoActivity);

        // this works fine but fires one time too often for my use case, it fires on screen rotation as well, although this is a temporarily dismiss only
      ///  Toast.makeText(MainApp.get(), "DISMISSED", Toast.LENGTH_SHORT).show();
    }


private void saveUpadateItem(CalendarioEnf object){


        if (!ediV1.getText().toString().trim().isEmpty()){

            object.setVuelta1(Integer.parseInt(ediV1.getText().toString()));
        }


    if (!ediV2.getText().toString().trim().isEmpty()){

        object.setVuelta2(Integer.parseInt(ediV2.getText().toString()));
    }



    if (!ediSem9.getText().toString().trim().isEmpty()){

        object.setSem9(Integer.parseInt(ediSem9.getText().toString()));
    }


    if (!ediSem10.getText().toString().trim().isEmpty()){

        object.setSem10(Integer.parseInt(ediSem10.getText().toString()));
    }


    if (!ediSem11.getText().toString().trim().isEmpty()){

        object.setSem11(Integer.parseInt(ediSem11.getText().toString()));
    }

    if (!ediSem12.getText().toString().trim().isEmpty()){

        object.setSem12(Integer.parseInt(ediSem12.getText().toString()));
    }

    if (!ediSem13.getText().toString().trim().isEmpty()){

        object.setSem13(Integer.parseInt(ediSem13.getText().toString()));
    }



    if (!ediRacimosCortados.getText().toString().trim().isEmpty()){

        object.setRacimosCortados(Integer.parseInt(ediRacimosCortados.getText().toString()));
    }


    if (!ediRacimosRechzds.getText().toString().trim().isEmpty()){

        object.setRacimosRechazados(Integer.parseInt(ediRacimosRechzds.getText().toString()));
    }


    if (!ediTotalCajas.getText().toString().trim().isEmpty()){

        object.setTotalCajas(Integer.parseInt(ediTotalCajas.getText().toString()));
    }

    if (!ediPercentMerma.getText().toString().trim().isEmpty()){

        object.setPerctenMerma(Float.parseFloat(ediPercentMerma.getText().toString()));
    }


    if (!ediRatio.getText().toString().trim().isEmpty()){

        object.setRatio(Float.parseFloat(ediRatio.getText().toString()));
    }





    //acualiamos este objeto que editamos...

    Variables.miMap.put(Variables.currentCalEnfundeoBJECt.getUniqueId(),object);

    SharePref.saveHashMapOfHashmapWhitCalendario(Variables.miMap,SharePref.KEY_CALENDARIO_ENFUNDE);



    ///aqui gaurdamos....


}


    private void setDatInVIEWS(CalendarioEnf object){


        if (object.getVuelta1() >0){

            ediV1.setText(String.valueOf(object.getVuelta1()));

        }


        if (object.getVuelta2() >0){

            ediV2.setText(String.valueOf(object.getVuelta2()));

        }

        if (object.getSem9() >0){

            ediSem9.setText(String.valueOf(object.getSem9()));

        }

        if (object.getSem10() >0){

            ediSem10.setText(String.valueOf(object.getSem10()));

        }

        if (object.getSem11() >0){

            ediSem11.setText(String.valueOf(object.getSem11()));

        }
        if (object.getSem12() >0){

            ediSem12.setText(String.valueOf(object.getSem12()));

        }
        if (object.getSem13() >0){

            ediSem13.setText(String.valueOf(object.getSem13()));

        }


        if (object.getRacimosCortados() >0){

            ediRacimosCortados.setText(String.valueOf(object.getRacimosCortados()));

        }
        if (object.getRacimosRechazados() >0){

            ediRacimosRechzds.setText(String.valueOf(object.getRacimosRechazados()));

        }
/*
        if (!ediRacimosRechzds.getText().toString().trim().isEmpty()){

            object.setRacimosRechazados(Integer.parseInt(ediRacimosRechzds.getText().toString()));
        }
*/
        if (object.getTotalCajas() >0){

            ediTotalCajas.setText(String.valueOf(object.getTotalCajas()));

        }



        if (object.getPerctenMerma() >0){

            ediPercentMerma.setText(String.valueOf(object.getPerctenMerma()));

        }



        if (object.getRatio() >0){

            ediRatio.setText(String.valueOf(object.getRatio()));

        }


        //acualiamos este objeto que editamos...

        Variables.miMap.put(Variables.currentCalEnfundeoBJECt.getUniqueId(),object);



        ///aqui gaurdamos....


    }



    private void setColorCintasCoratdas(){



    }


}

