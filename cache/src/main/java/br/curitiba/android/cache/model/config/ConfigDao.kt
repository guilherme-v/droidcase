package br.curitiba.android.cache.model.config

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConfigDao {

    @Query("SELECT * FROM config")
    suspend fun getConfig(): ConfigEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertConfig(config: ConfigEntity)
}