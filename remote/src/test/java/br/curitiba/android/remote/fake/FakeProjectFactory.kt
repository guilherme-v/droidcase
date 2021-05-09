package br.curitiba.android.remote.fake

import br.curitiba.android.data.model.ProjectData
import br.curitiba.android.remote.model.OwnerDto
import br.curitiba.android.remote.model.ProjectDto
import br.curitiba.android.remote.model.ProjectsResponseDto
import java.util.*
import java.util.concurrent.ThreadLocalRandom

object FakeProjectFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString().substring(0..3)
    }

    fun randomString(): String {
        return UUID.randomUUID().toString().substring(0..3)
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeProjectData(): ProjectData {
        return ProjectData(
            randomString(), randomString(), randomString(),
            randomString(), randomString(), randomString(),
            randomString(), randomBoolean()
        )
    }

    fun makeRandomProjectDataList(size: Int): List<ProjectData> {
        val projects = mutableListOf<ProjectData>()
        repeat(size) {
            projects.add(makeProjectData())
        }
        return projects
    }

    fun makeRandomOwnerDto() = OwnerDto(randomUuid(), randomUuid())

    fun makeProjectDto() =
        ProjectDto(
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomInt(),
            randomUuid(),
            makeRandomOwnerDto()
        )

    fun makeProjectsDtoList(size: Int = randomInt()): List<ProjectDto> {
        val projects = mutableListOf<ProjectDto>()
        repeat(size) {
            projects.add(makeProjectDto())
        }
        return projects
    }

    fun makeRandomProjectsResponse() =
        ProjectsResponseDto(listOf(makeProjectDto(), makeProjectDto()))
}
