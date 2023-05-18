package com.bitcodetech.web1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message

class MainActivity : AppCompatActivity() {

    private lateinit var users : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WebThreadNew().execute()

        /*WebThread(
            UsersHandler()
        ).execute(null)*/
    }

    private inner class UsersHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.obj != null && msg.obj is ArrayList<*>) {
                users = msg.obj as ArrayList<User>
            }
        }
    }
}