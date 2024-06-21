package com.nikapps.androidapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import coil.load
import com.nikapps.androidapp1.network.MarsApi
import com.nikapps.androidapp1.network.MarsPhoto
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.nikapps.androidapp1.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers


class HomeActivity : AppCompatActivity(){
    var TAG = HomeActivity::class.java.simpleName //"HomeActivity"

//  lateinit var marsRecyclerView: RecyclerView
    private lateinit var binding: ActivityHomeBinding
    val photoMarsDatabinding = MarsPhoto("007","moonimage.com")
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos:List<MarsPhoto>
//  lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_home)
//        marsRecyclerView = findViewById(R.id.recyclerViewUrls)
//        imageView = findViewById(R.id.imageView)
//        marsRecyclerView.layoutManager = LinearLayoutManager(this)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.marsphotoxml = photoMarsDatabinding
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
//        marsRecyclerView.adapter = marsAdapter
        binding.recyclerViewUrls.adapter = marsAdapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main)  {
            var listMarsPhotos =   MarsApi.retrofitService.getPhotos()
            marsAdapter.listMarsPhotos = listMarsPhotos
            marsAdapter.notifyDataSetChanged()
//          var tvHome: TextView = findViewById(R.id.tvHome)
//          tvHome.setText(listMarsPhotos.get(1).imgSrc)
            Log.i("homeactiviy",listMarsPhotos.size.toString())
            Log.i("homeactivity-url",listMarsPhotos.get(1).imgSrc)
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
