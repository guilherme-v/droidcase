package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.fake.FakeProjectFactory
import br.curitiba.android.domain.repository.ProjectsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class BookmarkProjectTest {
    
    @Test
    fun `It should call ProjectRepository and return a list of Projects`() = runBlockingTest {
        // given
        val project = FakeProjectFactory.makeProject()
        val projectsRepository: ProjectsRepository = mock {}
        val subject = BookmarkProject(projectsRepository)

        // when
        val params = BookmarkProject.Param(project.id)
        subject.execute(params)

        // then
        verify(projectsRepository).bookmarkProject(project.id)
    }
}