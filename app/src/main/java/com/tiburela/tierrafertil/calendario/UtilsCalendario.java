package com.tiburela.tierrafertil.calendario;

import android.util.Log;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.adapters.AdapterCalendario;
import com.tiburela.tierrafertil.calendario.CalendarioEnf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UtilsCalendario {
static Calendar calendar = Calendar.getInstance();


    public static int[] colorsArray;
    public static int indiceColors=0;
    public static final int NUMS_CINTAS=8;

    public static String [] coloresCintasArray={
            "#673AB7", "#D30404","#D3503600","#040404","#014C04","#3F51B5","#FFFFFFFF","#FFEB3B",
    };


    public static ArrayList<String>list= new ArrayList<>();





    public static void initArrayColorsCinta() {


     colorsArray = new int[8];

        colorsArray[0] = R.color.purupra;
        colorsArray[1] = R.color.rojo;
        colorsArray[2] = R.color.cafe;
        colorsArray[3] = R.color.negro;
        colorsArray[4] = R.color.verde;
                colorsArray[5] = R.color.lila;
                colorsArray[6] = R.color.blanco;
                colorsArray[7] = R.color.amarillo;



    }


    public static  void generateCalendarioYear(int year, int diaEneroDondeEmpezamos){ //por defecto sera del ano donde nos encontramos......,,pero tambien podria generar del proximo...
/*
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year,12,31);
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY); // week beginn from Monday
        gregorianCalendar.setMinimalDaysInFirstWeek(4); // 1week mininum from Thursday
        int totalWeeks2 = gregorianCalendar.getMaximum(Calendar.WEEK_OF_YEAR);

        Log.i("samas","la semana n here es  "+totalWeeks2);
*/

        int totalWeeks = getTotalWeeksInYear(year); //por alguna razon no quiere funciona
        SimpleDateFormat formatDiaEnd = new SimpleDateFormat("dd");

        int weeksOfYear = Calendar.getInstance().getActualMaximum(Calendar.WEEK_OF_YEAR);

          Log.i("samas","la semana n here es  "+weeksOfYear);
        Log.i("samas","el total wekends es   "+totalWeeks);


        int currentMonth ;
        int currentDay;
        int diaEnd;

         /**CONFIGURAMOS EL CALENDARIO*/
         calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, diaEneroDondeEmpezamos);



        for(int indice=0; indice<weeksOfYear; indice++){  //estab en menos 1
            Log.i("samas","seejecuto el for ");


            //  calendar.add(Calendar.DATE, 0);

             currentMonth = calendar.get(Calendar.MONTH) + 1;
             currentDay = calendar.get(Calendar.DAY_OF_MONTH);


            calendar.add(Calendar.DATE, +7); //AIUMENTAMOS LA FECHA DEL CALENDARIO


         diaEnd= Integer.parseInt(formatDiaEnd.format(calendar.getTimeInMillis()))-1;


            createObjecAndAddList(currentDay,diaEnd,currentMonth,indice+1,indice);

          }






    }



    private static void createObjecAndAddList(int diaStart,int diaEnd,int numMes,int semanaNum,int contadorIteracion){

    // int  currentColorCinta=col;
        Log.i("samas","se llamo createObjecAndAddList ");


        if(contadorIteracion % NUMS_CINTAS ==0  ){ //cada 8 veces aumentamos uno
            //contado itreacion es 1 y nums
            indiceColors=0;

           // currentColorCinta=colors[indiceColors];
            Log.i("numsgenerados","SI "+contadorIteracion+" ES MULTIPLO DE "+NUMS_CINTAS);


        }else{
            Log.i("numsgenerados","NO "+contadorIteracion+" ES MULTIPLO DE "+NUMS_CINTAS);
            indiceColors++;


        }



        String dateRange="";
         String mesCurrentString="";
         String diastartString;
        String diaEndString;

        String mes;

         switch(numMes){
             case 1:
                 mesCurrentString="ENER";
             break;
             case 2:
                 mesCurrentString="FEB";
                 break;
             case 3:
                 mesCurrentString="MAR";
                 break;

             case 4:
                 mesCurrentString="ABR";
                 break;

             case 5:
                 mesCurrentString="MAY";
                 break;

             case 6:
                 mesCurrentString="JUN";
                 break;

             case 7:
                 mesCurrentString="JUL";
                 break;


             case 8:
                 mesCurrentString="AGO";
                 break;

             case 9:
                 mesCurrentString="SEP";
                 break;
             case 10:
                 mesCurrentString="OCT";
                 break;

             case 11:
                 mesCurrentString="NOV";
                 break;


             case 12:
                 mesCurrentString="DIC";
                 break;





        }



        if(diaStart<=9){

            diastartString="0"+diaStart;
           // dateRange="0";
        }else{

            diastartString=""+diaStart;

        }



        if(diaEnd<=9){

            diaEndString="0"+diaEnd;
            // dateRange="0";
        }else{

            diaEndString=""+diaEnd;

        }


        dateRange=diastartString+"-"+diaEndString+" "+mesCurrentString;
     //   Log.i("numsgenerados","date es "+dateRange);

        Log.i("numsgenerados","el color cinta now es  "+ colorsArray[indiceColors]);

        AdapterCalendario.listCalendario.add(new CalendarioEnf(semanaNum, colorsArray[indiceColors],dateRange,coloresCintasArray[indiceColors]));


        Log.i("numsgenerados","date es "+dateRange);

    }



    private static int getTotalWeeksInYear(int year) {
        Calendar mCalendar = new GregorianCalendar();
        mCalendar.set(Calendar.YEAR, year); // Set only year
        mCalendar.set(Calendar.MONTH, Calendar.DECEMBER); // Don't change
        mCalendar.set(Calendar.DAY_OF_MONTH, 31); // Don't change
        return mCalendar.get(Calendar.WEEK_OF_YEAR);
    }




    public static  void creaetAndOrdenaListColors(int indiceColorUserStart){

        /**  "#3F51B5","#FFFFFFFF","#FFEB3B","#673AB7",
         "#D30404","#D3503600","#040404","#014C04"*/

        Log.i("miscolorX","el USER DEICIDIOO EMPEZAR POR : "+indiceColorUserStart);


        for(int indice=indiceColorUserStart; indice<colorsArray.length; indice++){
                list.add(coloresCintasArray[indice]);

                Log.i("miscolorX","el color es "+coloresCintasArray[indice]);
                //asi ponemos los primeros
            }




        //los elementos desde la poscion 0 hasta donde user seleciono
        for(int indice=0; indice<indiceColorUserStart; indice++){
            Log.i("miscolorX","el color es "+coloresCintasArray[indice]);

            list.add(coloresCintasArray[indice]);
            //asi ponemos los primeros
        }





/*
        list.add( "#3F51B5");
        list.add( "#FFFFFFFF");
        list.add( "#FFEB3B");
        list.add( "#673AB7");
        list.add( "#D30404");
        list.add( "#D3503600");
        list.add( "#040404");
        list.add( "#014C04");

*/


    }


    // Call as

}