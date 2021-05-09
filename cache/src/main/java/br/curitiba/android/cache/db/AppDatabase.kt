package br.curitiba.android.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.curitiba.android.cache.model.config.ConfigEntity
import br.curitiba.android.cache.model.config.ConfigDao
import br.curitiba.android.cache.model.project.ProjectEntity
import br.curitiba.android.cache.model.project.ProjectDao

@Database(version = 1, entities = [ProjectEntity::class, ConfigEntity::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun projectsDao(): ProjectDao

    abstract fun configDao(): ConfigDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "droid_case.db"
                        ).build()
                    }
                    return INSTANCE as AppDatabase
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}