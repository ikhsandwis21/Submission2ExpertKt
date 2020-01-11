package com.ikhsan.submission2expertkt.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow (
    var poster: String,
    var title: String,
    var releaseDate: String,
    var overview: String,
    var crew: String,
    var userScore: String
): Parcelable