package com.tiburela.tierrafertil.fragments.digntiFitoSanitario;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.tiburela.tierrafertil.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmtPlantsAcosecha#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmtPlantsAcosecha extends Fragment {

    ImageView IMGcHECKoperation;

    ConstraintLayout contraintLyPlantsAcosecha;
    TextView txtPlntasAlaCosecha;



    Spinner spinnerTh1;
    Spinner spinnerTh2;
    Spinner spinnerTh3;
    Spinner spinnerTh4;
    Spinner spinnerTh5;
    Spinner spinnerTh6;
    Spinner spinnerTh7;
    Spinner spinnerTh8;
    Spinner spinnerTh9;
    Spinner spinnerTh10;

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


   // EditText ediTotal;
    EditText ediHe10Total;
    EditText ediTotalHn;

    EditText ediTotalHojas;
    EditText ediPromedioHe;
    EditText ediPromedioHn;


    Spinner[] arrayColumnThSpinners;
    EditText[] arrayColumnHe;
    EditText[] arrayColumnHn;

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public FragmtPlantsAcosecha() {
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
    public static FragmtPlantsAcosecha newInstance(String param1, String param2) {
        FragmtPlantsAcosecha fragment = new FragmtPlantsAcosecha();
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


        view = inflater.inflate(R.layout.fragment_plantas_a_cosecha, container, false);
        findviewsId();
        initArraysEditex();

        addEVENT();
        // Inflate the layout for this fragment
        return view;
    }


    void  findviewsId() {


         contraintLyPlantsAcosecha=view.findViewById(R.id.contraintLyPlantsAcosecha);
         txtPlntasAlaCosecha=view.findViewById(R.id.txtPlntasAlaCosecha);


        spinnerTh1 =view.findViewById(R.id.ediTh1);
        spinnerTh2 =view.findViewById(R.id.ediTh2);
        spinnerTh3=view.findViewById(R.id.ediTh3);
        spinnerTh4=view.findViewById(R.id.ediTh4);
        spinnerTh5=view.findViewById(R.id.ediTh5);
        spinnerTh6=view.findViewById(R.id.ediTh6);
        spinnerTh7=view.findViewById(R.id.ediTh7);
        spinnerTh8=view.findViewById(R.id.ediTh8);
        spinnerTh9=view.findViewById(R.id.ediTh9);
        spinnerTh10=view.findViewById(R.id.ediTh10);

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



       // ediTotal=view.findViewById(R.id.ediTotal);
        ediHe10Total=view.findViewById(R.id.ediHe10Total);
        ediTotalHn=view.findViewById(R.id.ediTotalHn);

      //  ediTotalHojas =view.findViewById(R.id.ediPromedio);
        ediPromedioHe=view.findViewById(R.id.ediPromedioHe);
        ediPromedioHn=view.findViewById(R.id.ediPromedioHn);

        IMGcHECKoperation=view.findViewById(R.id.IMGcHECKoperation);

    }



    private void initArraysEditex(){

        arrayColumnThSpinners = new Spinner[10];
        arrayColumnThSpinners[0]=spinnerTh1;
        arrayColumnThSpinners[1]=spinnerTh2;
        arrayColumnThSpinners[2]=spinnerTh3;
        arrayColumnThSpinners[3]=spinnerTh4;
        arrayColumnThSpinners[4]=spinnerTh5;
        arrayColumnThSpinners[5]=spinnerTh6;
        arrayColumnThSpinners[6]=spinnerTh7;
        arrayColumnThSpinners[7]=spinnerTh8;
        arrayColumnThSpinners[8]=spinnerTh9;
        arrayColumnThSpinners[9]=spinnerTh10;



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
                        && !arrayColumnHe[indice].getText().toString().trim().isEmpty())  {  //si esta vacio


                    totalHn=totalHn+Integer.parseInt(arrayColumnHn[indice].getText().toString());
                   // totalHojas=totalHojas+Float.parseFloat(arrayColumnThSpinners[indice].getText().toString());
                    totalHe=totalHe+Integer.parseInt(arrayColumnHe[indice].getText().toString());

                    totaplNATASiNSPECC++;


                    ///

                }

            }

            //mostramos el total
            int enteroResult;
            DecimalFormat df = new DecimalFormat("#,#");


            /*
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
*/

            // ediTotal.setText(String.valueOf(totalHojas));
            ediHe10Total.setText(String.valueOf(totalHe));
            ediTotalHn.setText(String.valueOf(totalHn));

            String promedio;
            float promedioDecimal;



         //   promedioDecimal=totalHojas/totaplNATASiNSPECC;

            //si es un entero
/*
            if(promedioDecimal % 1 ==0){

                Log.i("dader","el value de totalHojas es entero y es "+promedioDecimal);

                enteroResult=(int)promedioDecimal;
                //es un entero
                ediTotalHojas.setText(String.valueOf(enteroResult));

            }else{
                promedio=df.format(promedioDecimal);
                ediTotalHojas.setText(promedio);

            }
*/




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

        int contadorVaciosView =0;
        int contadorNoSelectSpinners=0;
        // int contadorLlenos =0;

        boolean isReadyToContinues =false;


        EditText editextCurrent =null ;
        Spinner spinnerCurrent =null ;


        for(int indice=0; indice<arrayColumnHn.length; indice++) {


            if(arrayColumnHn[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVaciosView++;
                editextCurrent=arrayColumnHn[indice];
            }



            if(arrayColumnThSpinners[indice].getSelectedItem().toString().equalsIgnoreCase("No"))  {  //si esta vacio
                contadorVaciosView++;
                contadorNoSelectSpinners++;
            }


            if(arrayColumnHe[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVaciosView++;
                editextCurrent=arrayColumnHe[indice];

            }

            if(contadorVaciosView >0 && contadorVaciosView<3 ) {   //contador vacios deberia ser 0

               if(contadorNoSelectSpinners>0){ //significa que falta un s

                   Toast.makeText(getActivity(), "Selecion un color de cinta", Toast.LENGTH_LONG).show();
               }else{
                   editextCurrent.requestFocus();

                   editextCurrent.setError("falta este valor"); //si no contamos un value

                   isReadyToContinues=false;

                   break;

               }


            }


            else {  //al menos que halla un set 3 completo

                int contadorCeroInEditext=0;


                if(!arrayColumnHn[indice].getText().toString().trim().isEmpty()&&
                        !arrayColumnHe[indice].getText().toString().trim().isEmpty()&&
                        !arrayColumnThSpinners[indice].getSelectedItem().toString().equalsIgnoreCase("No")){


                    if(Float.parseFloat(arrayColumnHn[indice].getText().toString()) <=0){
                        arrayColumnHn[indice].requestFocus();
                        arrayColumnHn[indice].setError("No se permiten ceros");

                        contadorCeroInEditext++;
                    }

                    if(Float.parseFloat(arrayColumnHe[indice].getText().toString()) <=0){
                        arrayColumnHe[indice].setError("No se permiten ceros");

                        contadorCeroInEditext++;

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


        txtPlntasAlaCosecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(contraintLyPlantsAcosecha.getVisibility() ==View.VISIBLE) {
                    contraintLyPlantsAcosecha.setVisibility(View.GONE);

                }else {
                    contraintLyPlantsAcosecha.setVisibility(View.VISIBLE);


                }


            }
        });

    }

}