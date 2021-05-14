package com.pmprogramms.repobook.retrofit

import com.pmprogramms.repobook.model.Github
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    fun getAllGithubRepositories() : Call<List<Github>>
}