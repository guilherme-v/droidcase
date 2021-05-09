package br.curitiba.android.cache.mapper

import br.curitiba.android.cache.model.project.ProjectEntity
import br.curitiba.android.data.model.ProjectData

class ProjectEntityMapper : EntityMapper<ProjectEntity, ProjectData> {

    override fun mapToData(entity: ProjectEntity) = with(entity) {
        ProjectData(
            id = id,
            name = name,
            fullName = fullName,
            starCount = starCount,
            dateCreated = dateCreated,
            ownerName = ownerName,
            ownerAvatar = ownerAvatar,
            isBookmarked = isBookmarked
        )
    }

    override fun mapToEntity(data: ProjectData) = with(data) {
        ProjectEntity(
            id = id,
            name = name,
            fullName = fullName,
            starCount = starCount,
            dateCreated = dateCreated,
            ownerName = ownerName,
            ownerAvatar = ownerAvatar,
            isBookmarked = isBookmarked
        )
    }
}