package com.myownprojects.manikandans.airlinestask.ui.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.model.Datum;

import java.util.List;

public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.MyViewHolder> {

    private Context context;
    private List<Datum> topListModels;

    public TopListAdapter(Context context, List<Datum> topListModels){
        this.context = context;
        this.topListModels = topListModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text1.setText(topListModels.get(position).getArrFlightNumber());
        holder.text2.setText(topListModels.get(position).getDepFlightNumber());
        holder.text3.setText(""+topListModels.get(position).getTaskScheduleId());
        holder.text4.setText(topListModels.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return topListModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;

        public MyViewHolder(View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            text4 = itemView.findViewById(R.id.text4);
        }

    }
}
