package com.nikapps.androidapp1

import androidx.lifecycle.ViewModel
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData

class HomeViewModel:ViewModel() {
    var TAG = HomeViewModel::class.java.simpleName
    var count = 0
    var _seconds = MutableLiveData<Int>()

    fun incrementCount(){
        count++
    }
    fun startTimer(){
        var timer = object: CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG,"time remaining ="+millisUntilFinished)
                _seconds.value = millisUntilFinished.toInt()
            }

            override fun onFinish() {
                Log.i(TAG,"timer completed")
            }
        }.start()
    }
}