package com.pmprogramms.repobook.model

import android.os.Parcelable
import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Bitbucket(
    var values: List<Value>
) : Parcelable {
    @Parcelize
    class Value(
        var owner: Owner,
        var description: String,
        var name: String
    ) : Parcelable

    @Parcelize
    class Owner(
        var nickname: String,
        var username: String
    ) : Parcelable {
        fun getName() : String {
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
        var href: String
    ) : Parcelable
}