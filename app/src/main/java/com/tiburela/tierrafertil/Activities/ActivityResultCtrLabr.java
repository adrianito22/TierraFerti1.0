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



    private void addDtatOrecicler(){

      //  String [] [] namesValues= { },

                String [] [] namesValues= {
                {"enfunde a tiempo","amarre enfunde","uso de efunda","identificacion edad","toldeo de funda",
                "limpieza racimo","dipadisco","deschive", "cirujia Dedos","enfunde barrera","racimos correctos","destore"},

                {"deshoje","corte hoja correcto","despunte", "codo","hoja puente","saneo cirujia"
                        ,"devio Hijos"}

                ,{"ensunche","recojeSuncho","ubicacionsuncho","recogepuntual",
                "ubicaciondepuntual"},

                {"deshijetiempo","direccion","ubicacion","hijosagua"},

                {"dobles","resiembra",

                "drenajes","limpiezempcado","limpiezabodega","manejodeshechos",
                "nutricion", "manejocobertura","limpiezmatas","riego",
                }
        };



        for(int indice=0;indice<namesValues.length;indice++) { //obteemos por ejemplo  namesValues
            //obtenemos un array lis
            String [] miArray  =namesValues[indice];

            for(int indice2=0;indice2<miArray.length;indice2++) { //iteramos el array y las k



            }

        }


        ArrayList <ResultCaldLabAgricls>listPreferencesAllinformsX= new ArrayList();

        //itreamos names and values();

        listPreferencesAllinformsX.add(new ResultCaldLabAgricls(3,2,3,2  ));




    }


    private ResultCaldLabAgricls createoBJECTResultCaldLabAgriclsbYMap(Map<String, String>miMapa){

        //ARARY BIDMEIONAL CON NAMES SECCIONES....

        Map<String, String>miMapaoFPrefrernces=new HashMap<>();




        int contadorCategoriasOfSUbArrays =0;



        String [] namesSecciones= {"ENFUNDE","DESHOJE","APUNTALAMIENTO","DESHIJE","OTRAS LABORES"};

          //obtyemmos la categoria actual
           String actegoriaActual=namesSecciones [contadorCategoriasOfSUbArrays];



                String [] [] namesValues= { {"enfunde a tiempo","amarre enfunde","uso de efunda","identificacion edad","toldeo de funda",
                "limpieza racimo","dipadisco","deschive", "cirujia Dedos","enfunde barrera","racimos correctos","destore"},

    {"deshoje","corte hoja correcto","despunte", "codo","hoja puente","saneo cirujia"
            ,"devio Hijos"}

     ,{"/ensunche","recojeSuncho","ubicacionsuncho","recogepuntual",
                "ubicaciondepuntual"},


     {"deshijetiempo","direccion","ubicacion","hijosagua"},
                {"dobles","resiembra"},


       {"nutricion", "manejocobertura","limpiezmatas","riego",
                        "drenajes","limpiezempcado","limpiezabodega","manejodeshechos"}
        };


                   //colcoar la lista de indfices keys que no existiran ...


                ResultCaldLabAgricls [] dsjdhd ={};

        String [] [] keysBySeccion= {{"enfunde/enfundetiempo","enfunde/amareenfunde","enfunde/usodefunda","enfunde/identificacionedad","enfunde/toldeodefunda" ,
                "enfunde/limpiezaracimo","enfunde/dipadisco","enfunde/deschive",
                "enfunde/cirujiaDedos","enfunde/enfundebarrera","enfunde/racimoscorrectos","enfunde/destore"},

                {"deshoje/deshoje","deshoje/cortehojacorrecto","deshoje/despunte", "deshoje/codo","deshoje/hojapuente","deshoje/saneocirujia"
                        ,"deshoje/devioHijos"},

                {"apuntalamiento/ensunche","apuntalamiento/recojeSuncho","apuntalamiento/ubicacionsuncho","apuntalamiento/recogepuntual",
                "apuntalamiento/ubicaciondepuntual"},

                {"deshijetiempo/deshijetiempo","deshijetiempo/direccion","deshijetiempo/ubicacion","deshijetiempo/hijosagua"},
                {"deshijetiempo/dobles","deshijetiempo/resiembra"},

                {"otraslabores/nutricion", "otraslabores/manejocobertura","otraslabores/limpiezmatas","otraslabores/riego",
                        "otraslabores/drenajes","otraslabores/limpiezempcado","otraslabores/limpiezabodega","otraslabores/manejodeshechos"}
        };


        String []  keysBySeccionxx= {"enfunde/enfundetiempo","enfunde/amareenfunde","enfunde/usodefunda","enfunde/identificacionedad","enfunde/toldeodefunda" ,
                "enfunde/limpiezaracimo","enfunde/dipadisco","enfunde/deschive",
                "enfunde/cirujiaDedos","enfunde/enfundebarrera","enfunde/racimoscorrectos","enfunde/destore"

                ,"deshoje/deshoje","deshoje/cortehojacorrecto","deshoje/despunte", "deshoje/codo","deshoje/hojapuente","deshoje/saneocirujia"
                        ,"deshoje/devioHijos",

                "apuntalamiento/ensunche","apuntalamiento/recojeSuncho","apuntalamiento/ubicacionsuncho","apuntalamiento/recogepuntual",
                        "apuntalamiento/ubicaciondepuntual",

                "deshijetiempo/deshijetiempo","deshijetiempo/direccion","deshijetiempo/ubicacion","deshijetiempo/hijosagua",
                "deshijetiempo/dobles","deshijetiempo/resiembra",

                "otraslabores/nutricion", "otraslabores/manejocobertura","otraslabores/limpiezmatas","otraslabores/riego",
                        "otraslabores/drenajes","otraslabores/limpiezempcado","otraslabores/limpiezabodega","otraslabores/manejodeshechos"
        };






        ///ahora actualizamos
        //recoremos esto 10 veces...
        dfgfg

        //creamos




        //iteramos keys
        String  [] currentARRaySeccion=keysBySeccion[contadorCategoriasOfSUbArrays];


        int contadorSeecion = 0;

        for(String key: currentARRaySeccion) {  //iteramos el array seccion
            if(miMapaoFPrefrernces.containsKey(key)) { ///ok obten este value


            }


        }

        contadorSeecion++;

///ENTONCES ITERAMOS



        //NECESITAMOS CREAR EL SIZE DE LISTAS DE NAMES SECCION
        for(int indice=0;  indice<namesSecciones.length; indice++){ //iteramos el primer

            ArrayList<ResultCaldLabAgricls>list= new ArrayList<>();

            //


        }


        //NECESITAMOS CREAR EL SIZE DE LISTAS DE NAMES SECCION
        for(int indice=0;  indice<namesSecciones.length; indice++){ //iteramos el primer

            ArrayList<ResultCaldLabAgricls>list= new ArrayList<>();

            //


        }



        //busca las que contiene el primer keybuseccion y gaudar el resultado

        //for para iterar ambos array de tidpo String..


        //aqui iteramos por seccion.... queremos


        //iteramos dataseccion::::

        //iterar hasm


       //cremaos la data procuarar...que en donde sale info de planta este todo  todo si no no se puede obtener data... y mostrar ...




     //   ResultCaldLabAgricls item= new ResultCaldLabAgricls();


    }

    private   ArrayList<ResultCaldLabAgricls> returnListInitialResults(  String [] [] keysBySeccion, String []  namesItems,int numPlantasCalificadas){
        ArrayList<ResultCaldLabAgricls>LIStff= new ArrayList();

        for(int indice=0; indice<keysBySeccion.length; indice++){
            //aquii le agregamos si es title otro u optro....pilaxx //dpendiendo del indice

            LIStff.add(new ResultCaldLabAgricls(namesItems[indice],numPlantasCalificadas,0 ,false));


        }

        return LIStff;


    }



    private void setDataRecyclerView(ArrayList<Plant> list){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityResultCtrLabr.this);
        AdpaterResultCalLabrsAgrcls adapter = new AdpaterResultCalLabrsAgrcls(ActivityResultCtrLabr.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireclcierView.setLayoutManager(layoutManager);
        mireclcierView.setAdapter(adapter);
    }

}