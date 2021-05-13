package com.pmprogramms.repobook.retrofit

import com.pmprogramms.repobook.model.Github
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/")
    fun getGithubHome() : Call<Void>

    @GET("/repositories")
    fun getAllRepo() : Call<List<Github>>
}