package com.tiburela.tierrafertil.fragments.digntiFitoSanitario;

import android.opengl.Visibility;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.utils.Utils;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmtPlantsJovenes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmtPlantsJovenes extends Fragment {

    ImageView IMGcHECKoperation;
    String intentSahrePrefrencesKey = "";

    ConstraintLayout contraintfarhter;
     TextView textPlatasjoevns;

    EditText ediTh1;
    EditText ediTh2;
    EditText ediTh3;
    EditText ediTh4;
    EditText ediTh5;
    EditText ediTh6;
    EditText ediTh7;
    EditText ediTh8;
    EditText ediTh9;
    EditText ediTh10;

    EditText ediHe1;
    EditText ediHe2;
    EditText ediHe3;
    EditText ediHe4;
    EditText ediHe5;
    EditText ediHe6;
    EditText ediHe7;
    EditText ediHe8;
    EditText ediHe9;
    EditText ediHe10;


    EditText ediHn1;
    EditText ediHn2;
    EditText ediHn3;
    EditText ediHn4;
    EditText ediHn5;
    EditText ediHn6;
    EditText ediHn7;
    EditText ediHn8;
    EditText ediHn9;
    EditText ediHn10;


    EditText ediTotal;
    EditText ediHe10Total;
    EditText ediTotalHn;

    EditText ediTotalHojas;
    EditText ediPromedioHe;
    EditText ediPromedioHn;


    EditText[] arrayColumnTh;
    EditText[] arrayColumnHe;
    EditText[] arrayColumnHn;

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public FragmtPlantsJovenes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmtPlantsJovenes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmtPlantsJovenes newInstance(String param1, String param2) {
        FragmtPlantsJovenes fragment = new FragmtPlantsJovenes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


         view = inflater.inflate(R.layout.fragment_plantas_jovens, container, false);
        findviewsId();
        initArraysEditex();

        addEVENT();
        // Inflate the layout for this fragment
        return view;
    }


    void  findviewsId() {

        contraintfarhter =view.findViewById(R.id.contraintfarhter);
        textPlatasjoevns=view.findViewById(R.id.textPlatasjoevns);


        ediTh1 =view.findViewById(R.id.ediTh1);
        ediTh2 =view.findViewById(R.id.ediTh2);

        ediTh3=view.findViewById(R.id.ediTh3);
        ediTh4=view.findViewById(R.id.ediTh4);
        ediTh5=view.findViewById(R.id.ediTh5);
        ediTh6=view.findViewById(R.id.ediTh6);
        ediTh7=view.findViewById(R.id.ediTh7);
        ediTh8=view.findViewById(R.id.ediTh8);
        ediTh9=view.findViewById(R.id.ediTh9);
        ediTh10=view.findViewById(R.id.ediTh10);

        ediHe1=view.findViewById(R.id.ediHe1);
        ediHe2=view.findViewById(R.id.ediHe2);
        ediHe3=view.findViewById(R.id.ediHe3);
        ediHe4=view.findViewById(R.id.ediHe4);
        ediHe5=view.findViewById(R.id.ediHe5);
        ediHe6=view.findViewById(R.id.ediHe6);
        ediHe7=view.findViewById(R.id.ediHe7);
        ediHe8=view.findViewById(R.id.ediHe8);
        ediHe9=view.findViewById(R.id.ediHe9);
        ediHe10=view.findViewById(R.id.ediHe10);


        ediHn1=view.findViewById(R.id.ediHn1);
        ediHn2=view.findViewById(R.id.ediHn2);
        ediHn3=view.findViewById(R.id.ediHn3);
        ediHn4=view.findViewById(R.id.ediHn4);
        ediHn5=view.findViewById(R.id.ediHn5);
        ediHn6=view.findViewById(R.id.ediHn6);
        ediHn7=view.findViewById(R.id.ediHn7);
        ediHn8=view.findViewById(R.id.ediHn8);
        ediHn9=view.findViewById(R.id.ediHn9);
        ediHn10=view.findViewById(R.id.ediHn10);



        ediTotal=view.findViewById(R.id.ediTotal);
        ediHe10Total=view.findViewById(R.id.ediHe10Total);
        ediTotalHn=view.findViewById(R.id.ediTotalHn);

        ediTotalHojas =view.findViewById(R.id.ediPromedio);
        ediPromedioHe=view.findViewById(R.id.ediPromedioHe);
        ediPromedioHn=view.findViewById(R.id.ediPromedioHn);

        IMGcHECKoperation=view.findViewById(R.id.IMGcHECKoperation);

    }



    private void initArraysEditex(){

        arrayColumnTh = new EditText[10];
        arrayColumnTh  [0]=ediTh1;
        arrayColumnTh  [1]=ediTh2;
        arrayColumnTh  [2]=ediTh3;
        arrayColumnTh  [3]=ediTh4;
        arrayColumnTh  [4]=ediTh5;
        arrayColumnTh  [5]=ediTh6;
        arrayColumnTh  [6]=ediTh7;
        arrayColumnTh  [7]=ediTh8;
        arrayColumnTh  [8]=ediTh9;
        arrayColumnTh  [9]=ediTh10;



        arrayColumnHe  = new EditText[10];
        arrayColumnHe  [0]=ediHe1;
        arrayColumnHe  [1]=ediHe2;
        arrayColumnHe  [2]=ediHe3;
        arrayColumnHe  [3]=ediHe4;
        arrayColumnHe  [4]=ediHe5;
        arrayColumnHe  [5]=ediHe6;
        arrayColumnHe  [6]=ediHe7;
        arrayColumnHe  [7]=ediHe8;
        arrayColumnHe  [8]=ediHe9;
        arrayColumnHe  [9]=ediHe10;


        arrayColumnHn = new EditText[10];
        arrayColumnHn   [0]=ediHn1;
        arrayColumnHn   [1]=ediHn2;
        arrayColumnHn   [2]=ediHn3;
        arrayColumnHn   [3]=ediHn4;
        arrayColumnHn   [4]=ediHn5;
        arrayColumnHn   [5]=ediHn6;
        arrayColumnHn   [6]=ediHn7;
        arrayColumnHn   [7]=ediHn8;
        arrayColumnHn   [8]=ediHn9;
        arrayColumnHn   [9]=ediHn10;


    }


    private void checkAndOperate() {
        //  float totalHojas =0;
        int   totalHe =0;
        int   totalHn =0;
        float   totalHojas =0;

        int  totaplNATASiNSPECC =0;

        if( checkeSiFALTASomeValueOF3aNDeXIST1lIneMinmium()){

            Log.i("isready","es ready");


            //ITREMOAS Y GUADAMOS....
            for(int indice=0; indice<arrayColumnHn.length; indice++) {

                if(!arrayColumnHn[indice].getText().toString().trim().isEmpty()
                        && !arrayColumnTh[indice].getText().toString().trim().isEmpty()
                        && !arrayColumnHe[indice].getText().toString().trim().isEmpty())  {  //si esta vacio


                    totalHn=totalHn+Integer.parseInt(arrayColumnHn[indice].getText().toString());
                    totalHojas=totalHojas+Float.parseFloat(arrayColumnTh[indice].getText().toString());
                    totalHe=totalHe+Integer.parseInt(arrayColumnHe[indice].getText().toString());

                    totaplNATASiNSPECC++;


                    ///

                }

            }

            //mostramos el total
            int enteroResult;
            DecimalFormat df = new DecimalFormat("#,#");

            if(totalHojas % 1 ==0){
                Log.i("hamemr","el total hojas es entero y es "+totalHojas);


                enteroResult=(int)totalHojas;

                //es un entero
                ediTotal.setText(String.valueOf(enteroResult));

            }else{
                Log.i("hamemr","el total es decimal  y es "+totalHojas);

                String totalHojasString=df.format(totalHojas);

                ediTotal.setText(totalHojasString);

            }


            // ediTotal.setText(String.valueOf(totalHojas));
            ediHe10Total.setText(String.valueOf(totalHe));
            ediTotalHn.setText(String.valueOf(totalHn));

            String promedio;
            float promedioDecimal;



            promedioDecimal=totalHojas/totaplNATASiNSPECC;

            //si es un entero

            if(promedioDecimal % 1 ==0){

                Log.i("dader","el value de totalHojas es entero y es "+promedioDecimal);

                enteroResult=(int)promedioDecimal;
                //es un entero
                ediTotalHojas.setText(String.valueOf(enteroResult));

            }else{
                promedio=df.format(promedioDecimal);
                ediTotalHojas.setText(promedio);

            }





            //promedio de HE
            promedioDecimal=totalHe/totaplNATASiNSPECC;


            if(promedioDecimal % 1 ==0){
                Log.i("dader","el value de totalHe es entero y es "+promedioDecimal);

                enteroResult=(int)promedioDecimal;

                //es un entero
                ediPromedioHe.setText(String.valueOf(enteroResult));

            }else{
                promedio=df.format(promedioDecimal);
                ediPromedioHe.setText(promedio);

            }


            //promedio hn
            promedioDecimal=totalHn/totaplNATASiNSPECC;

            if(promedioDecimal % 1 ==0){
                Log.i("dader","el value de totalHn es entero y es "+promedioDecimal);

                enteroResult=(int)promedioDecimal;

                //es un entero
                ediPromedioHn.setText(String.valueOf(enteroResult));

            }else{
                promedio=df.format(promedioDecimal);
                ediPromedioHn.setText(promedio);

            }



        } else{

            Log.i("isready","no es ready se ejecuto el else");

        }



    }



    private boolean checkeSiFALTASomeValueOF3aNDeXIST1lIneMinmium(){



        //cremoasd un fro

        /***Revisamos el par valor....*/

        int contadorVacios =0;
        // int contadorLlenos =0;

        boolean isReadyToContinues =false;


        EditText editextCurrent =null ;


        for(int indice=0; indice<arrayColumnHn.length; indice++) {


            if(arrayColumnHn[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnHn[indice];
            }

            if(arrayColumnTh[indice] ==null)  {  //si esta vacio

               Log.i("posicion","la posicon del objetonulo es "+indice);
                contadorVacios++;
                editextCurrent=arrayColumnTh[indice];

            }

            if(arrayColumnTh[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnTh[indice];

            }


            if(arrayColumnHe[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnHe[indice];

            }

            if(contadorVacios >0 && contadorVacios<3 ) {   //contador vacios deberia ser 0
                editextCurrent.requestFocus();

                editextCurrent.setError("falta este valor"); //si no contamos un value

                isReadyToContinues=false;

                break;

            }


            else {  //al menos que halla un set 3 completo

                int contadorCeroInEditext=0;


                if(!arrayColumnHn[indice].getText().toString().trim().isEmpty()&&
                        !arrayColumnHe[indice].getText().toString().trim().isEmpty()&&
                        !arrayColumnTh[indice].getText().toString().trim().isEmpty()){


                    if(Float.parseFloat(arrayColumnHn[indice].getText().toString()) <=0){
                        arrayColumnHn[indice].requestFocus();
                        arrayColumnHn[indice].setError("No se permiten ceros");

                        contadorCeroInEditext++;
                    }

                    if(Float.parseFloat(arrayColumnHe[indice].getText().toString()) <=0){
                        arrayColumnHe[indice].setError("No se permiten ceros");

                        contadorCeroInEditext++;

                    }

                    if(Float.parseFloat(arrayColumnTh[indice].getText().toString()) <=0){
                        arrayColumnTh[indice].setError("No se permiten ceros");

                        contadorCeroInEditext++;
                        // break;
                    }

                    //chekeamo que no sea cero

                    if(contadorCeroInEditext>=1){
                        isReadyToContinues  =false;

                        break;

                    }else{

                        isReadyToContinues  =true;


                    }


                }




            }

        }

        return    isReadyToContinues;

    }


    private boolean checkMimiumValues() {

        //aqui  chekeamo que los datos este entre lor rangos correctos, poor cejmplo hojas..
        //minimo  1 -50
        //y asi


        return true  ;

    }


private void addEVENT() {

    IMGcHECKoperation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            checkAndOperate();


        }
    });



    textPlatasjoevns.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(contraintfarhter.getVisibility()== View.VISIBLE) {

                contraintfarhter.setVisibility(View.GONE);
            }else {
                contraintfarhter.setVisibility(View.VISIBLE);

            }





        }
    });
}


    @Override
    public void onStart() {
        super.onStart();

        //chekeamos is hay un informe en prefrencias por aqui


        //si hay un informe agrtegamos ladata


        //meotodo para gregar data by hashmap
        Utils.addDataHashmapInEditext(  Utils.hasmapFitosnitario,arrayColumnHn,arrayColumnTh,arrayColumnHe,"/plJovenes");




    }



    public void saveDataCurrentPlantsAcosecha() {
        Utils.SAVEhashmapCurrentCuadro("/plJovenes", arrayColumnHn,arrayColumnTh, arrayColumnHe,intentSahrePrefrencesKey);

    }


}