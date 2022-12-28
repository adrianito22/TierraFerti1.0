package com.tiburela.tierrafertil.adapters;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.models.LaboresAgricolsHelper;
import com.tiburela.tierrafertil.models.ResultCaldLabAgricls;

import java.util.ArrayList;
import java.util.HashMap;


public class AdpaterResultCalLabrsAgrcls2 extends RecyclerView.Adapter<AdpaterResultCalLabrsAgrcls2.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;
    DecimalFormat format;
    private static final int LAYOUT_3_VALUES= 0;
    private static final int LAYOUT_TITLE_CATEGORY = 1;
    private static final int LAYOUT_OBSERV_AND_PROM = 2;

    private LayoutInflater inflater;


    ArrayList<ResultCaldLabAgricls> listData;
   // ArrayList<LaboresAgricolsHelper> listNamesCategoriesPERCENTandKeys;




    private Context ctx;

    public AdpaterResultCalLabrsAgrcls2(Context ctx,ArrayList<ResultCaldLabAgricls> listData) {

        inflater = LayoutInflater.from(ctx);
        this.listData = listData;
        this.ctx = ctx;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        MyViewHolder holder=null;



        if(viewType==LAYOUT_3_VALUES)
        {
            view=  inflater.inflate(R.layout.item_3_values, parent, false);
             holder = new MyViewHolder(view);
            view.setOnClickListener(this);

        }



        else if(viewType==LAYOUT_TITLE_CATEGORY)
        {
            view=  inflater.inflate(R.layout.item_title_categoria, parent, false);

            //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two,parent,false);
            holder= new MyViewHolder(view);
            view.setOnClickListener(this);

        }


        else if(viewType==LAYOUT_OBSERV_AND_PROM)
        {
            view=  inflater.inflate(R.layout.item_oservaciones_and_prom, parent, false);

            //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two,parent,false);
            holder= new MyViewHolder(view);
            view.setOnClickListener(this);

        }



        return holder;
    }






    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        if(holder.getItemViewType() == LAYOUT_3_VALUES)
        {

              format = new DecimalFormat("#.##");


              String promDecim=format.format(Float.valueOf(listData.get(position).getPromedio()))   ;


          //  String promDecim=format.format(String.valueOf(listData.get(position).getPromedio()))    ;

            holder. txtNameItem.setText(listData.get(position).getItemCalificadoName());
            holder. txtPromedio.setText(String.valueOf(promDecim));
            holder. txtNumPlntasd.setText(String.valueOf(listData.get(position).getUnmPlantasCalificadas()));


            // Typecast Viewholder
            // Set Viewholder properties
            // Add any click listener if any
        }


        else  if (holder.getItemViewType() == LAYOUT_TITLE_CATEGORY){ //es texto

            holder. txtNameItem.setText(listData.get(position).getItemCalificadoName());

        }



        else  if (holder.getItemViewType() == LAYOUT_OBSERV_AND_PROM){ //es texto

            format = new DecimalFormat("#.##");


            String promDecim=format.format(Float.valueOf(listData.get(position).getPromedio()))   ;




            holder. txtNameItem.setText(listData.get(position).getItemCalificadoName());   //para observaciones

            holder. txtNameItem.setText("PROM: "+promDecim); //para el promedio


        }



    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

   public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtResultCaldLabAgriclsName;
       // private ImageView imageView;
      //  private LinearLayout linearLayout;

        public TextView txtNameItem;
        public TextView txtNumPlntasd;
        public TextView txtPromedio;




        public MyViewHolder(View itemView) {
            super(itemView);


            txtNameItem =  itemView.findViewById(R.id.txtNameItem);
            txtNumPlntasd =  itemView.findViewById(R.id.txtNumPlntasd);
            txtPromedio =  itemView.findViewById(R.id.txtPromedio);


           // imageView =  itemView.findViewById(R.id.imageView);
           // linearLayout =itemView.findViewById(R.id.linearLayout);


           /*
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
*/
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);

        }
    }


    @Override
    public int getItemViewType(int position) {


        if(position ==0 || position ==14 ||  position ==23  ||position ==30  ||position ==38 ){ //le ponemos el nombre

            return LAYOUT_TITLE_CATEGORY;

        }

  //ap es 23 -deshije 30

        else if(position ==13 || position ==22 || position == 29 || position ==37|| position==47 ) {  //OBSERVACION Y PROMEDIO

            return LAYOUT_OBSERV_AND_PROM;


        }else {

            return LAYOUT_3_VALUES;


        }


    }

    public interface ClickListener {
        void onItemClick(int position, View v);


    }
    public void setOnItemClickListener(ClickListener clickListener) {
        AdpaterResultCalLabrsAgrcls2.clickListener = clickListener;


    }





}