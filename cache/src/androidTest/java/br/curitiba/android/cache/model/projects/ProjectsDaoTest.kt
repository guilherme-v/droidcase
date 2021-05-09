package br.curitiba.android.cache.model.projects

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.curitiba.android.cache.db.AppDatabase
import br.curitiba.android.cache.fake.FakeFactory
import br.curitiba.android.cache.model.project.ProjectDao
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ProjectsDaoTest {

    private lateinit var projectDao: ProjectDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase::class.java).build()
        projectDao = db.projectsDao()
    }

    @After
    fun closeDatabase() {
        db.close()
    }

    @Test
    fun itShouldBeAbleToInsertProjects() = runBlocking {
        // Given
        val projects = FakeFactory.makeProjectEntityList(10)

        // When
        projectDao.insertProjects(projects)
        val actual = projectDao.getProjects()

        // Then
        assertThat(actual).isEqualTo(projects)
    }
}