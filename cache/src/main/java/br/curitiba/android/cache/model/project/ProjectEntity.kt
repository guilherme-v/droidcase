package br.curitiba.android.cache.model.project

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(

    @PrimaryKey
    @ColumnInfo(name = "project_id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "full_name")
    var fullName: String,

    @ColumnInfo(name = "star_count")
    var starCount: String,

    @ColumnInfo(name = "date_created")
    var dateCreated: String,

    @ColumnInfo(name = "owner_name")
    var ownerName: String,

    @ColumnInfo(name = "owner_avatar")
    var ownerAvatar: String,

    @ColumnInfo(name = "is_bookmarked")
    var isBookmarked: Boolean
)