package com.pmprogramms.repobook.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Github(
    var name: String,
    var description: String,
    var owner: Owner
): Parcelable {

    @Parcelize
    class Owner(
        var login: String,
        @SerializedName("avatar_url")
        var avatarURL: String
    ): Parcelable
}
