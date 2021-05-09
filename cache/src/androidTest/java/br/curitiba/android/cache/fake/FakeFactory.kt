package br.curitiba.android.cache.fake

import br.curitiba.android.cache.model.config.ConfigEntity
import br.curitiba.android.cache.model.project.ProjectEntity
import br.curitiba.android.data.model.ProjectData
import java.util.*
import java.util.concurrent.ThreadLocalRandom

object FakeFactory {

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

    fun makeProjectDataList(size: Int): List<ProjectData> {
        val projects = mutableListOf<ProjectData>()
        repeat(size) {
            projects.add(makeProjectData())
        }
        return projects
    }


    fun makeProjectEntity() = ProjectEntity(
        randomUuid(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        false
    )


    fun makeProjectEntityList(size: Int): List<ProjectEntity> {
        val projects = mutableListOf<ProjectEntity>()
        repeat(size) {
            projects.add(makeProjectEntity())
        }
        return projects
    }


    fun makeConfigCache() = ConfigEntity(
        lastCacheTime = System.currentTimeMillis()
    )

}