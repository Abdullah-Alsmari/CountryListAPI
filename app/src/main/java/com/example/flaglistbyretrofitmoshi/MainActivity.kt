package com.example.flaglistbyretrofitmoshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        getAllData()



    }

    fun getAllData() {
        Api.retrofitService.getAllCountriesData()
            .enqueue(object : retrofit2.Callback<CountryModel> {
                override fun onResponse(
                    call: retrofit2.Call<CountryModel>,
                    response: retrofit2.Response<CountryModel>
                ) {
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply{
                        val list = response.body()
                        myAdapter = MyAdapter(list!!.data)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }

                override fun onFailure(call: retrofit2.Call<CountryModel>, t: Throwable) {
                }

            })
    }
}