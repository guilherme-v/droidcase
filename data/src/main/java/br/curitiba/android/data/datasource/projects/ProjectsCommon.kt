package br.curitiba.android.data.datasource.projects

import br.curitiba.android.data.model.ProjectData

interface ProjectsCommon {
    suspend fun getProjects(): List<ProjectData>
}