package com.cn.annotation.aoptest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Beans(var name: String, var age: Int) : Parcelable