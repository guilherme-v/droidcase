package com.example.presentation.di.module

import br.curitiba.android.domain.repository.ProjectsRepository
import br.curitiba.android.domain.usecases.GetProjects
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providesGetProjects(repo: ProjectsRepository): GetProjects = GetProjects(repo)
}