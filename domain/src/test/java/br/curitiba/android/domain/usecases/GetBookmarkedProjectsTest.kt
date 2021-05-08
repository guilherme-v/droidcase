package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.fake.FakeProjectFactory
import br.curitiba.android.domain.repository.ProjectsRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class GetBookmarkedProjectsTest {

    @Test
    fun `It should call ProjectRepository and return a list of Projects`() = runBlockingTest {
        // given
        val projects = FakeProjectFactory.makeProjectList(10)
        val projectsRepository: ProjectsRepository = mock {
            onBlocking { getBookmarkedProjects() } doReturn projects
        }
        val subject = GetBookmarkedProjects(projectsRepository)

        // when
        val actual = subject.execute()

        // then
        verify(projectsRepository).getBookmarkedProjects()
        Truth.assertThat(actual).isEqualTo(projects)
    }
}