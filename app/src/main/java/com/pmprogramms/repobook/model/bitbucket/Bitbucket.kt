package com.pmprogramms.repobook.model.bitbucket

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Bitbucket(
    var values: List<Value>
) : Parcelable {

    fun setValuesData(values: List<Value>) {
        this.values = values
    }

    @Parcelize
    class Value(
        var owner: Owner,
        var description: String,
        var name: String
    ) : Parcelable

    @Parcelize
    class Owner(
        var nickname: String,
        var username: String,
        var links: Links

    ) : Parcelable {
        fun getName(): String {
            if (nickname == null) // @nickname is not always != null.
                return username
            return nickname
        }
    }

    @Parcelize
    class Links(
        var avatar: Avatar
    ) : Parcelable

    @Parcelize
    class Avatar(
        @SerializedName("href")
        var avatarURL: String
    ) : Parcelable
}