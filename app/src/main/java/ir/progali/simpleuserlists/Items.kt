package ir.progali.simpleuserlists

import com.google.gson.annotations.SerializedName

class Items {

    @SerializedName("owner")
    var owner:Owner? = null
    var last_activity_date:Long? = null
    var score:Int? = null
}