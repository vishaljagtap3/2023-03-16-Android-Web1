package com.bitcodetech.web1

import com.google.gson.annotations.SerializedName

class Response {
    var page : Int = 0
    @SerializedName("per_page")
    var perPage : Int = 0
    var total :Int = 0
    @SerializedName("total_pages")
    var totalPages = 0
    @SerializedName("data")
    var users : Array<User>? = null

    override fun toString(): String {
        return "$page $perPage $total $totalPages"
    }
}