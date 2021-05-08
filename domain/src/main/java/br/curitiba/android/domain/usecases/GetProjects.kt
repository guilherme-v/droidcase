package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.usecases.base.UseCase
import br.curitiba.android.domain.model.Project
import br.curitiba.android.domain.repository.ProjectsRepository

class GetProjects constructor(
    private val projectsRepository: ProjectsRepository
): UseCase<List<Project>, Nothing>() {

    override suspend fun execute(params: Nothing?): List<Project> {
        return  projectsRepository.getProjects();
    }
}