package br.curitiba.android.cache.model.config

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.curitiba.android.cache.db.AppDatabase
import br.curitiba.android.cache.fake.FakeFactory
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ConfigDaoTest {

    lateinit var configDao: ConfigDao
    lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase::class.java).build()
        configDao = db.configDao()
    }

    @After
    fun closeDatabase() {
        db.close()
    }

    // runBlockingTest doesn't work here
    @Test
    fun itShouldBeAbleToInsertConfigs() = runBlocking {
        // Given
        val config = FakeFactory.makeConfigCache()

        // When
        configDao.insertConfig(config)
        val actual = configDao.getConfig()

        // Then
        assertThat(actual).isEqualTo(config)
    }
}