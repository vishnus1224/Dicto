package com.vishnus1224.dicto.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.EditText
import android.widget.Toast

/**
 * Service that will have a view to get input from the user.
 * Created by Vishnu on 3/4/2017.
 */
class FloatingInputService : Service() {

    lateinit var windowManager : WindowManager

    lateinit var inputBox : EditText

    lateinit var inflater : LayoutInflater

    override fun onBind(intent: Intent?): IBinder? {

        return null;

    }

    override fun onCreate() {
        super.onCreate()

        setupServices();

        createInputBox()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_NOT_STICKY;
    }

    private fun setupServices() {

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager;

        inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
    }

    private fun createInputBox() {

        inputBox = EditText(this)

        inputBox.setHint("Paste word here")

        inputBox.setBackgroundColor(Color.BLACK)

        val params = WindowManager.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, TYPE_PHONE, FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT)

        params.y = 200

        params.gravity = Gravity.RIGHT;

        inputBox.setOnClickListener { v -> onInputBoxClick(v) }

        inputBox.setOnLongClickListener { v -> onInputBoxLongClick(v) }

        windowManager.addView(inputBox, params)
    }

    private fun onInputBoxLongClick(v: View): Boolean {

        Toast.makeText(this, "long", Toast.LENGTH_SHORT).show()

        return true
    }

    private fun onInputBoxClick(v: View) {

        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()

    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)

        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()

        windowManager.removeView(inputBox)
    }


}