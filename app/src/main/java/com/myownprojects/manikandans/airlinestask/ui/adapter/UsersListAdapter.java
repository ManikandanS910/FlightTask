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

/**
 * Created by manikandans on 17/01/19.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersViewHolder> {

    private Context context;
    private List<Datum> flightListData;

    public UsersListAdapter(Context context, List<Datum> flightListData){
        this.context = context;
        this.flightListData = flightListData;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flight_list_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {

        holder.taskName.setText(flightListData.get(position).getTaskName());
        holder.duration.setText("Duration : "+ flightListData.get(position).getTaskDuration());
        holder.passengerName.setText(flightListData.get(position).getName());
//        holder.swipeToSkip.setText(flightListData.get(position).getTaskName());

    }

    @Override
    public int getItemCount() {
        return flightListData.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView taskName;
        TextView duration;
        TextView passengerName;
        TextView swipeToSkip;

        public UsersViewHolder(View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.task_name);
            duration = itemView.findViewById(R.id.duartion);
            passengerName = itemView.findViewById(R.id.passenger_name);
            swipeToSkip = itemView.findViewById(R.id.swipe_to_skip);
        }

    }
}
