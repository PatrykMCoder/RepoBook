package com.pmprogramms.repobook.model.github

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Github(
    @SerializedName("name")
    var repositoryTitle: String,
    var description: String,
    @SerializedName("html_url")
    var url: String,
    var owner: Owner
): Parcelable {

    @Parcelize
    data class Owner(
        @SerializedName("login")
        var username: String,
        @SerializedName("avatar_url")
        var avatarURL: String
    ): Parcelable
}
