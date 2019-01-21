package com.myownprojects.manikandans.airlinestask.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = FlightListTableResponse.class, version = 1)
public abstract class FlightListDatabase extends RoomDatabase {

    public FlightListDao flightListDao;

}
