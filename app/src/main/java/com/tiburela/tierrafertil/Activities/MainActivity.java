package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.adapters.AdapterPlant;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView mireciclerView;

    ArrayList<Plant>miList= new ArrayList<>();
      Button btnAdnewPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        AdapterPlant adapter = new AdapterPlant(MainActivity.this, list);
        //  this.adapter.setPlayPauseClickListener(this);
        mireciclerView.setLayoutManager(layoutManager);
        mireciclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterPlant.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {


              //  deploySheetaddNewPlant();


            }
        });




    }


    private void deploySheetaddNewPlant(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
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

                  miList.add( new Plant("","",nombrePlanta,categoriresVinculadosMap));



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