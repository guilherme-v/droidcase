package br.curitiba.android.remote.mapper

import br.curitiba.android.data.model.ProjectData
import br.curitiba.android.remote.model.ProjectDto


class ProjectsResponseDtoMapper constructor() : DtoMapper<ProjectDto, ProjectData> {

    override fun mapToData(dto: ProjectDto) = with(dto) {
        ProjectData(
            id = id,
            name = name,
            fullName = fullName,
            starCount = starCount.toString(),
            dateCreated = dateCreated,
            ownerName = owner.ownerName,
            ownerAvatar = owner.ownerAvatar,
            isBookmarked = false,
        )
    }
}
