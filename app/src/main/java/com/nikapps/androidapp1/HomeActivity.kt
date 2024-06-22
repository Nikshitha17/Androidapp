package com.nikapps.androidapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.activity.enableEdgeToEdge
import com.nikapps.androidapp1.database.Item
import com.nikapps.androidapp1.database.ItemDao
import com.nikapps.androidapp1.database.ItemRoomDatabase
import com.nikapps.androidapp1.databinding.ActivityHomeBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.Dispatchers



class HomeActivity : AppCompatActivity() {
    var TAG = HomeActivity::class.java.simpleName //"HomeActivity"
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        binding.btnDbInsert.setOnClickListener {
            insertDataDb()
        }
        binding.btnFind.setOnClickListener {
            findItemDb(21)
        }
    }

    private fun findItemDb(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(id).first()
            binding.tvHome.setText(item.itemName)
        }
    }

        private fun insertDataDb() {
            GlobalScope.launch {
                var item = Item(21, "fruits", 11.11, 11)
                dao.insert(item)
            }
        }
}
