package ir.progali.simpleuserlists

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var baseUrl: String = "https://api.stackexchange.com/2.2/"
    val userLink:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recUser)
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        recyclerView.layoutManager = linearLayoutManager

        // GET Response
        // You can change page, pagesize value
        val usersResponse = getResponse().create(ApiInterface::class.java)
        usersResponse.getUsers(1, 10, "stackoverflow").enqueue(object:Callback<ApiResponse>
        {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful)
                {
                    var users = response?.body()
                    val adapter = AdapterRecyclerView(users?.items!!)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }

        })
    }

    fun getResponse():Retrofit
    {
        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        return retrofit
    }
}

