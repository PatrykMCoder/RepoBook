package com.pmprogramms.repobook.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Github(
    @SerializedName("name")
    var repositoryTitle: String,
    var description: String,
    var owner: Owner
): Parcelable {

    @Parcelize
    class Owner(
        @SerializedName("login")
        var username: String,
        @SerializedName("avatar_url")
        var avatarURL: String
    ): Parcelable
}
