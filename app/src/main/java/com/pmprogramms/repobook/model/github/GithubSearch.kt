package com.pmprogramms.repobook.model.github

import com.google.gson.annotations.SerializedName

class GithubSearch(
    @SerializedName("total_count")
    var count: Int,
    var items: List<Github>
) {
}