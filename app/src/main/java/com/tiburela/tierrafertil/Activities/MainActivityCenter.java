package com.tiburela.tierrafertil.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.SharePref.SharePref;
import com.tiburela.tierrafertil.adapters.AdapterAllinforms;
import com.tiburela.tierrafertil.adapters.AdapterProductor;
import com.tiburela.tierrafertil.database.RealtimDatabase;
import com.tiburela.tierrafertil.models.AllFormsModel;
import com.tiburela.tierrafertil.models.ProductorTierraFertil;
import com.tiburela.tierrafertil.utils.Typeinforms;
import com.tiburela.tierrafertil.utils.Utils;
import com.tiburela.tierrafertil.utils.Variables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainActivityCenter extends AppCompatActivity {

    LinearLayout layCalidLabresAgriocolas;
    LinearLayout layDiagnotiscoFitosa;
    LinearLayout layMisInformes;
    LinearLayout layMisICalendarios;

     RecyclerView miReciclerAllOptions;
    EditText ediNombreProductor;


     ArrayList<ProductorTierraFertil> allProductoresList = new ArrayList<>();
    ArrayList<ProductorTierraFertil>listFiltered= new ArrayList<>();



    int tipoInformeSelecionado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_center);


         layCalidLabresAgriocolas=findViewById(R.id.layCalidLabresAgriocolas);
         layDiagnotiscoFitosa=findViewById(R.id.layDiagnotiscoFitosa);

        layMisInformes=findViewById(R.id.layMisInformes);
      layMisICalendarios =findViewById(R.id.layMisICalendarios);

        eventosBtn();

        getAllUser(false,0);


    }

    private void eventosBtn() {

        layCalidLabresAgriocolas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intencion = new Intent(MainActivityCenter.this, ActivityPlantCaldLbrs.class );

                tipoInformeSelecionado=Typeinforms.CALIDAD_LABRES_AGRICOLAS;
                sheetOptionsForm(intencion,tipoInformeSelecionado);

            }
        });


        layDiagnotiscoFitosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipoInformeSelecionado=Typeinforms.INFORM_FITOSANITARIO;

                Intent intencion = new Intent(MainActivityCenter.this,ActivityDiagnFitoSanitario.class );

                 sheetOptionsForm(intencion,tipoInformeSelecionado);



            }
        });


        layMisInformes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipoInformeSelecionado=Typeinforms.ALL_INFORMS;



                Intent intencion = new Intent(MainActivityCenter.this,ActivityAllinformsCreates.class );



                intencion.putExtra(Utils.keyIntentXtraAllinforms,Typeinforms.ALL_INFORMS);
                startActivity(intencion);


              //  sheetOptionsForm(intencion,tipoInformeSelecionado);



            }
        });


        layMisICalendarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              ///  tipoInformeSelecionado=Typeinforms.ALL_INFORMS;

                Intent intencion = new Intent(MainActivityCenter.this,ActivityMisCalendarios.class );


               // intencion.putExtra(Utils.keyIntentXtraAllinforms,Typeinforms.ALL_INFORMS);
                startActivity(intencion);


                //  sheetOptionsForm(intencion,tipoInformeSelecionado);



            }
        });



    }


    private void sheetOptionsForm(Intent intencion,int typeInform){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivityCenter.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_options);


        Button btnAddNewinform=bottomSheetDialog.findViewById(R.id.btnAddNewinform);

        Button btnVerInforms=bottomSheetDialog.findViewById(R.id.btnVerInforms);


       // ImageView imgClose=bottomSheetDialog.findViewById(R.id.imgClose);
      //  bottomSheetDialog.setCancelable(false);


        btnVerInforms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(typeInform ==Typeinforms.INFORM_FITOSANITARIO){

                    Intent intencion = new Intent(MainActivityCenter.this,ActivityAllinformsCreates.class);
                  //  Intent intencion = new Intent(MainActivityCenter.this,ActivityDiagnFitoSanitario.class);
                    intencion.putExtra(Utils.keyIntentXtraAllinforms, typeInform);
                    startActivity(intencion);

                }


               else  if(typeInform ==Typeinforms.CALIDAD_LABRES_AGRICOLAS){

                    Intent intencion = new Intent(MainActivityCenter.this,ActivityAllinformsCreates.class);
                    intencion.putExtra(Utils.keyIntentXtraAllinforms, typeInform);
                    startActivity(intencion);

                }




                bottomSheetDialog.dismiss();


            }
        });



        btnAddNewinform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**aqui agregamos el tipo de informe que queremos agregar por ahorasoloagudaremos uno  INFORM_FITOSANITARIO*/


                //obtenmos de prefeencias
                Variables.allProductores= (ArrayList<ProductorTierraFertil>) SharePref.loadMapPreferencesProductorTierraF(SharePref.kEYPRODUCTOR_TIERRA_FERTIL);
                 //descragamos la lista con todos nombre de productores...
                if(Variables.allProductores.size()==0){ //si la lista no esta descargada
                    getAllUser(true,typeInform);

                }
                else{

                    try {
                        sheetBootomInformNew(typeInform);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }



                //  startActivity(intencion);
                bottomSheetDialog.dismiss();


            }
        });




        bottomSheetDialog.show();

    }


    private void sheetBootomInformNew(int informType) throws IOException {


        if(!chekIfUserHaveInternetOrExistMapPreferences()){
            Toast.makeText(this, "  No tienes conexion a internet", Toast.LENGTH_SHORT).show();
            return;
        }


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivityCenter.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_data_inform);


        EditText ediData2=bottomSheetDialog.findViewById(R.id.ediData2);
        EditText ediData1=bottomSheetDialog.findViewById(R.id.ediData1);
         ediNombreProductor=bottomSheetDialog.findViewById(R.id.ediNombreProductor);
        miReciclerAllOptions=bottomSheetDialog.findViewById(R.id.miReciclerAllOptions);
        Button btnCreateInform=bottomSheetDialog.findViewById(R.id.btnCreateInform);

        textWatcher();





        btnCreateInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nota="";

                if(ediData1.getText().toString().trim().isEmpty()  ) {
                    ediData1.requestFocus();
                    ediData1.setError("Este valor no pued estar vacio");
                     return;
                }


                if(! ediData2.getText().toString().trim().isEmpty() ) {

                    nota=ediData2.getText().toString();

                }


                if(ediNombreProductor.getText().toString().trim().isEmpty()  || Variables.currentProductorBJECt==null) {
                    ediNombreProductor.requestFocus();
                    ediNombreProductor.setError("No has selecionado un productor");
                    return;
                }




                SharePref.init(MainActivityCenter.this);

                String nmameCategory ;
                nmameCategory=generateNameStringById(informType);

                //creamos el objeto
                AllFormsModel object=new AllFormsModel(ediData1.getText().toString(),informType,nota,nmameCategory,Variables.currentProductorBJECt.getCodigo());


                //obtebnemos el mapa
                Map<String, AllFormsModel> mapaOfPREFERENces= SharePref.loadMapPreferencesDataOfFields(SharePref.KEY_AllINFORMS_SHAREP);

                mapaOfPREFERENces.put(object.getUniqueIDkeyInformAndKeYSharePref(),object);

                SharePref.saveMapAlLINFORMS(mapaOfPREFERENces,SharePref.KEY_AllINFORMS_SHAREP);

                //empezamos intencion
                //decide a donde ir


                Toast.makeText(MainActivityCenter.this, "INFORME GUARDADO", Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();


            }
        });





        bottomSheetDialog.show();

    }


    private String generateNameStringById(int informType){
        String categoria  ="";

        if(informType ==Typeinforms.CALIDAD_LABRES_AGRICOLAS){
            categoria="Lbrs Agricolas";


        }

        else if(informType ==Typeinforms.INFORM_FITOSANITARIO){
            categoria="Fitosanitario";

        }


        return categoria;
    }



    private void decideIRActivity(int informType){
        if(informType ==Typeinforms.CALIDAD_LABRES_AGRICOLAS){

           Intent intencion = new Intent(MainActivityCenter.this, ActivityPlantCaldLbrs.class);

            intencion.putExtra(Utils.KEY_INTEN_LABORES_AGROICOLAS,123);
            startActivity(intencion);

        }

        else if(informType ==Typeinforms.INFORM_FITOSANITARIO){


        }

    }



    //descrgamos la lista de productores allProductores



    private void dowloadAllProductoresList(){
        //cuando descragemos,,, mostramos la opcion de automcompletar...



    }

    private void textWatcher(  ) {

        ediNombreProductor.addTextChangedListener(new TextWatcher() {
            private boolean ignorar = false;
            private long ultimaCorrida = -1;
            private String textoOriginal="";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Log.i("comisaria","el size en before text es "+ i2);
                // Log.i("comisaria","el size  en ontexttext es "+edt_search.getText().toString().length() );

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



               // Log.i("comisaria","el size  en ontexttext es "+edt_search.getText().toString().length() );
                Log.i("comisaria","llamamos " );

               // addDataReciclerAndShowOptions(redondeadoTotalCreate);


                listFiltered.clear();
                listFiltered= new ArrayList<>();

                for(int index = 0; index< allProductoresList.size(); index++) {

                        //  String textSearch=charSequence.toString().toUpperCase(Locale.ROOT);

                    if( charSequence.toString().isEmpty() || allProductoresList.get(index).getNombre().contains(charSequence.toString().toUpperCase()))
                    {

                        listFiltered.add(allProductoresList.get(index));

                        Log.i("comisaria","llamamos el size de lista es "+listFiltered.size() );


                        addDataReciclerAndShowOptions(listFiltered);

                    }



                    //llaamos a crear recilcer nuevamente todos

            }

                if(listFiltered.size()==0){

                    addDataReciclerAndShowOptions(listFiltered);

                }




            }

            @Override
            public void afterTextChanged(Editable s) {
                //  Log.i("comisaria","el size  en affter es "+edt_search.getText().toString().length() );


            }

        });

    }


    private void addDataReciclerAndShowOptions(ArrayList<ProductorTierraFertil> listProductores) {

        //createData(numeroListCrear);
        miReciclerAllOptions.setVisibility(View.VISIBLE);


        miReciclerAllOptions.setHasFixedSize(true);

        AdapterProductor adapter = new AdapterProductor(MainActivityCenter.this, listProductores);

        miReciclerAllOptions.setLayoutManager(new LinearLayoutManager(MainActivityCenter.this, LinearLayoutManager.VERTICAL, false));

        miReciclerAllOptions.setAdapter(adapter);


        adapter.setOnItemClickListener(new AdapterProductor.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {


                Variables.currentProductorBJECt=listProductores.get(position);

                 /***aqui obtenemos el objeto global*/

                 ediNombreProductor.setText(Variables.currentProductorBJECt.getNombre());

                miReciclerAllOptions.setVisibility(View.GONE);

                Log.i("elcickler","el nombre del productor es "+Variables.currentProductorBJECt.getNombre());
                Log.i("elcickler","el nombre del CODIGO DE PRODUCTOR ES  es "+Variables.currentProductorBJECt.getCodigo());




            }
        });


    }


    private void getAllUser(boolean isCreateNewReport, int tipeInfomrOptional){

        allProductoresList = new ArrayList<>();

        Variables.allProductores=new ArrayList<>();

        RealtimDatabase.initDatabasesRootOnly();
        DatabaseReference usersdRef = RealtimDatabase.rootDatabaseReference.child("Productores").child("todosLosProductores");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                   ProductorTierraFertil  user=ds.getValue(ProductorTierraFertil.class);

                    Log.i("misdata","la data es "+user.getNombre());
                    //  array.add(name);

                    allProductoresList.add(user);

                }


                Variables.allProductores=allProductoresList;
                SharePref.saveMapProductorTierrFertil((Map<String, ProductorTierraFertil>) Variables.allProductores,SharePref.kEYPRODUCTOR_TIERRA_FERTIL);


                if(isCreateNewReport && allProductoresList.size()>0){

                    try {
                        sheetBootomInformNew(tipeInfomrOptional);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ///

                }


                /**ojo por aqui puede haber un posible bug.. en caso que aun no tengamos data en nuestro array list principal*/
                ///aqui ya podemos activar........

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        usersdRef.addListenerForSingleValueEvent(eventListener);
    }



    private boolean chekIfUserHaveInternetOrExistMapPreferences() throws IOException {
             boolean isReady;

        Map<String,ProductorTierraFertil>miMap= SharePref.loadMapPreferencesProductorTierraF(SharePref.kEYPRODUCTOR_TIERRA_FERTIL);

        if(miMap.size()==0){
            Log.i("mapadd","es un mapa vacio");
            isReady=false;
        }else{
            Log.i("mapadd","este mapa tiene data hurra ");
            isReady=true;

        }


        if(isReady){
            return true;
        }


        if(Utils.isReachable("http://www.google.com/")){
            Log.i("mapadd","bien hay conexion internet ");
            return true;

        }

        else

        {
            Log.i("mapadd","No hay conexion internet ");

            return false;


        }



        ///1.el usuario tiene que tener conexion internet
        //.2.tiene que haber una lista de prefrencias...

        //4. si el user no tiene un map en prefrencias y tampoco tiene conexion a internet ,entonces no puede..
        //5. si no tiene prefrencias ,tiene conexion a intenert , pero no se le descrga la lista por algun motivo tampoco pued...


    }


}