package br.curitiba.android.data.datasource.projects

import br.curitiba.android.data.model.ProjectData

interface ProjectsCache : ProjectsCommon {

    override suspend fun getProjects(): List<ProjectData>

    suspend fun saveProjects(projects: List<ProjectData>)

    suspend fun clearProjects()

    suspend fun getBookmarkedProjects(): List<ProjectData>

    suspend fun setProjectAsBookmarked(projectId: String)

    suspend fun setProjectAsNotBookmarked(projectId: String)

    suspend fun areProjectsCached(): Boolean

    suspend fun setLastCacheTime(lastCache: Long)

    suspend fun isCacheExpired(): Boolean
}
