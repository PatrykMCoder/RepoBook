package com.pmprogramms.repobook.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.retrofit.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository {
    private val GITHUB_URL = "https://api.github.com"

    private var githubService: GithubService = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubService::class.java)

    private lateinit var allRepositories: MutableLiveData<List<Github>>

    fun getAllRepositories(): MutableLiveData<List<Github>> {
        allRepositories = MutableLiveData()

        githubService.getAllRepositories().enqueue(object : Callback<List<Github>> {
            override fun onResponse(call: Call<List<Github>>, response: Response<List<Github>>) {
                Log.d("GithubFragmentRepo", "onResponse: ${response.body()}")
                allRepositories.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Github>>, t: Throwable) {
                Log.d("GithubFragmentRepo", "onResponse err: ${t.message}")
                allRepositories.postValue(null)
            }

        })

        return allRepositories
    }
}