package br.curitiba.android.data.mapper

import br.curitiba.android.data.model.ProjectData
import br.curitiba.android.domain.model.Project

class ProjectMapper : DataMapper<ProjectData, Project> {

    override fun mapToDomain(data: ProjectData) = with(data) {
        Project(
            id = id,
            name = name,
            fullName = fullName,
            starCount = starCount,
            dateCreated = dateCreated,
            ownerName = ownerName,
            ownerAvatar = ownerAvatar,
            isBookmarked = isBookmarked,
        )
    }

    override fun mapToData(domain: Project) = with(domain) {
        ProjectData(
            id = id,
            name = name,
            fullName = fullName,
            starCount = starCount,
            dateCreated = dateCreated,
            ownerName = ownerName,
            ownerAvatar = ownerAvatar,
            isBookmarked = isBookmarked,
        )
    }
}
