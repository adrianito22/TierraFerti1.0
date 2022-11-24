package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterAllinforms;
import com.tiburela.tierrafertil.dialogs.DialogFragmentx;
import com.tiburela.tierrafertil.models.AllFormsModel;
import com.tiburela.tierrafertil.utils.Typeinforms;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityAllinformsCreates extends AppCompatActivity {
/**aqui tcragremos todos los informes creados que estan en share y en la base de dastos...*/


RecyclerView recylerVInformsAll;
int tipoInformCurrent =0;
ArrayList<AllFormsModel> lisInformFiltered;
    ArrayList<AllFormsModel> allInformsShareList;

    Map<String,AllFormsModel> mapAllInformsPrferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allinforms_creates);

        recylerVInformsAll=findViewById(R.id.recylerVInformsAll);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tipoInformCurrent = extras.getInt(Utils.keyIntentXtraAllinforms);
            //The key argument here must match that used in the other activity
        }

    }

    @Override
    protected void onStart() {
        super.onStart();


        SharePref.init(ActivityAllinformsCreates.this);

        //recuperamos el mapa  con informes allainform de perefrencias

        Map<String, AllFormsModel> mapaOfPREFERENces= SharePref.loadMapPreferencesDataOfFields(SharePref.KEY_AllINFORMS_SHAREP);


        //convertimos mapa en arra list
        allInformsShareList= Utils.arraListByHASMPAAllForms(mapaOfPREFERENces);




        if(tipoInformCurrent == Typeinforms.ALL_INFORMS ){  //ES TODOSD LOS INFORMES
            setDataRecyclerView((allInformsShareList));
        }



        else
        {     //filtramos la lista


            lisInformFiltered = (ArrayList<AllFormsModel>) generateListByEspecificType(allInformsShareList);

            setDataRecyclerView(( lisInformFiltered));

        }





         //aquio chekear el tipo de informe...









        mapAllInformsPrferences = SharePref.loadMapPreferencesDataOfFields(SharePref.KEY_AllINFORMS_SHAREP);


        TextView txtAdvisser = findViewById(R.id.txtAdvisser);

        if(mapAllInformsPrferences.size() ==0) {
            Log.i("lashareperf","el size es 0");

            txtAdvisser.setVisibility(View.VISIBLE);
            return;

        }



        Log.i("lashareperf","el tipo informe es  "+ tipoInformCurrent);

        allInformsShareList=mapToArrayList(mapAllInformsPrferences);

        if(tipoInformCurrent == Typeinforms.ALL_INFORMS ){  //ES TODOSD LOS INFORMES


            setDataRecyclerView((allInformsShareList));


        }

        else{

            lisInformFiltered = (ArrayList<AllFormsModel>) generateListByEspecificType(allInformsShareList);

            setDataRecyclerView(( lisInformFiltered));

        }
    }






    private void setDataRecyclerView(ArrayList<AllFormsModel> list){


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ActivityAllinformsCreates.this);
        AdapterAllinforms adapter = new AdapterAllinforms(ActivityAllinformsCreates.this, list);
        recylerVInformsAll.setLayoutManager(layoutManager);
        recylerVInformsAll.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterAllinforms.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                //abrimos dialog

                //aqui inicilizamos el informe...



                // String keySharePrefrencesItemClicked=v.getTag().toString();


                sheetBootomInforOptions(v.getTag().toString());


                Log.i("elcickler","el click es llamado");




            }
        });




    }



    private  List<AllFormsModel> generateListByEspecificType( List<AllFormsModel> listPreferencesAllinforms){

        List<AllFormsModel> listPreferencesAllinformsX =new ArrayList<>();


            for(AllFormsModel object : listPreferencesAllinforms) {

                    if(object.getTipoFormPertenece() == tipoInformCurrent){

                        listPreferencesAllinformsX.add(object);
                    }
                   // listPreferencesAllinformsX.add(object);





        }






      return  listPreferencesAllinformsX  ;

}


    private void sheetBootomInforOptions(String idSelectedItem){


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityAllinformsCreates.this);

        bottomSheetDialog.setContentView(R.layout.bottom_sheet_options_infromsx);



        Button btnAbrir=bottomSheetDialog.findViewById(R.id.btnAbrir);
        Button btnEliminar=bottomSheetDialog.findViewById(R.id.btnEliminar);

        //ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);
        //8  bottomSheetDialog.setCancelable(false);


        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /**abrimos el informe dpeendiendo del tipo de informe */

                //aqui recuperamos el id ...del informe...
                //intent...//aqui abrimos dialog.... y le pasamos un intent...

                Log.i("elcickler","el click es llamadoen sheet");


                 //CHEKEAMOS ELK TIPO DE INFORMEÇ
                if(tipoInformCurrent ==Typeinforms.CALIDAD_LABRES_AGRICOLAS) {
                    Intent intent = new Intent(ActivityAllinformsCreates.this,ActivityPlantCaldLbrs.class);


                    intent.putExtra(Utils.keyIntentXtraInformsPlant,Typeinforms.PLANT_SET);
                    intent.putExtra(SharePref.keyIntent,idSelectedItem); //aqui le pasamoe el id del form all forms

                    startActivity(intent);




                }


                else if(tipoInformCurrent ==Typeinforms.INFORM_FITOSANITARIO) {


                    Intent intent = new Intent(ActivityAllinformsCreates.this,ActivityDiagnFitoSanitario.class);
                 //   intent.putExtra(Utils.keyIntentXtraInformsPlant,Typeinforms.PLANT_SET);
                    intent.putExtra(SharePref.keyIntent,idSelectedItem); //aqui le pasamoe el id del form all forms


                    startActivity(intent);

                }








/*
                FragmentManager fm = getSupportFragmentManager();
                DialogFragmentx dialog = new DialogFragmentx();

                Bundle bundle = new Bundle();
                bundle.putString(Utils.keyDialogBundle,);
                dialog.setArguments(bundle);


                dialog.show(getSupportFragmentManager(),"My  FragmentDIalog");

                //  deploySheetaddNewPlant();

*/




//lkjl

                     ///aqui deberiamos  obtenr el id del hashmmap plantss

                /*

                FragmentManager fm = getSupportFragmentManager();
                DialogFragmentx dialog = new DialogFragmentx();

                Bundle bundle = new Bundle();
                bundle.putString(Utils.keyDialogBundle,idSelectedItem);
                dialog.setArguments(bundle);

                dialog.show(getSupportFragmentManager(),"My  FragmentDIalog");

*/


                //
                bottomSheetDialog.dismiss();


            }
        });



        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sheetBootomSureDeleteQuestion(idSelectedItem);

                bottomSheetDialog.dismiss();


            }
        });




        bottomSheetDialog.show();

    }

    private void sheetBootomSureDeleteQuestion(String idSelectedItem){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityAllinformsCreates.this);

        bottomSheetDialog.setContentView(R.layout.bottom_sheet_sure_delete);

        Button btnSiElimnar=bottomSheetDialog.findViewById(R.id.btnSiElimnar);
        Button btnNoElimnar=bottomSheetDialog.findViewById(R.id.btnNoElimnar);

        //ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);
        //8  bottomSheetDialog.setCancelable(false);


        btnSiElimnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ActivityAllinformsCreates.this, "borramos el id "+idSelectedItem, Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();


            }
        });



        btnNoElimnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog.dismiss();


            }
        });




        bottomSheetDialog.show();

    }




    private  ArrayList<AllFormsModel> mapToArrayList( Map<String,AllFormsModel> hasmap){

        ArrayList<AllFormsModel> listPreferencesAllinformsX =new ArrayList<AllFormsModel>();


        listPreferencesAllinformsX.addAll(hasmap.values());




        return  listPreferencesAllinformsX  ;

    }

}