package com.hanamin.alaa.data.db.room.dao

import androidx.room.*
import com.hanamin.alaa.data.remote.responce.Sets

@Dao
interface HomeDao {

    @Delete
    fun deletList(data: MutableList<Sets?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(data: MutableList<Sets?>)

    @Query("SELECT * FROM Sets ")
    fun getList(): MutableList<Sets?>
}
