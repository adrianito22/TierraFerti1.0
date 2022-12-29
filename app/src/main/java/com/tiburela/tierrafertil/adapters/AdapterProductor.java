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
import com.tiburela.tierrafertil.models.ProductorTierraFertil;

import java.util.ArrayList;


public class AdapterProductor extends RecyclerView.Adapter<AdapterProductor.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;

    private LayoutInflater inflater;
    public static ArrayList<ProductorTierraFertil> listProductorTierraFertil;


    private Context ctx;

    public AdapterProductor(Context ctx, ArrayList<ProductorTierraFertil> listProductorTierraFertil) {

        inflater = LayoutInflater.from(ctx);
        this.listProductorTierraFertil = listProductorTierraFertil;
        this.ctx = ctx;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_productor, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {



        holder.txtTCodigo.setText(listProductorTierraFertil.get(position).getCodigo());
        holder.txtTnombre.setText(listProductorTierraFertil.get(position).getNombre());

      //  holder. linearLayout.setTag(R.id.tagUniqueId2,listProductorTierraFertil.get(position).getExtraDataAllFormUniqIdKey());



    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return listProductorTierraFertil.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTCodigo;
        private TextView txtTnombre;
        private LinearLayout linearLayout;



        public MyViewHolder(View itemView) {
            super(itemView);

            txtTCodigo =  itemView.findViewById(R.id.txtTCodigo);
            txtTnombre =  itemView.findViewById(R.id.txtTnombre);

            linearLayout =itemView.findViewById(R.id.linearLayout);

            linearLayout.findViewById(R.id.linearLayout).setOnClickListener(new View.OnClickListener() {
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
        AdapterProductor.clickListener = clickListener;


    }





}