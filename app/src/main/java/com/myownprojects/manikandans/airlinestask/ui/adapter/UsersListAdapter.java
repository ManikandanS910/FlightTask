package com.myownprojects.manikandans.airlinestask.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.model.Datum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manikandans on 17/01/19.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersViewHolder> {

    private Context context;
    private List<Datum> flightListData;

    private UsersViewHolder holder;

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

        this.holder = holder;
        holder.taskName.setText(flightListData.get(position).getTaskName());
        holder.duration.setText(""+ flightListData.get(position).getTaskDuration());
        holder.passengerName.setText(flightListData.get(position).getName());
//        holder.swipeToSkip.setText(flightListData.get(position).getTaskName());

        start_countDown("5", "0", holder.duration);

    }

    public void setTime(String hms){
        holder.duration.setText(hms);
    }

    @Override
    public int getItemCount() {
        return flightListData.size();
    }

    private void start_countDown(String start, String stop, final TextView txt_timeleft) {
        try {
            //Log.e("hetal",start+"....."+stop);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Calendar start_date = Calendar.getInstance();
            start_date.setTime(format.parse(start));

            Calendar end_date = Calendar.getInstance();
            end_date.setTime(format.parse(stop));

            final Calendar today = Calendar.getInstance();
            CountDownTimer timer;

            txt_timeleft.setTextColor(Color.DKGRAY);
            if(today.before(start_date)){
//                txt_timeleft.setTextColor(context.getResources().getColor(R.color.red));
//                holder.duration.setText(context.getString(R.string.auction_not_start));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(1000); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                txt_timeleft.startAnimation(anim);
                return;
            }
            if (!today.before(end_date)) {

//                txt_timeleft.setTextColor(context.getResources().getColor(R.color.red));
//                txt_timeleft.setText(context.getString(R.string.time_out));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(1000); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                txt_timeleft.startAnimation(anim);
                return;
            }

            timer = new CountDownTimer(end_date.getTimeInMillis(), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(millisUntilFinished);

                    long diff = calendar.getTimeInMillis() - today.getTimeInMillis();

                    long seconds = diff / 1000 % 60;
                    long minutes = diff / (60 * 1000) % 60;
                    long hours = diff / (60 * 60 * 1000) % 24;
                    //long days = (int) diff / (24 * 60 * 60 * 1000);
                    long days = TimeUnit.MILLISECONDS.toDays(diff);


                    String left = "";
                    if (days > 0)
                        left += days + " ,";
                    if (hours > 0)
                        left += hours + " ,";
                    if (minutes > 0)
                        left += minutes + " ,";

                    left += seconds + " ";

                    final String finalLeft = left;


                    if (finalLeft.equals("0") || finalLeft.contains("-")) {
//                        txt_timeleft.setText(context.getString(R.string.time_out));
//                        txt_timeleft.setTextColor(context.getResources().getColor(R.color.red));
                        Animation anim = new AlphaAnimation(0.0f, 1.0f);
                        anim.setDuration(1000); //You can manage the time of the blink with this parameter
                        anim.setStartOffset(20);
                        anim.setRepeatMode(Animation.REVERSE);
                        anim.setRepeatCount(Animation.INFINITE);
                        txt_timeleft.startAnimation(anim);
                    } else
                        txt_timeleft.setText(finalLeft);
                }

                @Override
                public void onFinish() {

                }
            };
            timer.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
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
