package com.creative.athletes.adapter;

/**
 * Created by mohamedradwan on 10/17/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creative.athletes.R;
import com.creative.athletes.data.AthleteItem;
import com.creative.athletes.views.AthleteDetailsActivity;

import java.util.ArrayList;

public class AthleteAdapter extends RecyclerView.Adapter<AthleteAdapter.ViewHolder> {
    private ArrayList<AthleteItem> athlete;
    private Context mContext;


    public AthleteAdapter(Context mcontext, ArrayList<AthleteItem> mAthleteList) {
        this.mContext = mcontext;
        this.athlete = mAthleteList;

    }

    @Override
    public AthleteAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(AthleteAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.tv_name.setText(athlete.get(i).getName());
        if (!athlete.get(i).getImage().equals("") && athlete.get(i).getImage() != null) {
            viewHolder.iv_image.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(athlete.get(i).getImage())
                    .into(viewHolder.iv_image);
        } else
            viewHolder.iv_image.setVisibility(View.GONE);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AthleteDetailsActivity.start(mContext, athlete.get(i).getName(), athlete.get(i).getImage(), athlete.get(i).getBrief());
            }
        });

    }

    @Override
    public int getItemCount() {
        return athlete.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private ImageView iv_image;

        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView) view.findViewById(R.id.tv_name);
            iv_image = (ImageView) view.findViewById(R.id.iv_image);

        }
    }

}