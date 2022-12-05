
package com.tiburela.tierrafertil.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tiburela.tierrafertil.R;
import com.tiburela.tierrafertil.calendario.CalendarioEnf;

import java.util.ArrayList;


public class AdapterCalendario extends RecyclerView.Adapter<AdapterCalendario.MyViewHolder>  implements   View.OnClickListener  {
    private static ClickListener clickListener;
    private View.OnClickListener listener;
    public static ArrayList<CalendarioEnf>listCalendario= new ArrayList<>();

    public String[] mColors = {"#3F51B5","#FF9800","#009688","#673AB7"};

    private LayoutInflater inflater;
    public static ArrayList<CalendarioEnf> listCalendarioEnf;


    private Context ctx;

    public AdapterCalendario(Context ctx, ArrayList<CalendarioEnf> listCalendarioEnf) {

        inflater = LayoutInflater.from(ctx);
        this.listCalendarioEnf = listCalendarioEnf;
        this.ctx = ctx;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_calendario, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

//  private View ViewColor;
//        private TextView txtNUmSeman;
//        private TextView txtDateRange;

        holder.txtNUmSeman.setText(String.valueOf(listCalendarioEnf.get(position).getSemanaNum()));
        holder.txtDateRange.setText(listCalendarioEnf.get(position).getDate());
        holder.layotItem.setTag(listCalendarioEnf.get(position).getUniqueId());


      //  holder.ViewColor.setBackgroundColor(Color.parseColor(mColors[position % UtilsCalendario.NUMS_CINTAS])); // 4 can be replaced by mColors.length


       holder.ViewColor.setCardBackgroundColor(Color.parseColor(listCalendarioEnf.get(position).getColorCintaString()));

            Log.i("miscolor","el cor now es "+listCalendarioEnf.get(position).getColorCinta());

    }



    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public int getItemCount() {
        return listCalendarioEnf.size();
    }

    @Override
    public void onClick(View view) {


        if (listener!=null){
            listener.onClick(view);
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView ViewColor;
        private TextView txtNUmSeman;
        private TextView txtDateRange;

        private LinearLayout layotItem;



        public MyViewHolder(View itemView) {
            super(itemView);

            ViewColor=itemView.findViewById(R.id.ViewColor);
            txtNUmSeman=itemView.findViewById(R.id.txtNUmSeman);
            txtDateRange=itemView.findViewById(R.id.txtDateRange);

            layotItem =itemView.findViewById(R.id.layotItem);

            layotItem.findViewById(R.id.layotItem).setOnClickListener(new View.OnClickListener() {
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
        AdapterCalendario.clickListener = clickListener;


    }





}