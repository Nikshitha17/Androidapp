package com.nikapps.androidapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name:String =  "nikshitha"
        Log.i(TAG,"activity is getting created")
    }


    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is started")
    }

    //sleep night -- incomming call ur activity goes into the background for sometime
    override fun onPause() {
        super.onPause()
        Log.w(TAG,"activity has paused")

    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"activity has resumed")
    }

    //death of the chick -- activity no lonnger exists in the ram -- pushed to hdd[hibernate]
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity is stopped")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity is destroyed")
    }

    fun clickHandler(view: View) {
        Log.i("MainActivity-clickhandler", "button clicked")
//        var dialIntent: Intent =
//            Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))  //intent= intention
//        startActivity(dialIntent)
        var c = 10 + 20
        add(10,20)
        var hIntent:Intent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("mykey","android-vit-nikshitha")
        startActivity(hIntent)
    }

    private fun add(i: Int, i1: Int):Int {
        var c = 20
        var d = 20 * i
        mul(5,4)
        return i +i1

    }

    private fun mul(i: Int, i1: Int) {
        val d = i * i1
        div(6,3)

    }

    private fun div(i: Int, i1: Int) {
        add(10,20)
    }

    fun inflateXml(){
        var nameEditText = EditText(this)
        nameEditText.setHint("enter ur name")
        var pwdEditText = EditText(this)
        pwdEditText.setHint("enter ur pass")
        var loginButton = Button(this)
        loginButton.setText("login")
    }
}