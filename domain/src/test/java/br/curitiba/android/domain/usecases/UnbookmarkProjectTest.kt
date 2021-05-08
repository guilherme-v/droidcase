package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.fake.FakeProjectFactory
import br.curitiba.android.domain.repository.ProjectsRepository
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class UnbookmarkProjectTest {
    @Test
    fun `It should call ProjectRepository and return a list of Projects`() = runBlockingTest {
        // given
        val project = FakeProjectFactory.makeProject()
        val projectsRepository: ProjectsRepository = mock {}
        val subject = UnbookmarkProject(projectsRepository)

        // when
        val params = UnbookmarkProject.Param(project.id)
        subject.execute(params)

        // then
        verify(projectsRepository).unbookmarkProject(project.id)
    }
}