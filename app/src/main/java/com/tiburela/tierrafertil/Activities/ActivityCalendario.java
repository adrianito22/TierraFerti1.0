package com.tiburela.tierrafertil.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterCalendario;
import com.tiburela.tierrafertil.calendario.BottonSheetCalendarioEnf;
import com.tiburela.tierrafertil.calendario.UtilsCalendario;
import com.tiburela.tierrafertil.calendario.CalendarioEnf;
import com.tiburela.tierrafertil.utils.Variables;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityCalendario extends AppCompatActivity {

    RecyclerView mireciclerView;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        mireciclerView=findViewById(R.id.mireciclerView);
        SharePref.init(ActivityCalendario.this);
        getCalendarPrefrencesAndSave();


        /***DE PRUEBA*/
        UtilsCalendario.initArrayColorsCinta();   //inicilziamos array de colores

        UtilsCalendario.creaetAndOrdenaListColors(3);

    }




    private void setDataRecyclerView(ArrayList<CalendarioEnf> list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityCalendario.this);
        AdapterCalendario adapter = new AdapterCalendario(ActivityCalendario.this, list);
        mireciclerView.setLayoutManager(layoutManager);
        mireciclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterCalendario.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {


                Variables.currentCalEnfundeoBJECt=Variables.miMap.get(v.getTag().toString());
                Log.i("elcickler","el SIZE DE MAP ES "+Variables.miMap.size());


                Log.i("elcickler","el TAG ES  "+v.getTag().toString());


                Log.i("elcickler","el id de este obejto es "+Variables.currentCalEnfundeoBJECt.getUniqueId());




                FragmentManager fm = getSupportFragmentManager();
                BottonSheetCalendarioEnf alertDialog = BottonSheetCalendarioEnf.newInstance();
                // alertDialog.setCancelable(false);

             //   alertDialog.setArguments(bundle);
                alertDialog.show(fm, "duialoffragment_alert");




                //abrimos dialog

                //aqui inicilizamos el informe...



                // String keySharePrefrencesItemClicked=v.getTag().toString();


               // sheetBootomInforOptions(v.getTag().toString());


                Log.i("elcickler","el click es llamado");




            }
        });




    }

    //CREATE AND SAVE CALENDAR IF NO EXISTE CALENDARIO

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getCalendarPrefrencesAndSave(){

        Variables.miMap= SharePref.getMapOfCalendarioObjects(SharePref.KEY_CALENDARIO_ENFUNDE);

        if(Variables.miMap.size()<= 1){ //cremaosno existe el mapa



            Log.i("elcickler","SE EEJCUTO ELIF ");

            UtilsCalendario.indiceColors=0; //resetamos en cero el indice del claendario
            UtilsCalendario.initArrayColorsCinta();   //inicilziamos array de colores
            AdapterCalendario.listCalendario= new ArrayList<CalendarioEnf>(); //inicilizamos este array
            UtilsCalendario.generateCalendarioYear(2022,2);


            ///SORTER ARRA LIST
            AdapterCalendario.listCalendario= generateArraylistByMapAndSOTER(Variables.miMap);
            setDataRecyclerView(AdapterCalendario.listCalendario);

            /**convertimos estearray list en mapa y lo gaurdamos en prefrencias*/

            Variables.miMap=generateMapByArrayList(AdapterCalendario.listCalendario);

            SharePref.saveHashMapOfHashmapWhitCalendario(Variables.miMap,SharePref.KEY_CALENDARIO_ENFUNDE);

            //aqui ya debemos tener data en este aray list...AdapterCalendario.listCalendario

        }else{ //tenemsoelmapa de prefrencias porque si ha data
           // Variables.  miMap= SharePref.getMapOfCalendarioObjects(SharePref.KEY_CALENDARIO_ENFUNDE);
            Log.i("elcickler","SE EEJCUTO EL ELSE ");


            AdapterCalendario.listCalendario= generateArraylistByMapAndSOTER(Variables.miMap);


            //OPRDENAMOS..

            setDataRecyclerView(AdapterCalendario.listCalendario);


        }



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<CalendarioEnf> generateArraylistByMapAndSOTER(Map<String,CalendarioEnf> map){

        ArrayList<CalendarioEnf>miArryList=new ArrayList<>();

        for(CalendarioEnf objec: map.values()){

            miArryList.add(objec);
        }


        ArrayList<CalendarioEnf> sortedUsers = (ArrayList<CalendarioEnf>) miArryList.stream()
                .sorted(Comparator.comparing(CalendarioEnf::getSemanaNum))
                .collect(Collectors.toList());



        return sortedUsers;

    }

    private HashMap<String,CalendarioEnf> generateMapByArrayList( ArrayList<CalendarioEnf>miArryList){
        HashMap<String,CalendarioEnf>map=new HashMap<>();

       // ArrayList<CalendarioEnf>miArryList=new ArrayList<>();

        for(CalendarioEnf objec: miArryList){

            map.put(objec.getUniqueId(),objec);
        }



        return map;

    }


    @Override
    protected void onStart() {
        super.onStart();

        scrolloToPosition();

    }



    private void scrolloToPosition(){

      //a que posicion vamos hacer scrollo

        int semanaNum= Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

        Log.i("misemana","la semana es "+semanaNum);

        mireciclerView.scrollToPosition(semanaNum-1);

    }
}