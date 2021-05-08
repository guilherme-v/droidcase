package br.curitiba.android.domain.usecases

import br.curitiba.android.domain.fake.FakeProjectFactory
import br.curitiba.android.domain.repository.ProjectsRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class GetProjectsTest {

    @Test
    fun `It should call ProjectRepository and return a list of Projects`() = runBlockingTest {
        // given
        val projects = FakeProjectFactory.makeProjectList(10)
        val projectsRepository: ProjectsRepository = mock {
            onBlocking { getProjects() } doReturn projects
        }
        val subject = GetProjects(projectsRepository)

        // when
        val actual = subject.execute()

        // then
        verify(projectsRepository).getProjects()
        assertThat(actual).isEqualTo(projects)
    }
}