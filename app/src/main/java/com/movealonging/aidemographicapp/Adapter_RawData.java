package com.movealonging.aidemographicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_RawData extends RecyclerView.Adapter<Adapter_RawData.ViewHolder> {
    private Context mContext;
    private List<Model_RawData> mData;

    public Adapter_RawData(Context mContext, List<Model_RawData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_rawdata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model_RawData model = mData.get(position);
        holder.txt_name.setText(model.getName());
        holder.txt_populationDate.setText(model.getPopulationDate());
        holder.txt_percentage.setText(model.getPercentage());

        holder.itemView.setTag(model.getId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name, txt_populationDate, txt_percentage;
        public ImageView img_ico;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_RawDataTitle);
            txt_populationDate = itemView.findViewById(R.id.txt_populationDate);
            txt_percentage = itemView.findViewById(R.id.txt_populationPercentage);
            img_ico = itemView.findViewById(R.id.img_rawDataIco);
        }
    }
    }
