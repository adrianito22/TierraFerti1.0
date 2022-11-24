package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterPlant;
import com.tiburela.tierrafertil.dialogs.DialogFragmentx;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.utils.Typeinforms;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActivityPlantCaldLbrs extends AppCompatActivity {
  ///aquimostramos en un recilcerlos objetos plant...

     GridLayout gridLayout;
    TextView txtDtsGenrales;
    LinearLayout layotl1;
    LinearLayout  layotl2;





    RecyclerView mireciclerView;
   int tipoInformCurrent=0;
   String keySharePrefeItem="";


   Button btnSaveAndCalc;


    Map<String,Plant> mapPlants = new HashMap<>();
      ImageView btnAdnewPlant;


      ArrayList<Plant>milist= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            tipoInformCurrent = extras.getInt(Utils.keyIntentXtraInformsPlant);
            keySharePrefeItem = extras.getString(SharePref.keyIntent);



            //The key argument here must match that used in the other activity
        }





        ///obtenemos una lista con las plantas...
        //obtenemos la lista.......

       /// opbtenmos plantas que cotneienn esteid...
        mireciclerView =findViewById(R.id.mirecicler);
        btnSaveAndCalc=findViewById(R.id.btnSaveAndCalc);


        gridLayout=findViewById(R.id.gridLayout);
        txtDtsGenrales=findViewById(R.id.txtDtsGenrales);
        layotl1=findViewById(R.id.layotl1);
        layotl2=findViewById(R.id.layotl2);

        txtDtsGenrales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gridLayout.getVisibility()==View.VISIBLE) {

                    gridLayout.setVisibility(View.GONE);

                    layotl1.setVisibility(View.GONE);
                    layotl2.setVisibility(View.GONE);

                }else{

                    gridLayout.setVisibility(View.VISIBLE);

                    layotl1.setVisibility(View.VISIBLE);
                    layotl2.setVisibility(View.VISIBLE);
                }



            }
        });




        SharePref.init(ActivityPlantCaldLbrs.this);
        mapPlants =  SharePref.getMapOfPlantsObjects(keySharePrefeItem); /////aqui le pasmas el key del objeto all forms  que se eleciono anteriormente


        //y mostramos solo las plantas.... de este


        if(mapPlants != null) {

            milist=Utils.arraListByHASMPA(mapPlants);

            setDataRecyclerView(milist);

            ///llamaos recicler


            Log.i("debuggg.","no es nuelo");
        }else
        {
              ///si tinee data lo ponemos en el recicler...

            Log.i("debuggg.","es nulo");


        }




        btnAdnewPlant=findViewById(R.id.btnAdnewPlant);
        btnAdnewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deploySheetaddNewPlant();



            }
        });

        btnSaveAndCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intencion= new Intent(ActivityPlantCaldLbrs.this, ActivityResultCtrLabr.class);
                intencion.putExtra(Utils.keyextraGLObal,keySharePrefeItem);
                startActivity(intencion);




                //deploySheetaddNewPlant();



            }
        });



    }




    private void setDataRecyclerView(ArrayList<Plant>list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityPlantCaldLbrs.this);
        AdapterPlant adapter = new AdapterPlant(ActivityPlantCaldLbrs.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireciclerView.setLayoutManager(layoutManager);
        mireciclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterPlant.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {


             //abrimos dialog

                Log.i("elcicklerxdff","el click es llamado aqui ...");




                FragmentManager fm = getSupportFragmentManager();
                DialogFragmentx dialog = new DialogFragmentx();


                Bundle bundle = new Bundle();
                bundle.putString(Utils.keyDialogBundle,v.getTag().toString());
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(),"My  FragmentDIalog");

              //  deploySheetaddNewPlant();




            }
        });




    }


    private void deploySheetaddNewPlant(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityPlantCaldLbrs.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ver_atachx);

        CheckBox checkBox1=bottomSheetDialog.findViewById(R.id.checkBox1);
        CheckBox checkBox2=bottomSheetDialog.findViewById(R.id.checkBox2);
        CheckBox checkBox3=bottomSheetDialog.findViewById(R.id.checkBox3);
        CheckBox checkBox4=bottomSheetDialog.findViewById(R.id.checkBox4);
        CheckBox checkBox5=bottomSheetDialog.findViewById(R.id.checkBox5);

        Button btnActualizar=bottomSheetDialog.findViewById(R.id.btnActualizar);
        ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);



        bottomSheetDialog.setCancelable(false);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox [] checkBoxs={checkBox1,checkBox2,checkBox3,checkBox4,checkBox5};

             //confirguramos el nuevo objeto

                String nombrePlanta="Planta Num "+ mapPlants.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();


                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                    //agregamos un nuevo objeto



               Plant plantObject=new Plant("","",categoriresVinculadosMap,false);
                mapPlants.put(UUID.randomUUID().toString(),plantObject);
                 milist.add(plantObject);


                 //guardamos nuevo objeto planta en hasmap

                  SharePref.saveHashMapOfHashmapWhitPlatsObject(mapPlants,keySharePrefeItem);


                //lalamos recicler
                setDataRecyclerView(milist);





                bottomSheetDialog.dismiss();


            }
        });



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.dismiss();


            }
        });
        bottomSheetDialog.show();

    }



    private void createSet(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityPlantCaldLbrs.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ver_atachx);

        CheckBox checkBox1=bottomSheetDialog.findViewById(R.id.checkBox1);
        CheckBox checkBox2=bottomSheetDialog.findViewById(R.id.checkBox2);
        CheckBox checkBox3=bottomSheetDialog.findViewById(R.id.checkBox3);
        CheckBox checkBox4=bottomSheetDialog.findViewById(R.id.checkBox4);
        CheckBox checkBox5=bottomSheetDialog.findViewById(R.id.checkBox5);

        Button btnActualizar=bottomSheetDialog.findViewById(R.id.btnActualizar);
        ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);



        bottomSheetDialog.setCancelable(false);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckBox [] checkBoxs={checkBox1,checkBox2,checkBox3,checkBox4,checkBox5};

                //confirguramos el nuevo objeto

                String nombrePlanta="Planta Num "+ mapPlants.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();


                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                //agregamos un nuevo objeto

             //   mapPlants.add( new Plant("",nombrePlanta,categoriresVinculadosMap,false));



                //lalamos recicler
              //  setDataRecyclerView(mapPlants);


                bottomSheetDialog.dismiss();


            }
        });



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.dismiss();


            }
        });
        bottomSheetDialog.show();

    }


}