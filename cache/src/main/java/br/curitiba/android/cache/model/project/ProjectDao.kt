package br.curitiba.android.cache.model.project

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProjectDao {

    @Query("SELECT * FROM projects")
    suspend fun getProjects(): List<ProjectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProjects(projects: List<ProjectEntity>)

    @Query("DELETE FROM projects")
    fun deleteProjects()

    @Query("SELECT * FROM projects WHERE is_bookmarked = 1")
    fun getBookmarkedProjects(): List<ProjectEntity>

    @Query("UPDATE projects SET is_bookmarked = :isBookmarked WHERE project_id = :projectId")
    fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)
}