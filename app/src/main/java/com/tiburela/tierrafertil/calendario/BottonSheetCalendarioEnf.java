package com.tiburela.tierrafertil.calendario;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterCalendario;
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

                    saveUpadateItem(Variables.currentCalEnfundeoBJECt);

                    //setColorCintasCoratdas();


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
            setColorCintasCoratdas();


            addChangeTextListenners();


            return  vista;


        }


    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.i("ontatch","se ejecuto onViewCreated");
       // saveUpadateItem(Variables.currentCalEnfundeoBJECt);

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



    private void setColorCintasCoratdas(){//cual es el numero item atras....

        int numSemanaCurrent=Variables.currentCalEnfundeoBJECt.getSemanaNum();


        TextInputLayout txtImpLay9=vista.findViewById(R.id.txtImpLay1);
        TextInputLayout txtImpLay10=vista.findViewById(R.id.txtImpLay2);
        TextInputLayout txtImpLay11=vista.findViewById(R.id.txtImpLay3);
        TextInputLayout txtImpLay12=vista.findViewById(R.id.txtImpLay4);
        TextInputLayout txtImpLay13=vista.findViewById(R.id.txtImpLay5);


        if(numSemanaCurrent==1 ){
            Log.i("dbuhehjr","se ejecuto este");
            numSemanaCurrent=9;
           // return;

        }else if(numSemanaCurrent==2 ){

            numSemanaCurrent=10;


        }
        else if(numSemanaCurrent==3 ){

            numSemanaCurrent=11;


        }

        else if(numSemanaCurrent==4 ){

            numSemanaCurrent=12;


        }


        else if(numSemanaCurrent==5 ){

            numSemanaCurrent=13;


        }





        String color=AdapterCalendario.listCalendario.get(numSemanaCurrent-2).getColorCintaString();
        decideSlectDrawable(color,txtImpLay9);



        color=AdapterCalendario.listCalendario.get(numSemanaCurrent-3).getColorCintaString();
        decideSlectDrawable(color,txtImpLay10);


        color=AdapterCalendario.listCalendario.get(numSemanaCurrent-4).getColorCintaString();
        decideSlectDrawable(color,txtImpLay11);



        color=AdapterCalendario.listCalendario.get(numSemanaCurrent-5).getColorCintaString();
        decideSlectDrawable(color,txtImpLay12);



        color=AdapterCalendario.listCalendario.get(numSemanaCurrent-6).getColorCintaString();
        decideSlectDrawable(color,txtImpLay13);


    }

    public static void setBackground(View v, int backgroundColor, int borderColor) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { 16, 16, 16, 16, 0, 0, 0, 0 });
        shape.setColor(backgroundColor);
        shape.setStroke(3, borderColor);
        v.setBackground(shape);
    }



    private void decideSlectDrawable(String colorParse,TextInputLayout layoutx){

        if(colorParse.equals("#3F51B5")){ //azul
            layoutx.setBackgroundResource(R.drawable.border_azul);



        }



        else if(colorParse.equals("#FFFFFFFF")){ //blanco

            layoutx.setBackgroundResource(R.drawable.border_white);



        }


        else if(colorParse.equals("#FFEB3B")){ //amarillo

            layoutx.setBackgroundResource(R.drawable.border_amarillo);



        }


        else if(colorParse.equals("#673AB7")){ //lila1

            layoutx.setBackgroundResource(R.drawable.border_purpura);



        }



        else if(colorParse.equals("#D30404")){ //rojo

            layoutx.setBackgroundResource(R.drawable.border_rojo);



        }


        else if(colorParse.equals("#D3503600")){ //cafe

            layoutx.setBackgroundResource(R.drawable.border_cafe);



        }

        else if(colorParse.equals("#040404")){ //negro

            layoutx.setBackgroundResource(R.drawable.border_negro);



        }


        else if(colorParse.equals("#014C04")){ //verde

            layoutx.setBackgroundResource(R.drawable.border_verde);



        }





    }

    private void addChangeTextListenners(){

        final int[] vuelta1 = new int[1];
        final int[] vuelta2 = new int[1];


        ediV1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {



                //    if(s.length() != 0)


                //    field2.setText("");

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //testear dejando doble  espacio

                       if(ediV1.getText().toString().trim().isEmpty()){
                           vuelta1[0] =0;


                           Log.i("menudo","se eejcuto este if ");




                       }else{
                           Log.i("menudo","se eejcuto este else zz");
                           vuelta1[0] =Integer.parseInt(ediV1.getText().toString());


                       }


                updateTotalEnfunde(vuelta1[0],vuelta2[0]);

            }
        });


        ediV2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //testear dejando doble  espacio

                if(ediV2.getText().toString().trim().isEmpty()){
                    vuelta2[0] =0;


                    Log.i("menudo","se eejcuto este if ");




                }else{
                    Log.i("menudo","se eejcuto este else zz");
                    vuelta2[0] =Integer.parseInt(ediV2.getText().toString());


                }


                updateTotalEnfunde(vuelta1[0],vuelta2[0]);


            }
        });

    }


    private void updateTotalEnfunde(int vuelta1, int vuelta2){

        TextView txtTotalEnfunde=vista.findViewById(R.id.txtTotalEnfunde);

        int resultTotal = vuelta1+vuelta2;


        txtTotalEnfunde.setText(String.valueOf(resultTotal));


    }

}

