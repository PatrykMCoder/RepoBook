package com.pmprogramms.repobook.model.github

data class GithubUsers(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val repos_url: String,
    val type: String
)
