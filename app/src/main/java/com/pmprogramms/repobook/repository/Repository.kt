package com.pmprogramms.repobook.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pmprogramms.repobook.model.Bitbucket
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.retrofit.BitbucketService
import com.pmprogramms.repobook.retrofit.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    private val GITHUB_URL = "https://api.github.com"
    private val BITBUCKET_URL = "https://api.bitbucket.org/"

    private var githubService: GithubService = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubService::class.java)

    private var bitbucketService: BitbucketService = Retrofit.Builder()
        .baseUrl(BITBUCKET_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BitbucketService::class.java)

    private lateinit var allGithubRepositories: MutableLiveData<List<Github>>
    private lateinit var allBitbucketRepositories: MutableLiveData<Bitbucket>

// todo -> add sorting params
    fun getAllGithubRepositories(): MutableLiveData<List<Github>> {
        allGithubRepositories = MutableLiveData()

        githubService.getAllGithubRepositories().enqueue(object : Callback<List<Github>> {
            override fun onResponse(call: Call<List<Github>>, response: Response<List<Github>>) {
                allGithubRepositories.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Github>>, t: Throwable) {
                allGithubRepositories.postValue(null)
            }

        })

        return allGithubRepositories
    }

    fun getAllBitbucketRepositories(): MutableLiveData<Bitbucket> {
        allBitbucketRepositories = MutableLiveData()

        bitbucketService.getAllBitbucketRepositories().enqueue(object : Callback<Bitbucket> {
            override fun onResponse(call: Call<Bitbucket>, response: Response<Bitbucket>) {
                allBitbucketRepositories.postValue(response.body())
            }

            override fun onFailure(call: Call<Bitbucket>, t: Throwable) {
                allBitbucketRepositories.postValue(null)
            }

        })

        return  allBitbucketRepositories
    }
}