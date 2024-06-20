package com.nikapps.androidapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.nikapps.androidapp1.network.MarsApi
import com.nikapps.androidapp1.network.MarsApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity(){
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun getMarsPhotos() {
        GlobalScope.launch {

            var jsonString =   MarsApi.retrofitService.getPhotos()
            Log.i("homeactivity", jsonString.toString())
        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

//        Log.i("homeactivity",data.toString())
//        //put the data either in a log or on the textview
//        var homeTextView: TextView = findViewById(R.id.tvHome)
//        homeTextView.setText(data)
    }
