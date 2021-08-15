package com.pmprogramms.repobook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pmprogramms.repobook.model.bitbucket.Bitbucket
import com.pmprogramms.repobook.model.github.Github
import com.pmprogramms.repobook.model.github.GithubSearch
import com.pmprogramms.repobook.model.github.GithubUsers
import com.pmprogramms.repobook.repository.Repository

class RepositoriesViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository = Repository()

    fun getAllGithubRepositories(sorted: Boolean): LiveData<List<Github>> {
        return repository.getAllGithubRepositories(sorted)
    }

    fun getGithubRepositoriesSearch(searchKey: String): LiveData<GithubSearch> {
        return repository.getGithubRepositoriesSearch(searchKey)
    }

    fun getAllBitbucketRepositories(sorted: Boolean): LiveData<Bitbucket> {
        return repository.getAllBitbucketRepositories(sorted)
    }

    fun getAllUsersGithub(): LiveData<List<GithubUsers>> {
        return repository.getAllGithubUsers()
    }
}