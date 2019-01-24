package com.myownprojects.manikandans.airlinestask.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.myownprojects.manikandans.airlinestask.ui.model.Datum;

import java.util.List;

@Dao
public interface FlightListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Datum datum);

    @Update
    void update(Datum datum);

    @Delete
    void delete(Datum datum);
    @Query("SELECT * FROM flight_list_db")
    List<Datum> getAll();

    @Insert
    void insertAll(List<Datum> users);

    /*@Transaction
    void updateTable(List<FlightListTableResponse> users) {
        clearTable()
        insertAll(users)
    }*/

}
