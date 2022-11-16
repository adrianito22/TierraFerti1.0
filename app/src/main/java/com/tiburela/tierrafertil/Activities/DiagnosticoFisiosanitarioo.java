package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.tiburela.tierrafertil.R;

import java.text.DecimalFormat;

public class DiagnosticoFisiosanitarioo extends AppCompatActivity {

    ImageView IMGcHECKoperation;

    EditText ediPLantsJovesTh1;
    EditText ediPLantsJovesTh2;
    EditText ediPLantsJovesTh3;
    EditText ediPLantsJovesTh4;
    EditText ediPLantsJovesTh5;
    EditText ediPLantsJovesTh6;
    EditText ediPLantsJovesTh7;
    EditText ediPLantsJovesTh8;
    EditText ediPLantsJovesTh9;
    EditText ediPLantsJovesTh10;

    EditText ediPLantsJovesHe1;
    EditText ediPLantsJovesHe2;
    EditText ediPLantsJovesHe3;
    EditText ediPLantsJovesHe4;
    EditText ediPLantsJovesHe5;
    EditText ediPLantsJovesHe6;
    EditText ediPLantsJovesHe7;
    EditText ediPLantsJovesHe8;
    EditText ediPLantsJovesHe9;
    EditText ediPLantsJovesHe10;


    EditText ediPLantsJovesHn1;
    EditText ediPLantsJovesHn2;
    EditText ediPLantsJovesHn3;
    EditText ediPLantsJovesHn4;
    EditText ediPLantsJovesHn5;
    EditText ediPLantsJovesHn6;
    EditText ediPLantsJovesHn7;
    EditText ediPLantsJovesHn8;
    EditText ediPLantsJovesHn9;
    EditText ediPLantsJovesHn10;


    EditText ediPLantsJovesTotal;
    EditText ediPLantsJovesHe10Total;
    EditText ediPLantsJovesTotalHn;

    EditText ediPLantsJovesPromedio;
    EditText ediPLantsJovesPromedioHe;
    EditText ediPLantsJovesPromedioHn;


    EditText arrayColumnTh [];
    EditText arrayColumnHe  [];
    EditText arrayColumnHn  [];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cruadro1);


        findviewsId();
    }


    void  findviewsId() {

        ediPLantsJovesTh1 =findViewById(R.id.ediPLantsJovesTh1);
        ediPLantsJovesTh2=findViewById(R.id.ediPLantsJovesTh2);
        ediPLantsJovesTh3=findViewById(R.id.ediPLantsJovesTh3);
        ediPLantsJovesTh4=findViewById(R.id.ediPLantsJovesTh4);
        ediPLantsJovesTh5=findViewById(R.id.ediPLantsJovesTh5);
        ediPLantsJovesTh6=findViewById(R.id.ediPLantsJovesTh6);
        ediPLantsJovesTh7=findViewById(R.id.ediPLantsJovesTh7);
        ediPLantsJovesTh8=findViewById(R.id.ediPLantsJovesTh8);
        ediPLantsJovesTh9=findViewById(R.id.ediPLantsJovesTh9);
        ediPLantsJovesTh10=findViewById(R.id.ediPLantsJovesTh10);

        ediPLantsJovesHe1=findViewById(R.id.ediPLantsJovesHe1);
        ediPLantsJovesHe2=findViewById(R.id.ediPLantsJovesHe2);
        ediPLantsJovesHe3=findViewById(R.id.ediPLantsJovesHe3);
        ediPLantsJovesHe4=findViewById(R.id.ediPLantsJovesHe4);
        ediPLantsJovesHe5=findViewById(R.id.ediPLantsJovesHe5);
        ediPLantsJovesHe6=findViewById(R.id.ediPLantsJovesHe6);
        ediPLantsJovesHe7=findViewById(R.id.ediPLantsJovesHe7);
        ediPLantsJovesHe8=findViewById(R.id.ediPLantsJovesHe8);
        ediPLantsJovesHe9=findViewById(R.id.ediPLantsJovesHe9);
        ediPLantsJovesHe10=findViewById(R.id.ediPLantsJovesHe10);


        ediPLantsJovesHn1=findViewById(R.id.ediPLantsJovesHn1);
        ediPLantsJovesHn2=findViewById(R.id.ediPLantsJovesHn2);
        ediPLantsJovesHn3=findViewById(R.id.ediPLantsJovesHn3);
        ediPLantsJovesHn4=findViewById(R.id.ediPLantsJovesHn4);
        ediPLantsJovesHn5=findViewById(R.id.ediPLantsJovesHn5);
        ediPLantsJovesHn6=findViewById(R.id.ediPLantsJovesHn6);
        ediPLantsJovesHn7=findViewById(R.id.ediPLantsJovesHn7);
        ediPLantsJovesHn8=findViewById(R.id.ediPLantsJovesHn8);
        ediPLantsJovesHn9=findViewById(R.id.ediPLantsJovesHn9);
        ediPLantsJovesHn10=findViewById(R.id.ediPLantsJovesHn10);



         ediPLantsJovesTotal=findViewById(R.id.ediPLantsJovesTotal);
         ediPLantsJovesHe10Total=findViewById(R.id.ediPLantsJovesHe10Total);
         ediPLantsJovesTotalHn=findViewById(R.id.ediPLantsJovesTotalHn);

         ediPLantsJovesPromedio=findViewById(R.id.ediPLantsJovesPromedio);
         ediPLantsJovesPromedioHe=findViewById(R.id.ediPLantsJovesPromedioHe);
         ediPLantsJovesPromedioHn=findViewById(R.id.ediPLantsJovesPromedioHn);

        IMGcHECKoperation=findViewById(R.id.IMGcHECKoperation);
        IMGcHECKoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndOperate();
            }
        });
    }



    private void initArraysEditex(){

        arrayColumnTh = new EditText[10];
        arrayColumnTh  [0]=ediPLantsJovesTh1;
        arrayColumnTh  [1]=ediPLantsJovesTh2;
        arrayColumnTh  [2]=ediPLantsJovesTh3;
        arrayColumnTh  [3]=ediPLantsJovesTh4;
        arrayColumnTh  [4]=ediPLantsJovesTh5;
        arrayColumnTh  [5]=ediPLantsJovesTh6;
        arrayColumnTh  [6]=ediPLantsJovesTh7;
        arrayColumnTh  [7]=ediPLantsJovesTh8;
        arrayColumnTh  [8]=ediPLantsJovesTh9;
        arrayColumnTh  [9]=ediPLantsJovesTh10;



        arrayColumnHe  = new EditText[10];
        arrayColumnHe  [0]=ediPLantsJovesHe1;
        arrayColumnHe  [1]=ediPLantsJovesHe2;
        arrayColumnHe  [2]=ediPLantsJovesHe3;
        arrayColumnHe  [3]=ediPLantsJovesHe4;
        arrayColumnHe  [4]=ediPLantsJovesHe5;
        arrayColumnHe  [5]=ediPLantsJovesHe6;
        arrayColumnHe  [6]=ediPLantsJovesHe7;
        arrayColumnHe  [7]=ediPLantsJovesHe8;
        arrayColumnHe  [8]=ediPLantsJovesHe9;
        arrayColumnHe  [9]=ediPLantsJovesHe10;


        arrayColumnHn = new EditText[10];
        arrayColumnHn   [0]=ediPLantsJovesHn1;
        arrayColumnHn   [1]=ediPLantsJovesHn2;
        arrayColumnHn   [2]=ediPLantsJovesHn3;
        arrayColumnHn   [3]=ediPLantsJovesHn4;
        arrayColumnHn   [4]=ediPLantsJovesHn5;
        arrayColumnHn   [5]=ediPLantsJovesHn6;
        arrayColumnHn   [6]=ediPLantsJovesHn7;
        arrayColumnHn   [7]=ediPLantsJovesHn8;
        arrayColumnHn   [8]=ediPLantsJovesHn9;
        arrayColumnHn   [9]=ediPLantsJovesHn10;


    }


    private void checkAndOperate() {
      //  float totalHojas =0;
        int   totalHe =0;
        int   totalHn =0;
        float   totalHojas =0;

        int  totaplNATASiNSPECC =0;

        initArraysEditex();
        checkeSiFALTAvALUE();


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
        ediPLantsJovesTotal.setText(String.valueOf(totalHojas));
        ediPLantsJovesHe10Total.setText(String.valueOf(totalHe));
        ediPLantsJovesTotalHn.setText(String.valueOf(totalHn));


        float promedioDecimal=totalHojas/totaplNATASiNSPECC;
        DecimalFormat df = new DecimalFormat("#,#");
        String promedio=df.format(promedioDecimal);
        ediPLantsJovesPromedio.setText(promedio);



          //promedio de HE
         promedioDecimal=totalHe/totaplNATASiNSPECC;
        promedio=df.format(promedioDecimal);
        ediPLantsJovesPromedioHe.setText(promedio);



        promedioDecimal=totalHn/totaplNATASiNSPECC;
        promedio=df.format(promedioDecimal);
        ediPLantsJovesPromedioHn.setText(promedio);


    }



    private void checkeSiFALTAvALUE(){



        //cremoasd un fro

        /***Revisamos el par valor....*/

        int contadorVacios =0;
        EditText editextCurrent =null ;


        for(int indice=0; indice<arrayColumnHn.length; indice++) {


            if(arrayColumnHn[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnHn[indice];
            }



            if(arrayColumnTh[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnHn[indice];

            }


            if(arrayColumnHe[indice].getText().toString().trim().isEmpty())  {  //si esta vacio
                contadorVacios++;
                editextCurrent=arrayColumnHn[indice];

            }

            if(contadorVacios >0 && contadorVacios<3 ) {   //contador vacios deberia ser 0
                editextCurrent.requestFocus();

                editextCurrent.setError("falta este valor");

                break;

            }




        }

    }

}