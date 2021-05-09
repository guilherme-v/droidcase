package br.curitiba.android.remote.service

import br.curitiba.android.remote.model.ProjectsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sortBy: String,
        @Query("order") order: String
    ): ProjectsResponseDto
}