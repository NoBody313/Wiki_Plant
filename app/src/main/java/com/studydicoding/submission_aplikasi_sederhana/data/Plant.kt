package com.studydicoding.submission_aplikasi_sederhana.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    var name: String?,
    var botanicalName: String?,
    var image: String?,
    var desc: String?
) : Parcelable