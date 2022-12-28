package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdpaterResultCalLabrsAgrcls;
import com.tiburela.tierrafertil.adapters.AdpaterResultCalLabrsAgrcls2;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.models.PromedioLaboresAgric;
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

        checkvalue();

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

        boolean sellamoUnVEZ=false;


        String [] miarrayKEY=Utils.returnaRRYkey();
        String [] miarrayNamesValue=Utils.returnarrayDataNames();


        /**cremaos una lista inicial con los valores de promedios*/


        ArrayList<ResultCaldLabAgricls>listOrecicleDataInitial=Utils.returnListInitialResults(miarrayNamesValue,listPlantsObjects.size());

        PromedioLaboresAgric objec= new PromedioLaboresAgric();


        for(int indiceListPlants=0;indiceListPlants<listPlantsObjects.size();indiceListPlants++) { //obteemos por ejemplo  namesValues


           //obtenemos un mapa ..cbtenemos tanto como el nuemro de plantas..

            mihasmaPplantsObject=SharePref.loadMapPreferencesDataOfFields(ActivityResultCtrLabr.this, listPlantsObjects.get(indiceListPlants).getUniqueIdPlantAndKeyShare());

            String keyCurrent;

            ////recoremos el hasmap usando los keys...
            for(int indice2=0; indice2<miarrayKEY.length; indice2++) { //iteramos el array y las k

                keyCurrent=miarrayKEY[indice2];

                if(mihasmaPplantsObject.containsKey(miarrayKEY[indice2])){   //por aqui podemos chekear si contiene //en caso de ageragr otros items podemos decirle que si no contiene a expecion de estos

                    Log.i("noContains","el key es "+miarrayKEY[indice2]);




                    //guardamos el promedio
                    float valueThisItem;
                   //  float valueThisItem=listOrecicleDataInitial.get(indiceListPlants).getPromedio() +Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2]));
                    // listOrecicleDataInitial.get(indice2).setPromedio(valueThisItem);

                    //si es indice entre 1 al 9



                 //   if(miarrayKEY[indice2] .equals("enfunde/enfundetiempo")) {

                        Log.i("esdebrr","el value de enfunde anteriuor  dese la lista es "+listOrecicleDataInitial.get(indice2).getPromedio());

                                Log.i("esdebrr","el value de  este item of hjashmap es " +Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));


                                /**gaurdamos el valor que contiene el contenido de esta key*/




                        valueThisItem=listOrecicleDataInitial.get(indice2).getPromedio() +Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2]));


                    if(keyCurrent.contains("enfunde")){

                        Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());


                        objec.setEnfundeProm(objec.getEnfundeProm()+Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));
                        Log.i("pmedioddd","el ENFUNDE promedio es "+objec.getEnfundeProm());

                    }

                       if(keyCurrent.contains("deshoje")){

                           Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());


                           objec.setDeshojeProm(objec.getDeshojeProm()+Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));
                           Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());

                       }



                    if(keyCurrent.contains("apuntalamiento")){

                        Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());


                        objec.setApuntalamientoProm(objec.getApuntalamientoProm()+Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));
                        Log.i("pmedioddd","el apuntalamiento promedio es "+objec.getApuntalamientoProm());

                    }


                    if(keyCurrent.contains("deshijetiempo")){

                        Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());


                        objec.setDeshijeProm(objec.getDeshojeProm()+Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));
                        Log.i("pmedioddd","el deshijetiempo promedio es "+objec.getDeshojeProm());

                    }


                    if(keyCurrent.contains("otraslabores")){

                        Log.i("pmedioddd","el deshoje promedio es "+objec.getDeshojeProm());


                        objec.setOtrasLaboresProm(objec.getOtrasLaboresProm()+Float.parseFloat(mihasmaPplantsObject.get(miarrayKEY[indice2])));
                        Log.i("pmedioddd","el otraslabores es "+objec.getOtrasLaboresProm());

                    }


                        listOrecicleDataInitial.get(indice2).setPromedio(valueThisItem);

                        Log.i("esdebrr","el value de enfunde a tiempo es ahora es "+listOrecicleDataInitial.get(indice2).getPromedio());


                  //  }





                    if(indiceListPlants==listPlantsObjects.size()-1 && ! sellamoUnVEZ) {
                        ///si es el ultimo indice de listPlantsObjects.size(); hacemos la operacion
                        Log.i("sanax","generamos promedio ");
                        Log.i("sanax","compare "+indiceListPlants+" "+(listPlantsObjects.size()-1));


                        ///multiplicamos los valores del 1 al 5.....

                        /**para enfunde promedio y descripcion, pero ahora no tiene descripcion*/

                        float sumCtegory=generaPromedioCategoriaByINDEXhasta(1,12,listOrecicleDataInitial);



                        listOrecicleDataInitial.get(13).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(13).setPromedio(sumCtegory / 12 ); // 12 es el numero de items de esta categoria


                        Log.i("sanaxxx","el promedio catgeoria en index 13 es  "+listOrecicleDataInitial.get(13).getPromedio());


                        //Log.i("sanaxxx","generamos total y es "+listOrecicleDataInitial.get(13).getPromedio());


                        Log.i("soledad"," el promedio es  "+(sumCtegory/12 ));


                        /**para deshoje promedio y descripcion, pero ahora no tiene descripcion*/

                         sumCtegory=generaPromedioCategoriaByINDEXhasta(15,21,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(22).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(22).setPromedio(sumCtegory/7);



                        Log.i("sanaxxx","el promedio catgeoria en index 22 es  "+listOrecicleDataInitial.get(22).getPromedio());


                        /**para apuntalamiento promedio y descripcion, pero ahora no tiene descripcion*/

                        sumCtegory=generaPromedioCategoriaByINDEXhasta(24,28,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(29).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(29).setPromedio(sumCtegory/5);



                        /**para deshije promedio y descripcion, pero ahora no tiene descripcion*/

                        sumCtegory=generaPromedioCategoriaByINDEXhasta(31,36,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(37).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(37).setPromedio(sumCtegory/6);




                        /**para otras labires promedio y descripcion, pero ahora no tiene descripcion*/

                        sumCtegory=generaPromedioCategoriaByINDEXhasta(39,46,listOrecicleDataInitial);
                        listOrecicleDataInitial.get(47).setItemCalificadoName("Prom  ");//observacion
                        listOrecicleDataInitial.get(47).setPromedio(sumCtegory/8);  //posicon deonde mostramos el promedio


                        //puedo poner si es los promeros 6 keys array //podemos generar un promedio by categorias....

                        float promedioTotalDelInforme= listOrecicleDataInitial.get(indice2).getPromedio()/listPlantsObjects.size(); ///aqui hacemos la operacion
                        listOrecicleDataInitial.get(indice2).setPromedio(promedioTotalDelInforme);

                        Log.i("gerriud","el valor peomedio de este item es "+promedioTotalDelInforme);


                        Log.i("sixdd","el size aqui es "+listOrecicleDataInitial.size());

                        // sellamoUnVEZ=true;
                    }


                }else{


                    Log.i("noContains","no contiene esta data");

                }


                ///aqui iteramos los datos del hasmap..



            }

            ///aqui podemos sumar el promedio


        }

        Log.i("sixdd","el size aqui es ccc "+listOrecicleDataInitial.size());





        listOrecicleDataInitial.get(13).setPromedio(objec.getEnfundeProm() / listPlantsObjects.size() /12 ); // 12 es el numero de items de esta categoria
        listOrecicleDataInitial.get(22).setPromedio(objec.getDeshojeProm() / listPlantsObjects.size() /7 ); // 12 es el numero de items de esta categoria
        ///
        listOrecicleDataInitial.get(29).setPromedio(objec.getApuntalamientoProm() / listPlantsObjects.size() /5 ); // 12 es el numero de items de esta categoria
        listOrecicleDataInitial.get(37).setPromedio(objec.getDeshijeProm() / listPlantsObjects.size() /6 ); // 12 es el numero de items de esta categoria
        listOrecicleDataInitial.get(47).setPromedio(objec.getOtrasLaboresProm() / listPlantsObjects.size() /8 ); // 12 es el numero de items de esta categoria



      //  listOrecicleDataInitial.get(22).setPromedio(sumCtegory/7);



        setDataRecyclerView(listOrecicleDataInitial);

        getPromedioByCategories(listOrecicleDataInitial);


    }


    private void getPromedioByCategories(ArrayList<ResultCaldLabAgricls> listOrecicleDataInitial){
        //promedio del primer value..

        float promedioEnfunde=0;


       Log.i("sjsdhdf","el size aqui es cccxccc "+listOrecicleDataInitial.size());

        for(ResultCaldLabAgricls obje: listOrecicleDataInitial){

            Log.i("sixdd","el promedio es "+obje.getPromedio());


        }

        /*
       for(int indice=0; indice<listOrecicleDataInitial.size(); indice++){

           Log.i("sixdd","el promedio es "+listOrecicleDataInitial.get(indice).getPromedio());

       }

*/


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



       // checkvalue(mireclcierView);


    }

public void checkvalue(){

    Button  buttonOperate=findViewById(R.id.buttonOperate);
    buttonOperate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i = 0; i <mireclcierView.getChildCount(); i++) {

                AdpaterResultCalLabrsAgrcls2.MyViewHolder holder = (AdpaterResultCalLabrsAgrcls2.MyViewHolder) mireclcierView.findViewHolderForAdapterPosition(i);



                if(holder.txtPromedio!=null){
                    Log.i("printer","el value es "+holder.txtPromedio.getText().toString());

                }else{
                    Log.i("printer","es nulo ");


                }



                ///   MyViewHolder holder = (MyViewHolder) rv.findViewHolderForAdapterPosition(i);
                //  holder.sStatus.getSelectedItemId();
            }
        }
    });




}


}