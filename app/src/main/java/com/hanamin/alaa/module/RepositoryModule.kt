package com.hanamin.alaa.module

import android.app.Application
import androidx.room.Room
import com.hanamin.alaa.data.db.prefs.DataRepository
import com.hanamin.alaa.data.db.room.HomeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun repositoryProvider(application: Application): DataRepository {
        return DataRepository(application)
    }

    @Provides
    fun databaseProvider(application: Application): HomeDatabase {
        return Room.databaseBuilder(application, HomeDatabase::class.java, "db")
            .build()
    }
}
