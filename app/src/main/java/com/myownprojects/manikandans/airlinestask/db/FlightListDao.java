package com.myownprojects.manikandans.airlinestask.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FlightListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FlightListTableResponse flightListTableResponse);

    @Update
    void update(FlightListTableResponse flightListTableResponse);

    @Delete
    void delete(FlightListTableResponse flightListTableResponse);
    @Query("SELECT * FROM flight_table")
    List<FlightListTableResponse> getAll();

    @Insert
    void insertAll(List<FlightListTableResponse> users);

    /*@Transaction
    void updateTable(List<FlightListTableResponse> users) {
        clearTable()
        insertAll(users)
    }*/

}
