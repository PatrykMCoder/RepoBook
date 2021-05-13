package com.pmprogramms.repobook.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
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

    private lateinit var allRepo: MutableLiveData<List<Github>>

    fun getGithubHome() {
        githubService.getGithubHome().enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {

            }

        })
    }

    fun getAllRepo(): MutableLiveData<List<Github>> {
        allRepo = MutableLiveData()

        githubService.getAllRepo().enqueue(object : Callback<List<Github>> {
            override fun onResponse(call: Call<List<Github>>, response: Response<List<Github>>) {
                Log.d("GithubFragmentRepo", "onResponse: ${response.body()}")
                allRepo.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Github>>, t: Throwable) {
                Log.d("GithubFragmentRepo", "onResponse err: ${t.message}")
                allRepo.postValue(null)
            }

        })

        return allRepo
    }
}