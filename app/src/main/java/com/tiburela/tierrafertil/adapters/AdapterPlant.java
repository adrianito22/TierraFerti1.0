package com.tiburela.tierrafertil.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.models.Plant;
import com.tiburela.tierrafertil.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;


public class AdapterPlant extends RecyclerView.Adapter<AdapterPlant.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;



    private LayoutInflater inflater;
    public static ArrayList<Plant> listPlant;
    public static ArrayList<String> idsFormsControlCalidVinculados;

    public static String idsFormsVinucladosCntres;
    public static HashMap<String,String>idOFfORMScontrolCaldVds;
    TextView [] arrayTextview;

    private Context ctx;

    public AdapterPlant(Context ctx, ArrayList<Plant> listPlant) {

        inflater = LayoutInflater.from(ctx);
        this.listPlant = listPlant;
        this.ctx = ctx;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.layout_cald_lab_agricols, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

       holder.linearLayout.setTag(listPlant.get(position).getUniqueIdPlantAndKeyShare());


     holder.txtPlantName.setText(listPlant.get(position).getNameItem());

        arrayTextview= new TextView[5];
        arrayTextview[0]=holder.item1;
        arrayTextview[1]=holder.item2;
        arrayTextview[2]=holder.item3;
        arrayTextview[3]=holder.item4;
        arrayTextview[4]=holder.item5;


        muestracategirasSelected(arrayTextview,listPlant.get(position).getHashMapCategiresMapsEvaluadas(), Utils.arrayWhitkeysMapCategories);



     //   holder.txtDataSecond.setText(hda);



    /*

        holder.checkBx.setTag(R.id.posicion,position);
        holder.checkBx.setTag(R.id.idOfoBJECT,listPlant.get(position).getUniqueID());

*/


    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return listPlant.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtPlantName;
        private ImageView imageView;
        private LinearLayout linearLayout;

        private TextView item1,item2,item3,item4,item5;


        public MyViewHolder(View itemView) {
            super(itemView);

            txtPlantName =  itemView.findViewById(R.id.txtPlantName);

            item1 =  itemView.findViewById(R.id.item1);
            item2 =  itemView.findViewById(R.id.item2);
            item3 =  itemView.findViewById(R.id.item3);
            item4 =  itemView.findViewById(R.id.item4);
            item5 =  itemView.findViewById(R.id.item5);

            imageView =  itemView.findViewById(R.id.imageView);
            linearLayout =itemView.findViewById(R.id.linearLayout);

            linearLayout.findViewById(R.id.linearLayout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.onItemClick(getAdapterPosition(), v);

                }
            });


/*
            imageView.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.onItemClick(getAdapterPosition(), v);

                }
            });


           */

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
        AdapterPlant.clickListener = clickListener;


    }




    private void muestracategirasSelected(TextView [] arrayTextview,HashMap<String, String> hashMapCategories,String [] allKeysCategories){


        //si existe este en el hasmap
        //el arary texview y los keys deberian estar en la misma posicion cada uno de ellos..

        for(int indice=0; indice< allKeysCategories.length; indice++){

            String categiresSelected=allKeysCategories[indice];

            if(hashMapCategories.containsKey(categiresSelected)){  //si contiene esa key

                arrayTextview[indice].setVisibility(TextView.VISIBLE);
            }

        }





    }

}