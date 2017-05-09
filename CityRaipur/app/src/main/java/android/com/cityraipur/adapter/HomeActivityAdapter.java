package android.com.cityraipur.adapter;


import android.com.cityraipur.MainActivity;
import android.com.cityraipur.R;
import android.com.cityraipur.modal.HomeActivityModal;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rizwan on 28/04/2017.
 */

public class HomeActivityAdapter  extends RecyclerView.Adapter<HomeActivityAdapter.HomeActivityViewHolder> {
    public static final String LOG_TAG=HomeActivityAdapter.class.getName();
    List<HomeActivityModal> list;
    Context context;
    LayoutInflater layoutInflater;


    public HomeActivityAdapter(List<HomeActivityModal> list, Context context) {
        this.list=list;
        this.context=context;
        this.layoutInflater=layoutInflater.from(context);

    }

    @Override
    public HomeActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=layoutInflater.inflate(R.layout.homeactivity_row,parent,false);
        return new HomeActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeActivityViewHolder holder, int position) {
        HomeActivityModal homeActivityModal=list.get(position);
        holder.imageView.setImageResource(homeActivityModal.getImage());
        holder.textView.setText(homeActivityModal.getTitle());
       holder.cardView.setCardBackgroundColor(Color.TRANSPARENT);
        holder.cardView.setCardElevation(3);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeActivityViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public HomeActivityViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.homeactivity_image_view);
            textView=(TextView)itemView.findViewById(R.id.homeactivity_text_view);
            cardView  = (CardView)itemView.findViewById(R.id.card_view);

        }
    }
}
