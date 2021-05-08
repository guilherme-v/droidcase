package br.curitiba.android.domain.fake

import br.curitiba.android.domain.model.Project
import java.util.*

object FakeProjectFactory {

    fun randomUUUID(): String {
        return UUID.randomUUID().toString().substring(0..6)
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeProject(): Project {
        return Project(
            randomUUUID(), randomUUUID(), randomUUUID(),
            randomUUUID(), randomUUUID(), randomUUUID(),
            randomUUUID(), randomBoolean()
        )
    }

    fun makeProjectList(size: Int): List<Project> {
        val projects = mutableListOf<Project>()
        repeat(size) {
            projects.add(makeProject())
        }
        return projects
    }
}