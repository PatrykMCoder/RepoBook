package com.pmprogramms.repobook.retrofit

import com.pmprogramms.repobook.model.bitbucket.Bitbucket
import retrofit2.Call
import retrofit2.http.GET

interface BitbucketService {
    @GET("2.0/repositories?fields=values.name,values.owner,values.description")
    fun getAllBitbucketRepositories() : Call<Bitbucket>
}