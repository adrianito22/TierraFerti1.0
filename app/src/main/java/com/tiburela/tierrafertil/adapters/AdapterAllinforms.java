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
import com.tiburela.tierrafertil.models.AllFormsModel;

import java.util.ArrayList;


public class AdapterAllinforms extends RecyclerView.Adapter<AdapterAllinforms.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;

    private LayoutInflater inflater;
    public static ArrayList<AllFormsModel> listAllFormsModel;


    private Context ctx;

    public AdapterAllinforms(Context ctx, ArrayList<AllFormsModel> listAllFormsModel) {

        inflater = LayoutInflater.from(ctx);
        this.listAllFormsModel = listAllFormsModel;
        this.ctx = ctx;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.all_inform_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {



        holder.txtNameInform.setText(listAllFormsModel.get(position).getName());
        holder.txtInformDate.setText(listAllFormsModel.get(position).getDateCreate());
        holder.txtCategory.setText(listAllFormsModel.get(position).getCategoryText());

        holder.linearLayout.setTag(R.id.tagUniqueId1,listAllFormsModel.get(position).getUniqueIDkeyInformAndKeYSharePref());
        holder. linearLayout.setTag(R.id.tagUniqueId2,listAllFormsModel.get(position).getExtraDataAllFormUniqIdKey());



    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return listAllFormsModel.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtNameInform;
        private TextView txtInformDate;
        private TextView txtCategory;


        private ImageView imageView;
        private LinearLayout linearLayout;



        public MyViewHolder(View itemView) {
            super(itemView);

            txtNameInform =  itemView.findViewById(R.id.txtDateRange);
            txtInformDate =  itemView.findViewById(R.id.txtInformDate);
            txtCategory  =  itemView.findViewById(R.id.txtNUmSeman);

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
        AdapterAllinforms.clickListener = clickListener;


    }





}