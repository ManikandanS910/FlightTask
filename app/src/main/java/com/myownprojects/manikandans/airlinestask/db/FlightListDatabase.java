package com.myownprojects.manikandans.airlinestask.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.myownprojects.manikandans.airlinestask.AppExecutors;
import com.myownprojects.manikandans.airlinestask.ui.model.Datum;
import com.myownprojects.manikandans.airlinestask.utility.DateConverter;

import java.util.List;

@Database(entities = Datum.class, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class FlightListDatabase extends RoomDatabase {

    public FlightListDao flightListDao;

    private static FlightListDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "flight_list_db";

    public abstract FlightListDao flightListDao();

    public static FlightListDatabase getInstance(Context context) {
        if (null == sInstance) {
            sInstance = buildDatabaseInstance(context);
        }
        return sInstance;
    }

    private static FlightListDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                FlightListDatabase.class,
                DATABASE_NAME)
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        sInstance = null;
    }

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    /*public static FlightListDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (FlightListDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static FlightListDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, FlightListDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            addDelay();
                            // Generate the data for pre-population
                            FlightListDatabase database = FlightListDatabase.getInstance(appContext, executors);
                            List<FlightListTableResponse> products = DataGenerator.generateProducts();
                            

                            insertData(database, products);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                })
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    *//**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     *//*
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final FlightListDatabase database, final List<FlightListTableResponse> products) {
        database.flightListDao().insertAll(products);
        *//*database.runInTransaction(() -> {
            database.flightListDao().insertAll(products);
            database.commentDao().insertAll(comments);
        });*//*
    }

    private static void addDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4("
                    + "`name` TEXT, `description` TEXT, content=`products`)");
            database.execSQL("INSERT INTO productsFts (`rowid`, `name`, `description`) "
                    + "SELECT `id`, `name`, `description` FROM products");

        }
    };*/



}
