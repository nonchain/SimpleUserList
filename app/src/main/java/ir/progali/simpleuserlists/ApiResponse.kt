package ir.progali.simpleuserlists

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("items")
    var items: List<Items>? = null
    var has_more: Boolean? = null
}