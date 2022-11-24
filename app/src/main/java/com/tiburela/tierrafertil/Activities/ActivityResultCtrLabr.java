package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdpaterResultCalLabrsAgrcls;
import com.tiburela.tierrafertil.adapters.AdpaterResultCalLabrsAgrcls2;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.models.ResultCaldLabAgricls;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityResultCtrLabr extends AppCompatActivity {

    RecyclerView mireclcierView;
    Map<String , String> mihasmaPplantsObject;

    Map<String,Plant> mapPlants = new HashMap<>();

    String keySharePrefeItem="";  //este lo obtenemos desde un intent


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ctr_labr);

        mireclcierView=findViewById(R.id.mireclcierView);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            keySharePrefeItem = extras.getString(Utils.keyextraGLObal);



            //The key argument here must match that used in the other activity
        }






        SharePref.init(ActivityResultCtrLabr.this);

        mapPlants =  SharePref.getMapOfPlantsObjects(keySharePrefeItem); /////aqui le pasmas el key del objeto all forms  que se eleciono anteriormente

        ArrayList<Plant>plantsArrayList=Utils.arraListByHASMPA(mapPlants);

        generateArrayListTOreciclerandCallRecyclerAdapt(plantsArrayList);



    }





    //set recicler





    private  void  generateArrayListTOreciclerandCallRecyclerAdapt(ArrayList<Plant>listPlantsObjects){


        String [] miarrayKEY=Utils.returnaRRYkey();
        String [] miarrayNamesValue=Utils.returnarrayDataNames();

        ArrayList<ResultCaldLabAgricls>listOrecicleDataInitial=Utils.returnListInitialResults(miarrayNamesValue,listPlantsObjects.size());


        for(int indiceListPlants=0;indiceListPlants<listPlantsObjects.size();indiceListPlants++) { //obteemos por ejemplo  namesValues


           //obtenemos este hasmapa
            mihasmaPplantsObject=SharePref.loadMapPreferencesDataOfFields(ActivityResultCtrLabr.this, listPlantsObjects.get(indiceListPlants).getUniqueIdPlantAndKeyShare());


            for(int indice2=0; indice2<miarrayKEY.length; indice2++) { //iteramos el array y las k

                if(mihasmaPplantsObject.containsKey(miarrayKEY[indice2])){   //por aqui podemos chekear si contiene //en caso de ageragr otros items podemos decirle que si no contiene a expecion de estos

                    Log.i("noContains","el key es "+miarrayKEY[indice2]);


                    float valueThisItem=listOrecicleDataInitial.get(indiceListPlants).getPromedio() +Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2]));
                    listOrecicleDataInitial.get(indice2).setPromedio(valueThisItem);

                    //si es indice entre 1 al 9


                    if(indiceListPlants==listPlantsObjects.size()-1) {  ///si es el ultimo indice de listPlantsObjects.size(); hacemos la operacion


                        ///multiplicamos los valores del 1 al 5.....

                        /**para enfunde promedio y descripcion, pero ahora no tiene descripcion*/

                        float promedioPorCategorias=generaPromedioCategoriaByINDEXhasta(1,12,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(13).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(13).setPromedio(promedioPorCategorias);



                        /**para deshoje promedio y descripcion, pero ahora no tiene descripcion*/

                         promedioPorCategorias=generaPromedioCategoriaByINDEXhasta(15,21,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(22).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(22).setPromedio(promedioPorCategorias);



                        /**para apuntalamiento promedio y descripcion, pero ahora no tiene descripcion*/

                        promedioPorCategorias=generaPromedioCategoriaByINDEXhasta(24,28,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(29).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(29).setPromedio(promedioPorCategorias);



                        /**para deshije promedio y descripcion, pero ahora no tiene descripcion*/

                        promedioPorCategorias=generaPromedioCategoriaByINDEXhasta(31,36,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(37).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(37).setPromedio(promedioPorCategorias);




                        /**para otras labires promedio y descripcion, pero ahora no tiene descripcion*/

                        promedioPorCategorias=generaPromedioCategoriaByINDEXhasta(39,46,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(47).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(47).setPromedio(promedioPorCategorias);  //posicon deonde mostramos el promedio


                        //puedo poner si es los promeros 6 keys array //podemos generar un promedio by categorias....


                        float promedioTotalDelInforme= listOrecicleDataInitial.get(indice2).getPromedio()/listPlantsObjects.size(); ///aqui hacemos la operacion
                        listOrecicleDataInitial.get(indice2).setPromedio(promedioTotalDelInforme);

                        Log.i("noContains","el valor peomedio de este item es "+promedioTotalDelInforme);


                    }


                }else{


                    Log.i("noContains","no contiene esta data");

                }


                ///aqui iteramos los datos del hasmap..



            }

            ///aqui podemos sumar el promedio


        }



        setDataRecyclerView(listOrecicleDataInitial);

    }



private float generaPromedioCategoriaByINDEXhasta(int desde, int hastaIndice,ArrayList<ResultCaldLabAgricls>list){
    float promedioPorCategorias=0;

        for(int indice=desde; indice<hastaIndice+1; indice++){

             promedioPorCategorias=promedioPorCategorias+list.get(indice).getPromedio();


        }

return  promedioPorCategorias;

}





    private void setDataRecyclerView(ArrayList<ResultCaldLabAgricls> list){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityResultCtrLabr.this);
        AdpaterResultCalLabrsAgrcls2 adapter = new AdpaterResultCalLabrsAgrcls2(ActivityResultCtrLabr.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireclcierView.setLayoutManager(layoutManager);
        mireclcierView.setAdapter(adapter);
    }




}