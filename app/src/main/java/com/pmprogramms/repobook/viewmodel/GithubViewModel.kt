package com.pmprogramms.repobook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.repository.GithubRepository

class GithubViewModel(application: Application) : AndroidViewModel(application) {
    private var githubRepository: GithubRepository = GithubRepository()

    fun getAllRepositories() : MutableLiveData<List<Github>> {
        return githubRepository.getAllRepositories()
    }
}