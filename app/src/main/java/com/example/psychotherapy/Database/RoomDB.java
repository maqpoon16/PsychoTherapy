package com.example.psychotherapy.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.psychotherapy.model.GlobalVariable;
import com.example.psychotherapy.model.QuestionsRound;
import com.example.psychotherapy.model.SignupUser;
import com.example.psychotherapy.model.UserInputData;
import com.example.psychotherapy.model.UserRatingData;

@Database(entities = {SignupUser.class, UserInputData.class, UserRatingData.class, QuestionsRound.class},version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract DAO dao();
    private static RoomDB INSTANCE;

    public static RoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, GlobalVariable.DATABASE_NAME)
                            .allowMainThreadQueries()
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
