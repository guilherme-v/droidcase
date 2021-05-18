package com.example.presentation.di.module

import br.curitiba.android.data.datasource.projects.ProjectsCache
import br.curitiba.android.data.datasource.projects.ProjectsRemote
import br.curitiba.android.data.mapper.ProjectMapper
import br.curitiba.android.data.repository.ProjectsRepositoryImpl
import br.curitiba.android.domain.repository.ProjectsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesProjectMapper() = ProjectMapper()

    @Provides
    fun provideProjectRepository(
        mapper: ProjectMapper,
        cache: ProjectsCache,
        remote: ProjectsRemote
    ): ProjectsRepository = ProjectsRepositoryImpl(mapper, remote, cache)
}