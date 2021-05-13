package com.pmprogramms.repobook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.repository.GithubRepository

class GithubViewModel(application: Application) : AndroidViewModel(application) {
    private var githubRepository: GithubRepository = GithubRepository()

    fun getHome() {
        githubRepository.getGithubHome()
    }

//    fun getAllRepo() : MutableLiveData<List<Github>> {
//        return githubRepository.getAllRepo()
//    }

    fun getAllRepo() : MutableLiveData<List<Github>> {
        return githubRepository.getAllRepo()
    }
}