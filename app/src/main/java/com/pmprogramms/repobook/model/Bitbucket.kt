package com.pmprogramms.repobook.model

import android.os.Parcelable
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
        @SerializedName("display_name")
        var displayName: String
    ) : Parcelable

    @Parcelize
    class Links(
        var avatar: Avatar
    ) : Parcelable

    @Parcelize
    class Avatar(
        var href: String
    ) : Parcelable
}