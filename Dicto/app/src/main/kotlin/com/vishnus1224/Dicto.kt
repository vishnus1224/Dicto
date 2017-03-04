package com.vishnus1224

import android.app.Application
import android.content.Intent
import com.vishnus1224.dicto.service.FloatingInputService

/**
 * Created by Vishnu on 3/4/2017.
 */
class Dicto : Application() {


    override fun onCreate() {
        super.onCreate()

        startService(Intent(this, FloatingInputService::class.java))
    }
}