package br.curitiba.android.data.datasource.projects

import br.curitiba.android.data.model.ProjectData

interface ProjectsRemote : ProjectsCommon {
    override suspend fun getProjects(): List<ProjectData>
}
