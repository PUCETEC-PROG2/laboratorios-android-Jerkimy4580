package ec.edu.puce.githubclient.services

import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.models.RepositoryPayLoad
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("user/repos")
    suspend fun getRepositories(
        @Query("affiliation") affiliation: String = "owner",
        @Query("sort") sort: String = "created",
        @Query("direction") direction : String = "desc",
        @Query("per_page") perPage : Int = 100,
        @Query("t") t : String = "${System.currentTimeMillis()}",

        ): List<Repository>

    @POST("user/repos")
    suspend fun createRepository(
        @Body repository: RepositoryPayLoad
    ): Repository
}