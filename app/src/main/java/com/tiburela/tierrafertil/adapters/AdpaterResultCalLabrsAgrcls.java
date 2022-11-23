package com.tiburela.tierrafertil.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.models.LaboresAgricolsHelper;
import com.tiburela.tierrafertil.models.ResultCaldLabAgricls;

import java.util.ArrayList;
import java.util.HashMap;


public class AdpaterResultCalLabrsAgrcls extends RecyclerView.Adapter<AdpaterResultCalLabrsAgrcls.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;



    private LayoutInflater inflater;


    HashMap<String ,ArrayList<ResultCaldLabAgricls> >miMapWhiTitemsToRECILCER;

    ArrayList<ResultCaldLabAgricls> miARRyListItem;
    ArrayList<LaboresAgricolsHelper> listNamesCategoriesPERCENTandKeys;




    TextView [] arrayTextItemName;
    EditText [] arrayEditextNumMats;
    TextView [] arrayTextPercent;


    private Context ctx;

    public AdpaterResultCalLabrsAgrcls(Context ctx, HashMap<String , ArrayList<ResultCaldLabAgricls> >miMapWhiTitemsToRECILCER, ArrayList<LaboresAgricolsHelper> listNamesCategoriesPERCENTandKeys) {
        inflater = LayoutInflater.from(ctx);
        this.miMapWhiTitemsToRECILCER = miMapWhiTitemsToRECILCER;
        this.listNamesCategoriesPERCENTandKeys = listNamesCategoriesPERCENTandKeys;
        this.ctx = ctx;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.enfunde_preview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

     holder.txtTitleSeccion.setText(listNamesCategoriesPERCENTandKeys.get(position).getKeyOFiTEMAndName());
        holder.itemPromedio.setText(listNamesCategoriesPERCENTandKeys.get(position).getPercenttoShow());
        holder.itemObservaciones.setText(listNamesCategoriesPERCENTandKeys.get(position).getObservacionesItem());


        arrayTextItemName = new TextView[12];
        arrayTextItemName[0]=holder.item1;
        arrayTextItemName[1]=holder.item2;
        arrayTextItemName[2]=holder.item3;
        arrayTextItemName[3]=holder.item4;
        arrayTextItemName[4]=holder.item5;
        arrayTextItemName[5]=holder.item6;
        arrayTextItemName[6]=holder.item7;
        arrayTextItemName[7]=holder.item8;
        arrayTextItemName[8]=holder.item9;
        arrayTextItemName[9]=holder.item10;
        arrayTextItemName[10]=holder.item11;
        arrayTextItemName[11]=holder.item12;



        arrayEditextNumMats = new EditText [12];
        arrayEditextNumMats[0]=holder.ediNumMatasEvaluadas1;
        arrayEditextNumMats[1]=holder.ediNumMatasEvaluadas2;
        arrayEditextNumMats[2]=holder.ediNumMatasEvaluadas3;
        arrayEditextNumMats[3]=holder.ediNumMatasEvaluadas4;
        arrayEditextNumMats[4]=holder.ediNumMatasEvaluadas5;
        arrayEditextNumMats[5]=holder.ediNumMatasEvaluadas6;
        arrayEditextNumMats[6]=holder.ediNumMatasEvaluadas7;
        arrayEditextNumMats[7]=holder.ediNumMatasEvaluadas8;
        arrayEditextNumMats[8]=holder.ediNumMatasEvaluadas9;
        arrayEditextNumMats[9]=holder.ediNumMatasEvaluadas10;
        arrayEditextNumMats[10]=holder.ediNumMatasEvaluadas11;
        arrayEditextNumMats[11]=holder.ediNumMatasEvaluadas12;



        arrayTextPercent = new TextView[12];
        arrayTextPercent[0]=holder.item1;
        arrayTextPercent[1]=holder.item2;
        arrayTextPercent[2]=holder.item3;
        arrayTextPercent[3]=holder.item4;
        arrayTextPercent[4]=holder.item5;
        arrayTextPercent[5]=holder.item6;
        arrayTextPercent[6]=holder.item7;
        arrayTextPercent[7]=holder.item8;
        arrayTextPercent[8]=holder.item9;
        arrayTextPercent[9]=holder.item10;
        arrayTextPercent[10]=holder.item11;
        arrayTextPercent[11]=holder.item12;



        //mostramos solo los que contengan data




          //asi obtenemos esta lista...
        miARRyListItem=miMapWhiTitemsToRECILCER.get(listNamesCategoriesPERCENTandKeys.get(position).getKeyOFiTEMAndName());

        muestracategirasSelected(arrayTextItemName,arrayEditextNumMats,arrayTextPercent,miARRyListItem);




     //   holder.txtDataSecond.setText(hda);



    /*

        holder.checkBx.setTag(R.id.posicion,position);
        holder.checkBx.setTag(R.id.idOfoBJECT,listResultCaldLabAgricls.get(position).getUniqueID());

*/


    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return miMapWhiTitemsToRECILCER.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtResultCaldLabAgriclsName;
        private ImageView imageView;
        private LinearLayout linearLayout;

        private TextView txtTitleSeccion, item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,
                item12,itemObservaciones,itemPromedio;


        private  EditText ediNumMatasEvaluadas1, ediNumMatasEvaluadas2,ediNumMatasEvaluadas3,ediNumMatasEvaluadas4,ediNumMatasEvaluadas5,ediNumMatasEvaluadas6,ediNumMatasEvaluadas7,ediNumMatasEvaluadas8,
                ediNumMatasEvaluadas9,ediNumMatasEvaluadas10,ediNumMatasEvaluadas11,ediNumMatasEvaluadas12;



        private TextView txtProm1, txtProm2,txtProm3,txtProm4,txtProm5,txtProm6,txtProm7,txtProm8,
                txtProm9,txtProm10,txtProm11,txtProm12 ;


        public MyViewHolder(View itemView) {
            super(itemView);

            txtTitleSeccion =  itemView.findViewById(R.id.txtTitleSeccion);
            itemObservaciones =  itemView.findViewById(R.id.itemObservaciones);
            itemPromedio =  itemView.findViewById(R.id.itemPromedio);


            item1 =  itemView.findViewById(R.id.item1);
            item2 =  itemView.findViewById(R.id.item2);
            item3 =  itemView.findViewById(R.id.item3);
            item4 =  itemView.findViewById(R.id.item4);
            item5 =  itemView.findViewById(R.id.item5);
            item6 =  itemView.findViewById(R.id.txtItem6);
            item7 =  itemView.findViewById(R.id.txtItem7);
            item8 =  itemView.findViewById(R.id.txtItem8);
            item9 =  itemView.findViewById(R.id.txtItem9);
            item10 =  itemView.findViewById(R.id.txtItem10);
            item11 =  itemView.findViewById(R.id.txtItem11);
            item12 =  itemView.findViewById(R.id.txtItem12);


            ediNumMatasEvaluadas1 =  itemView.findViewById(R.id.ediNumMatasEvaluadas1);
            ediNumMatasEvaluadas2 =  itemView.findViewById(R.id.ediNumMatasEvaluadas2);
            ediNumMatasEvaluadas3 =  itemView.findViewById(R.id.ediNumMatasEvaluadas3);
            ediNumMatasEvaluadas4 =  itemView.findViewById(R.id.ediNumMatasEvaluadas4);
            ediNumMatasEvaluadas5 =  itemView.findViewById(R.id.ediNumMatasEvaluadas5);
            ediNumMatasEvaluadas6 =  itemView.findViewById(R.id.ediNumMatasEvaluadas6);
            ediNumMatasEvaluadas7 =  itemView.findViewById(R.id.ediNumMatasEvaluadas7);
            ediNumMatasEvaluadas8 =  itemView.findViewById(R.id.ediNumMatasEvaluadas8);
            ediNumMatasEvaluadas9 =  itemView.findViewById(R.id.ediNumMatasEvaluadas9);
            ediNumMatasEvaluadas10 =  itemView.findViewById(R.id.ediNumMatasEvaluadas10);
            ediNumMatasEvaluadas11 =  itemView.findViewById(R.id.ediNumMatasEvaluadas11);
            ediNumMatasEvaluadas12 =  itemView.findViewById(R.id.ediNumMatasEvaluadas12);



            txtProm1 =  itemView.findViewById(R.id.txtProm1);
            txtProm2 =  itemView.findViewById(R.id.txtProm2);
            txtProm3 =  itemView.findViewById(R.id.txtProm3);
            txtProm4 =  itemView.findViewById(R.id.txtProm4);
            txtProm5 =  itemView.findViewById(R.id.txtProm5);
            txtProm6 =  itemView.findViewById(R.id.txtProm6);
            txtProm7 =  itemView.findViewById(R.id.txtProm7);
            txtProm8 =  itemView.findViewById(R.id.txtProm8);
            txtProm9 =  itemView.findViewById(R.id.txtProm9);
            txtProm10 =  itemView.findViewById(R.id.txtProm10);
            txtProm11 =  itemView.findViewById(R.id.txtProm11);
            txtProm12 =  itemView.findViewById(R.id.txtProm12);



            imageView =  itemView.findViewById(R.id.imageView);
            linearLayout =itemView.findViewById(R.id.linearLayout);

            linearLayout.findViewById(R.id.linearLayout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.onItemClick(getAdapterPosition(), v);

                }
            });



            imageView.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.onItemClick(getAdapterPosition(), v);

                }
            });

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);

        }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);


    }
    public void setOnItemClickListener(ClickListener clickListener) {
        AdpaterResultCalLabrsAgrcls.clickListener = clickListener;


    }




    private void muestracategirasSelected(TextView [] arrayTxtNames,EditText [] arrayTxtNumMatas,TextView [] arraytxtPercent, ArrayList<ResultCaldLabAgricls>lisItem){


        //si existe este en el hasmap
        //el arary texview y los keys deberian estar en la misma posicion cada uno de ellos..

        for(int indice=0; indice< lisItem.size(); indice++){

            ///mostramos data y la colocamos...

            arrayTxtNames[indice].setVisibility(View.VISIBLE);
            arrayTxtNames[indice].setText(lisItem.get(indice).getItemCalificadoName());


            arrayTxtNumMatas[indice].setVisibility(View.VISIBLE);
            arrayTxtNumMatas[indice].setText(String.valueOf(lisItem.get(indice).getItemCalificadoName()) );

            arraytxtPercent[indice].setVisibility(View.VISIBLE);
            arraytxtPercent[indice].setText(String.valueOf(lisItem.get(indice).getItemCalificadoName()));



        }





    }

}