package com.pmprogramms.repobook.retrofit

import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.model.GithubSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("/repositories")
    fun getAllGithubRepositories() : Call<List<Github>>

    @GET("search/repositories")
    fun getGithubRepositoriesSearch(@Query("q") searchKey: String) : Call<GithubSearch>
}