package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterPlant;
import com.tiburela.tierrafertil.adapters.AdpaterResultCalLabrsAgrcls;
import com.tiburela.tierrafertil.dialogs.DialogFragmentx;
import com.tiburela.tierrafertil.models.LaboresAgricolsHelper;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.models.ResultCaldLabAgricls;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityResultCtrLabr extends AppCompatActivity {

    RecyclerView mireclcierView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ctr_labr);



        mireclcierView=findViewById(R.id.mireclcierView);



    }





    //set recicler







    private void createDataHASMAPAndListHelper(String keyOfPlantsInform){


        //oobtenem un hashmap con las plantas informes

        Map<String , Plant> mihasmaPplantsObject= SharePref.getMapOfPlantsObjects(keyOfPlantsInform);


        String[] keysOFhasmAPSoFmaps   ={"UNO","DOS","TRES","CUATRO","CINCO"}; //LOS NOMBRES DE LAS CATEGORIAS

        ArrayList<LaboresAgricolsHelper>milistOtherDATA= new ArrayList();








        for(Plant currentPlantObjec: mihasmaPplantsObject.values() ){ ///CREMOAS ITEMS EL NUMERO DE HASMAPS OBJECTS

          Map<String ,String>mihasmpaPLantaData= SharePref.loadMapPreferencesDataOfFields(ActivityResultCtrLabr.this, currentPlantObjec.getUniqueIdPlantAndKeyShare());

             //convierte hasmapdata en objeto ResultCaldLabAgricls;;

            sgs


            for(int indice=0; indice<; indice++){  //ahora obtenemos esta data
                ///aqui necesitamos los datos de  este hasmpa data..

            }



            milistOtherDATA.add(new LaboresAgricolsHelper())

        }


        for(int indice=0; indice<mihasmaPplantsObject){


        }

        //iteramos hasmap object



        //quremos un informe plantas al

        //1queremos informes plantas y solo asi obtenemos los hasmpas con plantas data...






    }




    private ResultCaldLabAgricls createoBJECTResultCaldLabAgriclsbYMap(Map<String, String>miMapa){

        //ARARY BIDMEIONAL CON NAMES SECCIONES....

       String [] [] datSeccion= { {"Labres agricolas","seccion 1","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"}
         ,{"Labres agricolas","seccion 1","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"},
               {"Labres agricolas","seccion 1","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"}

        };



        String [] [] keysBySeccion= { {"ab/letras","sma/letras","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"}
                ,{"Labres agricolas","seccion 1","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"},
                {"Labres agricolas","seccion 1","seccion 3","seccion4"},{"Labres agricolas","seccion 1","seccion 3","seccion4"}

        };



        //busca las que contiene el primer keybuseccion y gaudar el resultado

         for(){
         int float value=0;

             for(){ ///iteramos el mapa suando keys  ///si el key contiene este obtenemos el resultadp

                  //aqui sumamos el value:
             }

             //aqui gaurdamos este value y creamos un objeto result y lo agaregamos a la array lis:::


         }


        //for para iterar ambos array de tidpo String..


        //aqui iteramos por seccion.... queremos


        //iteramos dataseccion::::

        //iterar hasm




       //cremaos la data procuarar...que en donde sale info de planta este todo  todo si no no se puede obtener data... y mostrar ...







        ResultCaldLabAgricls item= new ResultCaldLabAgricls();


    }



    private void setDataRecyclerView(ArrayList<Plant> list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityResultCtrLabr.this);
        AdpaterResultCalLabrsAgrcls adapter = new AdpaterResultCalLabrsAgrcls(ActivityResultCtrLabr.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireclcierView.setLayoutManager(layoutManager);
        mireclcierView.setAdapter(adapter);






    }

}