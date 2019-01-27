package com.myownprojects.manikandans.airlinestask.ui.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SwipeLayout;
import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.model.Datum;
import com.myownprojects.manikandans.airlinestask.utility.CustomRunnable;
import com.myownprojects.manikandans.airlinestask.utility.TimerService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

/**
 * Created by manikandans on 17/01/19.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersViewHolder> {

    private Context context;
    private List<Datum> flightListData;
    private Handler handler = new Handler();

    private int position;

    private UsersViewHolder holder;

    public UsersListAdapter(Context context, List<Datum> flightListData){
        this.context = context;
        this.flightListData = flightListData;

    }

    public UsersListAdapter(Context context){
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flight_list_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {

        this.holder = holder;
        this.position = position;
        holder.itemView.setTag(position);
        holder.taskName.setText(flightListData.get(position).getTaskName());
        holder.duration.setText(""+ flightListData.get(position).getActivityStartTime());
        holder.passengerName.setText(flightListData.get(position).getName());

        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setTime(String hms){
        holder.duration.setText(hms);
    }

    @Override
    public int getItemCount() {
        return flightListData.size();
    }

    public void startTimerService(int position){
        Intent intent = new Intent(context, TimerService.class);
        intent.putExtra("startTime", TimeUnit.MINUTES.toMillis(flightListData.get(position).getActivityStartTime()));
        context.startService(intent);

    }

    public BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent);
        }
    };

    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            long millisUntilFinished = intent.getLongExtra("countdown", 0);
            Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished);
            String durationText = String.format("%d min : %02d sec",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
            );
            Log.e("Time in adapter",durationText);
            holder.duration.setText(durationText);

        }
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView taskName;
        TextView duration;
        TextView passengerName;
        TextView swipeToSkip;
        SwipeLayout swipeLayout;

        CustomRunnable customRunnable;

        public UsersViewHolder(View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.task_name);
            duration = itemView.findViewById(R.id.duartion);
            passengerName = itemView.findViewById(R.id.passenger_name);
            swipeToSkip = itemView.findViewById(R.id.swipe_to_skip);
            swipeLayout = itemView.findViewById(R.id.swipe);

            customRunnable = new CustomRunnable(handler, duration, flightListData.get(position).getTaskDuration());
        }

    }
}
