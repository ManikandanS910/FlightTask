package com.myownprojects.manikandans.airlinestask.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.ui.HomeActivity;
import com.myownprojects.manikandans.airlinestask.ui.SharedPrefs;
import com.myownprojects.manikandans.airlinestask.utility.TimerService;

import static android.content.ContentValues.TAG;

public class TimerFragment extends Fragment {

    HomeActivity homeActivity;
    Context context;

    private TextView startStopTimer;
    private TextView time;
    private boolean isTimerStarted = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timer_fragment, container, false);

        startStopTimer = view.findViewById(R.id.start_stop);
        time = view.findViewById(R.id.time);

        startStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTimerStarted = !isTimerStarted;
                if(isTimerStarted){
                    startStopTimer.setText("Stop");
                    Intent intent = new Intent(homeActivity, TimerService.class);
                    getActivity().startService(intent);
                } else {
                    startStopTimer.setText("Start");
                }

            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefs.putBoolean(context, "UserLoggedIn", false);
            }
        });


        return view;
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent); // or whatever method used to update your GUI fields
        }
    };

    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            int millisUntilFinished = intent.getIntExtra("countdown", 0);
            Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished);
            time.setText(millisUntilFinished+"");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(br, new IntentFilter(TimerService.COUNTDOWN_BR));
        Log.i(TAG, "Registered broacast receiver");
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(br);
        Log.i(TAG, "Unregistered broacast receiver");
    }

    @Override
    public void onStop() {
        try {
            getActivity().unregisterReceiver(br);
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
        super.onStop();
    }
    @Override
    public void onDestroy() {
//        getActivity().stopService(new Intent(homeActivity, BroadcastService.class));
        Log.i(TAG, "Stopped service");
        try {
            getActivity().unregisterReceiver(br);
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
        super.onDestroy();
    }

}
