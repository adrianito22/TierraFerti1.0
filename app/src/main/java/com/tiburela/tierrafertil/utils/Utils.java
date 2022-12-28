package com.tiburela.tierrafertil.utils;

import android.util.Log;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.models.AllFormsModel;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.models.ResultCaldLabAgricls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {
   public static  boolean esPrimerItemPlanta =false;

   public static  String keyextraGLObal ="KEYEXTRASSparatodos";

   public static HashMap<String, String> hasmapFitosnitario= new HashMap<>();

  public static HashMap<String,String>miMapaToSaveMoreInfoPlants= new HashMap<>();


   public static  String [] arrayWhitkeysMapCategories ={"Enfunde","Deshoje","Apuntalamiento","Deshije","Otras labores"};
   public static HashMap<String, ArrayList<ResultCaldLabAgricls>>hasmapCalidLAbsAgricls= new HashMap<>();
   public static  String keyIntentXtraAllinforms ="KEY EXTRASS";
   public static  String keyIntentXtraInformsPlant ="KEY EXTRASSplant";


   public static  String keyDialogBundle ="diaslogBundleKey";


   public static final int DATE_ESPECIFIC =11;
   public static final int RANGE_DATE =12;
   public static final int TYPE_FORM =13;

   public static  String currentInformSelectedId ="";

   public static final String KEY_INTEN_LABORES_AGROICOLAS ="LASNDFNFDNF";

   public static TextInputEditText returnEditextBykey(String keyItem, TextInputEditText [] arrayEditext){
      TextInputEditText currenEditextx=null;


      int indicecontado=0;

      for(TextInputEditText currenEditext : arrayEditext){ //buscamos el key en el tag



         if(currenEditext==null){
            Log.i("misndnd","el currenEditext es nulo y es indice "+indicecontado);


            break;
         }



         if(keyItem==null){
            Log.i("misndnd","el valor de key es nulo y es indice "+indicecontado);


           break;
         }


         Object myObject = currenEditext.getTag();
         if (myObject != null) {

            Log.i("misndnd","el valor de tag textview es nulo y es indice "+indicecontado);

         }




         indicecontado++;







            if(currenEditext.getTag().toString().equals(keyItem)){

               currenEditextx=currenEditext ;
            }







   }
   return currenEditextx;

}

public static ArrayList <Plant> arraListByHASMPA(Map<String, Plant> hasmpap){

   ArrayList<Plant> plantArrayList = new ArrayList<>(hasmpap.values());
      return  plantArrayList;

}


   public static ArrayList <AllFormsModel> arraListByHASMPAAllForms(Map<String, AllFormsModel> hasmpap){

      ArrayList<AllFormsModel> plantArrayList = new ArrayList<>(hasmpap.values());
      return  plantArrayList;

   }



   public static  String [] returnaRRYkey(){

      String [] arraysWhitKeys = {"TITLE", "enfunde/enfundetiempo","enfunde/amareenfunde","enfunde/usodefunda","enfunde/identificacionedad","enfunde/toldeodefunda" ,
              "enfunde/limpiezaracimo","enfunde/dipadisco","enfunde/deschive",
              "enfunde/cirujiaDedosx","enfunde/enfundebarrera","enfunde/racimoscorrectos","enfunde/destore","porcentajexxENfundeYobsrvacion"

              ,"TITLE","deshoje/deshoje","deshoje/cortehojacorrecto","deshoje/despunte", "deshoje/codo","deshoje/hojapuente","deshoje/saneocirujiax"
              ,"deshoje/devioHijos","porcentajexxDeshojeYobsrvacion",

              "TITLE", "apuntalamiento/ensunche","apuntalamiento/recogepuntual","apuntalamiento/ubicacionsuncho","apuntalamiento/ubicaciondepuntual",
              "apuntalamiento/recojeSuncho","porcentajexxApuntalamientoYobsrvacion",


              "TITLE","deshijetiempo/deshijetiempo","deshijetiempo/direccion","deshijetiempo/ubicacion","deshijetiempo/hijosagua",
              "deshijetiempo/dobles","deshijetiempo/resiembra","porcentajexxDehijeTiempoYobsrvacion",


              "TITLE","otraslabores/nutricion", "otraslabores/manejocobertura","otraslabores/limpiezmatas","otraslabores/riego",
              "otraslabores/drenajes","otraslabores/limpiezempcado","otraslabores/limpiezabodega","otraslabores/manejodeshechos"
              ,"porcentajexxOtrasLaboresYobsrvacion"  //48 creo

      };


      return arraysWhitKeys;
   }


   public static  String [] returnarrayDataNames(){

      String []  namesValues= {"ENFUNDE",
              "enfunde a tiempo","amarre de funde","uso de efunda","identificacion edad","toldeo de funda",
                      "limpieza de  racimos","daipa disco","deschive", "cirujia de Dedos","enfunde barrera","racimos correctos","destore","hijole",

              "DESHOJE", "deshoje","corte hoja correcto","despunte", "codo","hoja puente","saneo  y cirujia"
                      ,"devio Hijos","hijole",

              "APUNTALAMIENTO","ensunche","recoge puntual","ubicacion de suncho",
              "ubicacion de puntal","recoge Suncho","hijole",

              "DESHIJE","deshije a tiempo","direccion","ubicacion","hijos agua",
              "dobles","resiembra","hijole",

              "OTRAS LABORES","nutricion", "manejo de cobertura","limpieza de matas","riego",
              "drenajes","limpieza empacado","limpieza de bodegas","manejo de shechos",
              "hijole"


      };


      return namesValues;

   }



   public static   ArrayList<ResultCaldLabAgricls> returnListInitialResults( String []  namesItems,int numPlantasCalificadas){
      ArrayList<ResultCaldLabAgricls>LIStff= new ArrayList();

      Log.i("xxxxxx","el size de names es "+namesItems.length);

      for(int indice=0; indice<namesItems.length; indice++){
         //aquii le agregamos si es title otro u optro....pilaxx //dpendiendo del indice

         LIStff.add(new ResultCaldLabAgricls(namesItems[indice],numPlantasCalificadas,0 ,false));

         Log.i("xxxxxx","el size de lista es "+LIStff.size());

      }


      Log.i("sixdd","el size de la lista inicia es "+LIStff.size());

      getPromedioByCategories(LIStff);
      return LIStff;


   }

   private static void getPromedioByCategories(ArrayList<ResultCaldLabAgricls> listOrecicleDataInitial){
      //promedio del primer value..

      float promedioEnfunde=0;


      Log.i("dddd","el size aqui es cccxccc "+listOrecicleDataInitial.size());

      for(ResultCaldLabAgricls obje: listOrecicleDataInitial){

         if(obje.getPromedio()==0){
            Log.i("dddd","sizxx");


         }



      }




   }






   public static  void SAVEhashmapCurrentCuadro(String tag, EditText[]arrayColumnHn, EditText[]arrayColumnTh, EditText[]arrayColumnHe,String keyprefrences ) {
      // un arary klist of views....
     // String tag = "/pl0Semns";



      Log.i("slaerorfd","en save cuadro el size es "+ Utils.hasmapFitosnitario.size());



      for (int indice = 0; indice < arrayColumnHn.length; indice++) {

         if (!arrayColumnHn[indice].getText().toString().trim().isEmpty()) {


            if(! checkIFdATAiSvALIDATE(arrayColumnHn[indice].getText().toString(),arrayColumnHn[indice])) {

               return ;
            }


            Utils.hasmapFitosnitario.put(tag + arrayColumnHn[indice].getId(), arrayColumnHn[indice].getText().toString());
         }


         if (!arrayColumnTh[indice].getText().toString().trim().isEmpty()) {

            if(! checkIFdATAiSvALIDATE(arrayColumnTh[indice].getText().toString(),arrayColumnTh[indice])) {

               return ;
            }

            Utils.hasmapFitosnitario.put(tag + arrayColumnHn[indice].getId(), arrayColumnHn[indice].getText().toString());
         }


         if (!arrayColumnHe[indice].getText().toString().trim().isEmpty()) {

            if(! checkIFdATAiSvALIDATE(arrayColumnHe[indice].getText().toString(),arrayColumnHe[indice])) {

               return ;
            }


            Utils.hasmapFitosnitario.put(tag + arrayColumnHn[indice].getId(), arrayColumnHn[indice].getText().toString());

         }


      }


      //aqui guardamos....

      //lñe psamos un string inbtent



      SharePref.saveMapPreferFields( Utils.hasmapFitosnitario,keyprefrences);





   }


   static   boolean checkIFdATAiSvALIDATE(String value,EditText currentEditext){

      try {

         float valuex=Float.parseFloat(value);


         if(valuex>40){
            currentEditext.requestFocus();
            currentEditext.setError("No mayor a 40");
            return false;
         }


         if(valuex<=0){
            currentEditext.requestFocus();
            currentEditext.setError("No menor o igual a 0");
            return false;
         }





      } catch (Exception e) {
         e.printStackTrace();

      }





      return   true;

   }


   public static  void SAVEhashmapCurrentCuadro(String tag, EditText[]arrayColumnHn, EditText[]arrayColumnHe,String keyprefrences ) {
      // un arary klist of views....
      // String tag = "/pl0Semns";


      for (int indice = 0; indice < arrayColumnHn.length; indice++) {

         if (!arrayColumnHn[indice].getText().toString().trim().isEmpty()) {
            Utils.hasmapFitosnitario.put(tag + arrayColumnHn[indice].getId(), arrayColumnHn[indice].getText().toString());
         }




         if (!arrayColumnHe[indice].getText().toString().trim().isEmpty()) {
            Utils.hasmapFitosnitario.put(tag + arrayColumnHn[indice].getId(), arrayColumnHn[indice].getText().toString());
         }


      }


      //aqui guardamos....

      //lñe psamos un string inbtent



      SharePref.saveMapPreferFields( Utils.hasmapFitosnitario,keyprefrences);





   }






   public static void addDataHashmapInEditext( HashMap<String, String> hasmapFitosnitario,EditText[]arrayColumnHn, EditText[]arrayColumnTh,
                                               EditText[]arrayColumnHe, String currenTag) {

      // Utils.hasmapFitosnitario= (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(getActivity(),intentSahrePrefrencesKey);

      //keys


      for (int indice = 0; indice < arrayColumnHn.length; indice++) {

         String keyCurrent=currenTag+arrayColumnHn [indice].getId();

         if( hasmapFitosnitario.containsKey(keyCurrent)) {

            String content = hasmapFitosnitario.get(keyCurrent);
            arrayColumnHn [indice].setText(content);

         }

         if( hasmapFitosnitario.containsKey(keyCurrent)) {
            String content = hasmapFitosnitario.get(keyCurrent);
            arrayColumnHe [indice].setText(content);
         }

         if( hasmapFitosnitario.containsKey(keyCurrent)) {

            String content = hasmapFitosnitario.get(keyCurrent);
            arrayColumnTh [indice].setText(content);
         }


      }


   }




   public static void addDataHashmapInEditext( HashMap<String, String> hasmapFitosnitario,EditText[]arrayColumnHn,
                                               EditText[]arrayColumnHe, String currenTag) {

      // Utils.hasmapFitosnitario= (HashMap<String, String>) SharePref.loadMapPreferencesDataOfFields(getActivity(),intentSahrePrefrencesKey);

      //keys


      for (int indice = 0; indice < arrayColumnHn.length; indice++) {

         String keyCurrent=currenTag+arrayColumnHn [indice].getId();

         if( hasmapFitosnitario.containsKey(keyCurrent)) {

            String content = hasmapFitosnitario.get(keyCurrent);
            arrayColumnHn [indice].setText(content);

         }

         if( hasmapFitosnitario.containsKey(keyCurrent)) {
            String content = hasmapFitosnitario.get(keyCurrent);
            arrayColumnHe [indice].setText(content);
         }




      }


   }






}

