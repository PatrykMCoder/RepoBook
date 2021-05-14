package com.pmprogramms.repobook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pmprogramms.repobook.model.Bitbucket
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.repository.Repository

class RepositoriesViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository = Repository()

    fun getAllGithubRepositories() : MutableLiveData<List<Github>> {
        return repository.getAllGithubRepositories()
    }

    fun getAllBitbucketRepositories() : MutableLiveData<Bitbucket> {
        return repository.getAllBitbucketRepositories()
    }
}