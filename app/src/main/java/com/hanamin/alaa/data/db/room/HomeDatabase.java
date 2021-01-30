package com.hanamin.alaa.data.db.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hanamin.alaa.data.db.room.dao.HomeDao;
import com.hanamin.alaa.data.remote.responce.Sets;


@Database(entities = {Sets.class}, version = 2)
public abstract class HomeDatabase extends RoomDatabase {
    public abstract HomeDao homeDao();
}