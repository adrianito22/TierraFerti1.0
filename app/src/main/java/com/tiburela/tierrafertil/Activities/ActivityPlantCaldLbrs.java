package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterPlant;
import com.tiburela.tierrafertil.dialogs.DialogFragmentx;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityPlantCaldLbrs extends AppCompatActivity {
  ///aquimostramos en un recilcerlos objetos plant...


    RecyclerView mireciclerView;
   int tipoInformCurrent=0;


    ArrayList<Plant>miList= new ArrayList<>();
      Button btnAdnewPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoInformCurrent = extras.getInt(Utils.keyIntentXtraInformsPlant);


            //The key argument here must match that used in the other activity
        }


        ///obtenemos una lista con las plantas...
        //obtenemos la lista.......

       /// opbtenmos plantas que cotneienn esteid...

        miList= (ArrayList<Plant>) SharePref.getListAlLiformsPlants(SharePref.KEY_ALL_PLANTS); //pbtenmos todaslas plantas


        //y mostramos solo las plantas.... de este


        if(miList == null) {

            Log.i("debuggg.","es nulo");
        }else
            Log.i("debuggg.","no es nulo");




        ///PBTENEMOS EL INTENT
        mireciclerView =findViewById(R.id.mirecicler);
        btnAdnewPlant=findViewById(R.id.btnAdnewPlant);
        btnAdnewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deploySheetaddNewPlant();



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

                String nombrePlanta="Planta Num "+miList.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();


                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                    //agregamos un nuevo objeto




                miList.add( new Plant("",nombrePlanta,categoriresVinculadosMap,false));



                //lalamos recicler
                setDataRecyclerView(miList);


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

                String nombrePlanta="Planta Num "+miList.size()+1;

                HashMap<String, String>categoriresVinculadosMap= new HashMap<>();


                for(int indice=0; indice<checkBoxs.length; indice++){

                    if(checkBoxs[indice].isChecked()){
                        categoriresVinculadosMap.put(Utils .arrayWhitkeysMapCategories[indice],Utils .arrayWhitkeysMapCategories[indice]);
                    }
                }


                //agregamos un nuevo objeto

                miList.add( new Plant("",nombrePlanta,categoriresVinculadosMap,false));



                //lalamos recicler
                setDataRecyclerView(miList);


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