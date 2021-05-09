package br.curitiba.android.remote.repositories

import br.curitiba.android.remote.fake.FakeProjectFactory
import br.curitiba.android.remote.mapper.ProjectsResponseDtoMapper
import br.curitiba.android.remote.service.GithubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stubbing
import org.mockito.kotlin.verify


@ExperimentalCoroutinesApi
class ProjectsRemoteImplTest {

    lateinit var mapper: ProjectsResponseDtoMapper

    @Mock
    lateinit var service: GithubService

    @Before
    fun init() {
        mapper = ProjectsResponseDtoMapper()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `It should return a list of Projects`() = runBlockingTest {
        // Given
        val response = FakeProjectFactory.makeRandomProjectsResponse()
        stubbing(service) {
            onBlocking {
                searchRepositories(
                    any(),
                    any(),
                    any(),
                )
            } doReturn response
        }
        val subject = ProjectsRemoteImpl(mapper, service)

        // When
        val actual = subject.getProjects()

        // Then
        verify(service).searchRepositories(
            query = "language:kotlin",
            order = "stars",
            sortBy = "desc"
        )
        val data = response.items.map(mapper::mapToData);
        assertThat(actual).isEqualTo(data)
    }
}