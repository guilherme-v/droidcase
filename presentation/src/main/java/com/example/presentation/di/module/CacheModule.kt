package com.example.presentation.di.module

import android.content.Context
import br.curitiba.android.cache.db.AppDatabase
import br.curitiba.android.cache.mapper.ProjectEntityMapper
import br.curitiba.android.cache.repositories.ProjectsCacheRepositoryImpl
import br.curitiba.android.data.datasource.projects.ProjectsCache
import com.example.presentation.DroidCaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideAppDatabase(app: DroidCaseApp): AppDatabase {
        return AppDatabase.getInstance(context = app)
    }

    @Singleton
    @Provides
    fun provideProjectEntityMapper(): ProjectEntityMapper = ProjectEntityMapper()

    @Provides
    fun provideProjectCacheRepo(
        mapper: ProjectEntityMapper,
        db: AppDatabase
    ): ProjectsCache = ProjectsCacheRepositoryImpl(mapper, db)
}