package br.curitiba.android.cache.model.config

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config")
data class ConfigEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = -1,

    @ColumnInfo(name = "last_cache_time")
    var lastCacheTime: Long
)