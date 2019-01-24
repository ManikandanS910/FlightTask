package com.myownprojects.manikandans.airlinestask.ui.fragment;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myownprojects.manikandans.airlinestask.MainActivity;
import com.myownprojects.manikandans.airlinestask.R;
import com.myownprojects.manikandans.airlinestask.db.FlightListDatabase;
import com.myownprojects.manikandans.airlinestask.ui.HomeActivity;
import com.myownprojects.manikandans.airlinestask.ui.SharedPrefs;
import com.myownprojects.manikandans.airlinestask.ui.adapter.TopListAdapter;
import com.myownprojects.manikandans.airlinestask.ui.adapter.UsersListAdapter;
import com.myownprojects.manikandans.airlinestask.ui.api.APIClient;
import com.myownprojects.manikandans.airlinestask.ui.api.APIResult;
import com.myownprojects.manikandans.airlinestask.ui.api.ConstantType;
import com.myownprojects.manikandans.airlinestask.ui.model.Datum;
import com.myownprojects.manikandans.airlinestask.ui.model.TopListResponse;
import com.myownprojects.manikandans.airlinestask.utility.TimerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;
import retrofit2.Call;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by manikandans on 13/01/19.
 */

public class FlightListFragment extends Fragment implements View.OnClickListener, APIResult{

    HomeActivity homeActivity;
    Context context;

    private RecyclerView topList;
    private RecyclerView flightList;
    private RecyclerView usersList;

    private TopListAdapter topListAdapter;
    private UsersListAdapter usersListAdapter;

    private List<Datum> topListModelList;
    private Paint p = new Paint();

    FlightListDatabase flightListDatabase;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topListModelList = new ArrayList<>();
        flightListDatabase = FlightListDatabase.getInstance(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flight_list_fragment, container, false);

        topList = view.findViewById(R.id.top_list);
//        usersList = view.findViewById(R.id.user_tag_list);
        flightList = view.findViewById(R.id.flight_list);

        Log.e("UserLoggedIn", ""+SharedPrefs.getBoolean(context, "UserLoggedIn"));
        if(!SharedPrefs.getBoolean(context, "UserLoggedIn")) {
            SharedPrefs.putBoolean(context, "UserLoggedIn", true);
            flightListAPI();
        }
        else
            populateUIFromDB();

        return view;
    }

    private void flightListAPI() {
        homeActivity.showProgressDialog(context, "Please Wait", "Fetching data from Server");
        new APIClient(context, this, null, ConstantType.FLIGHT_LIST, null);
    }

    private void populateUIFromDB(){
        List<Datum> datumList = flightListDatabase.flightListDao().getAll();

        Log.e("Size in table", "---"+datumList.size());
        setRecyclerViewAdapterData(datumList);

    }

    private void setRecyclerViewAdapterData(List<Datum> datumList){
        usersListAdapter = new UsersListAdapter(context, datumList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        flightList.setLayoutManager(mLayoutManager);
        flightList.setItemAnimator(new DefaultItemAnimator());
        flightList.setAdapter(usersListAdapter);

//        Log.e("List>>", ""+topListResponse.getSuccessMessage());

        topListAdapter = new TopListAdapter(context, datumList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        topList.setLayoutManager(layoutManager);
        topList.setItemAnimator(new DefaultItemAnimator());
        topList.setAdapter(topListAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

                /*@Override
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    super.clearView(recyclerView, viewHolder);

                }*/

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                    Bitmap icon;
                    if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                        View itemView = viewHolder.itemView;
                        float height = (float) itemView.getBottom() - (float) itemView.getTop();
                        float width = height / 3;

                        if(dX > 0){
                            p.setColor(Color.parseColor("#388E3C"));
                            RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                            c.drawRect(background,p);
                            icon = BitmapFactory.decodeResource(getResources(), R.drawable.start_timer);
                            RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                            c.drawBitmap(icon,null,icon_dest,p);
                        } else {
                            p.setColor(Color.parseColor("#D32F2F"));
                            RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                            c.drawRect(background,p);
                            icon = BitmapFactory.decodeResource(getResources(), R.drawable.stop_timer);
                            RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                            c.drawBitmap(icon,null,icon_dest,p);
                        }
                    }
                /*new RecyclerViewSwipeDecorator.Builder(homeActivity, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addBackgroundColor(getResources().getColor(R.color.grey_bg))

                        .addSwipeLeftBackgroundColor(getResources().getColor(R.color.colorAccent))
                        .addSwipeRightLabel("STOP")
                        .addSwipeRightBackgroundColor(Color.GREEN)
                        .addSwipeLeftLabel("START")
                        .create()
                        .decorate();*/



                super.onChildDraw(c, recyclerView, viewHolder, dX/3, dY, actionState, isCurrentlyActive);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT) {

                    final int position = viewHolder.getAdapterPosition();
                    usersListAdapter.startTimerService(position);


                } else  if(direction == ItemTouchHelper.RIGHT){

                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(flightList);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void serviceResult(ConstantType constantType, Response response) {
        TopListResponse topListResponse = (TopListResponse) response.body();
        if(topListResponse != null && topListResponse.getCount() > 0 && topListResponse.getData().size() > 0) {

//            FlightListDatabase db = Room.databaseBuilder(context,FlightListDatabase.class, "user_db").allowMainThreadQueries().build();

            flightListDatabase.flightListDao().insertAll(topListResponse.getData());

            setRecyclerViewAdapterData(topListResponse.getData());


            homeActivity.hideProgress();

        }
    }


    @Override
    public void serviceError(Call call, Throwable throwable) {
        homeActivity.hideProgress();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(usersListAdapter.br, new IntentFilter(TimerService.COUNTDOWN_BR));
        Log.i(TAG, "Registered broacast receiver");
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(usersListAdapter.br);
        Log.i(TAG, "Unregistered broacast receiver");
    }

    @Override
    public void onStop() {
        try {
            getActivity().unregisterReceiver(usersListAdapter.br);
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
            getActivity().unregisterReceiver(usersListAdapter.br);
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
        super.onDestroy();
    }
}
