package com.example.myshop.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DataAccesObject myDao();
}
