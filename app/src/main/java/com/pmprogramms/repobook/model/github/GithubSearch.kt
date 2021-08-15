package com.pmprogramms.repobook.model.github

import com.google.gson.annotations.SerializedName

data class GithubSearch(
    @SerializedName("total_count")
    var count: Int,
    var items: List<Github>
)
