package ir.progali.simpleuserlists

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("answers")
    fun getUsers(
        @Query("page") page:Int,
        @Query("pagesize") pagesize:Int,
        @Query("site") site:String
    ):Call<ApiResponse>
}