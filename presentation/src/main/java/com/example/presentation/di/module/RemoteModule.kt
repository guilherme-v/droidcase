package com.example.presentation.di.module

import br.curitiba.android.data.datasource.projects.ProjectsRemote
import br.curitiba.android.remote.mapper.ProjectsResponseDtoMapper
import br.curitiba.android.remote.repositories.ProjectsRemoteImpl
import br.curitiba.android.remote.service.GithubService
import br.curitiba.android.remote.service.GithubServiceFactory
import com.example.presentation.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideProjectsResponseDtoMapper(): ProjectsResponseDtoMapper = ProjectsResponseDtoMapper()

    @Singleton
    @Provides
    fun provideGithubService(): GithubService =
        GithubServiceFactory.createGithubService(BuildConfig.DEBUG)

    @Provides
    fun provideProjectsRemote(
        mapper: ProjectsResponseDtoMapper,
        service: GithubService
    ): ProjectsRemote = ProjectsRemoteImpl(mapper, service)
}