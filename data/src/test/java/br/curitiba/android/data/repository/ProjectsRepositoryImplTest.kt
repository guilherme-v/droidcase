package br.curitiba.android.data.repository

import br.curitiba.android.data.datasource.projects.ProjectsCache
import br.curitiba.android.data.datasource.projects.ProjectsRemote
import br.curitiba.android.data.fake.FakeProjectFactory
import br.curitiba.android.data.mapper.ProjectMapper
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stubbing
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyZeroInteractions

@ExperimentalCoroutinesApi
class ProjectsRepositoryImplTest {
    lateinit var mapper: ProjectMapper

    @Mock
    lateinit var projectsRemote: ProjectsRemote

    @Mock
    lateinit var projectsCache: ProjectsCache


    @Before
    fun init() {
        mapper = ProjectMapper()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `It should return a List of Remote Projects if Cache expired`() = runBlockingTest {
        // Given
        val projectsData = FakeProjectFactory.makeProjectDataList(10)
        stubbing(projectsCache) { onBlocking { isCacheExpired() } doReturn true }
        stubbing(projectsRemote) { onBlocking { getProjects() } doReturn projectsData }
        val subject = ProjectsRepositoryImpl(mapper, projectsRemote, projectsCache)

        // When
        val actual = subject.getProjects()

        // Then
        verify(projectsCache).isCacheExpired()
        verify(projectsRemote).getProjects()
        assertThat(actual).isEqualTo(projectsData.map(mapper::mapToDomain))
    }

    @Test
    fun `It should return a List of Local Projects if Cache is NOT expired`() = runBlockingTest {
        // Given
        val projectsData = FakeProjectFactory.makeProjectDataList(10)
        stubbing(projectsCache) { onBlocking { isCacheExpired() } doReturn false }
        stubbing(projectsCache) { onBlocking { getProjects() } doReturn projectsData }
        val subject = ProjectsRepositoryImpl(mapper, projectsRemote, projectsCache)

        // When
        val actual = subject.getProjects()

        // Then
        verify(projectsCache).isCacheExpired()
        verify(projectsCache).getProjects()
        verifyZeroInteractions(projectsRemote)
        assertThat(actual).isEqualTo(projectsData.map(mapper::mapToDomain))
    }
}