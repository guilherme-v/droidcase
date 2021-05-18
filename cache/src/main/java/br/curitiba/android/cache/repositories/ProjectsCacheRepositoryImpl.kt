package br.curitiba.android.cache.repositories

import android.util.Log
import br.curitiba.android.cache.db.AppDatabase
import br.curitiba.android.cache.mapper.ProjectEntityMapper
import br.curitiba.android.cache.model.config.ConfigEntity
import br.curitiba.android.data.datasource.projects.ProjectsCache
import br.curitiba.android.data.model.ProjectData

class ProjectsCacheRepositoryImpl constructor(
    private val mapper: ProjectEntityMapper,
    private val db: AppDatabase
) : ProjectsCache {
    override suspend fun getProjects(): List<ProjectData> {
        return db.projectsDao()
            .getProjects()
            .map(mapper::mapToData)
    }

    override suspend fun saveProjects(projects: List<ProjectData>) {
        val entities = projects.map(mapper::mapToEntity)
        db.projectsDao()
            .insertProjects(entities)
    }

    override suspend fun clearProjects() {
        db.projectsDao()
            .deleteProjects()
    }

    override suspend fun getBookmarkedProjects(): List<ProjectData> {
        return db.projectsDao()
            .getBookmarkedProjects()
            .map(mapper::mapToData)
    }

    override suspend fun setProjectAsBookmarked(projectId: String) {
        db.projectsDao()
            .setBookmarkStatus(
                isBookmarked = true,
                projectId = projectId
            )
    }

    override suspend fun setProjectAsNotBookmarked(projectId: String) {
        db.projectsDao()
            .setBookmarkStatus(
                isBookmarked = false,
                projectId = projectId
            )
    }

    override suspend fun areProjectsCached(): Boolean {
        return db.projectsDao()
            .getProjects()
            .isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        db.configDao()
            .insertConfig(
                ConfigEntity(lastCacheTime = lastCache)
            )
    }

    override suspend fun isCacheExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()

        var config: ConfigEntity? = db.configDao().getConfig()
        if (config == null) config = ConfigEntity(lastCacheTime = 0)

        return currentTime - config.lastCacheTime > expirationTime
    }
}