package com.tiburela.tierrafertil.SharePref;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tiburela.tierrafertil.models.AllFormsModel;
import com.tiburela.tierrafertil.models.Plant;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SharePref {
 //al menos 5 keys.. UNA POR CADA FORMULARIO

    public static final String KEYI_CALIDAD_LABORES_AGRCICOLAS_MAP="KEYCALIDADLABORES";
    public static final String KEY_AllINFORMS_SHAREP="kEYALLINFORMSlIST";
    public static  final String KEY_ALL_PLANTS="HELOOHEYPLANTS";

    public static  final String keyIntent="esunketuur";


    private static SharedPreferences mSharedPrefUniqueObjc;


    public static void init(Context context)
    {
        if(mSharedPrefUniqueObjc == null)
            mSharedPrefUniqueObjc = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }


    public static void saveMapPreferFields(Map<String, String> inputMap,String KeyTOsAVE) {
      //  SharedPreferences pSharedPref = context.getSharedPreferences("MyVariables", Context.MODE_PRIVATE);
        if (mSharedPrefUniqueObjc != null) {
            JSONObject jsonObject = new JSONObject(inputMap);
            String jsonString = jsonObject.toString();
            mSharedPrefUniqueObjc.edit()
                    //.remove("My_map")
                    .putString(KeyTOsAVE, jsonString) //se guarda en una solo string..
                    .apply();

            //confomre cre le basamos guardando..
        }
    }





    public static void deleteMap(Context context,String keyTOremove) {
       // SharedPreferences pSharedPref = context.getSharedPreferences("MyVariables", Context.MODE_PRIVATE);
        if (mSharedPrefUniqueObjc != null) {
            mSharedPrefUniqueObjc.edit()
                    .remove(keyTOremove)
                    //.putString("My_map", jsonString)
                    .apply();
        }
    }





    public static Map<String, String> loadMapPreferencesDataOfFields(Context context, String keyMap) {
        Map<String, String> outputMap = new HashMap<>();
        try {
            if (mSharedPrefUniqueObjc != null) {
                String jsonString = mSharedPrefUniqueObjc.getString(keyMap,(new JSONObject()).toString());
                if (jsonString != null) {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Iterator<String> keysItr = jsonObject.keys();
                    while (keysItr.hasNext()) {
                        String key = keysItr.next();
                        String value = jsonObject.getString(key);
                        outputMap.put(key, value);
                    }
                }else {

                    outputMap= new HashMap<>();

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return outputMap;
    }



    public static  void saveMapAlLINFORMS(Map<String,AllFormsModel> inputMap,String keySharePref) {
        if (mSharedPrefUniqueObjc != null){
           // JSONObject jsonObject = new JSONObject(inputMap);
         //   String jsonString = jsonObject.toString();
            mSharedPrefUniqueObjc.edit()
                  //  .remove("My_map")
                     .putString(keySharePref, new Gson().toJson(inputMap))


                   // .putString(keySharePref, jsonString)
                    .apply();
        }
    }

    public static  Map<String,AllFormsModel> loadMapPreferencesDataOfFields(String keyShare) {

            Gson   gson = new Gson();
            String response=mSharedPrefUniqueObjc.getString(keyShare , "");

            Type type = new TypeToken<Map<String,AllFormsModel>>(){}.getType();
        Map<String,AllFormsModel> map;
        map = gson.fromJson(response, type);


            if(response.equals("")) {
                Log.i("lashareperf","no hay data en share");

                map= new HashMap<>();
                return map;

            }else{

                Log.i("lashareperf","Si hay data en share y data es length es "+response);

                return map;


            }





    }


    public static void saveListInformAllInforms (List<AllFormsModel> listInforms, String KeyTOsAVE) {
        Gson   gson = new Gson();
        String jsonListString = gson.toJson(listInforms);

        mSharedPrefUniqueObjc.edit()
                //.remove("My_map")
                .putString(KeyTOsAVE, jsonListString) //se guarda en una solo string..
                .apply();

    }


    public static void saveListInformPlants (List<Plant> listInforms, String KeyTOsAVE) {
        Gson   gson = new Gson();
        String jsonListString = gson.toJson(listInforms);

        mSharedPrefUniqueObjc.edit()
                //.remove("My_map")
                .putString(KeyTOsAVE, jsonListString) //se guarda en una solo string..
                .apply();

    }





    public static  List<AllFormsModel> getListAlLiforms ( String KeyOfItem) {
        Gson   gson = new Gson();
        String response=mSharedPrefUniqueObjc.getString(KeyOfItem , "");

        Type type = new TypeToken<List<AllFormsModel>>(){}.getType();
        List<AllFormsModel> carsList;
        carsList = gson.fromJson(response, type);


        if(response.equals("")) {
            Log.i("lashareperf","no hay data en share");

            carsList= new ArrayList<>();
            return carsList;

        }else{

            Log.i("lashareperf","Si hay data en share y el length es "+carsList.size());

            return carsList;


        }


    }


//    public static  Map<String,AllFormsModel> loadMapPreferencsHashMapOfHashMap(String keyShare) {


    public static  Map<String,  Map<String,String>> loadMapPreferencsHashMapOfHashMapPlanstData(String keyShare) {

        Gson gson = new Gson();
        String response=mSharedPrefUniqueObjc.getString(keyShare , "");

        Type type = new TypeToken<Map<String, Map<String,String>>>(){}.getType();

        Map<String, Map<String,String>> map;
        map = gson.fromJson(response, type);


        if(response.equals("")) {
            Log.i("lashareperf","no hay data en share");

            map= new HashMap<>();
            return map;

        }else{

            Log.i("lashareperf","Si hay data en share y data es length es "+response);

            return map;


        }



    }



    public static  void saveHashMapOfHashmapWhitPlatsObject(  Map<String, Plant> inputMap,String keySharePref) {
        if (mSharedPrefUniqueObjc != null){
            // JSONObject jsonObject = new JSONObject(inputMap);
            //   String jsonString = jsonObject.toString();
            mSharedPrefUniqueObjc.edit()
                    //  .remove("My_map")
                    .putString(keySharePref, new Gson().toJson(inputMap))


                    // .putString(keySharePref, jsonString)
                    .apply();
        }
    }



    public static   Map<String,Plant> getMapOfPlantsObjects(String KeyOfItem) {

        Gson   gson = new Gson();
        String response=mSharedPrefUniqueObjc.getString(KeyOfItem , "");

        Type type = new TypeToken<Map<String,Plant>>(){}.getType();

        Map<String,Plant> mapPlants;
        mapPlants = gson.fromJson(response, type);


        if(response.equals("")) {
            Log.i("lashareperf","no hay data en share plant ");

            mapPlants= new HashMap<>();
            return mapPlants;

        }else{

            Log.i("lashareperf","Si hay data en share  plant y el length es "+mapPlants.size());

            return mapPlants;


        }


    }



}
