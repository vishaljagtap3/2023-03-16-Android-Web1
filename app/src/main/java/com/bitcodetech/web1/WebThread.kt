package com.bitcodetech.web1

import android.os.AsyncTask
import android.os.Handler
import android.os.Message
import android.util.Log

class WebThread(
    private val handler: Handler
) : AsyncTask<Any, Any, ArrayList<User>>() {

    override fun doInBackground(vararg p0: Any?): ArrayList<User>? {
        //WebUtil.simpleReqRes()
        val users = WebUtil.getUsers()

        for(user in users!!) {
            Log.e("tag", user.toString())
        }
        return users
    }

    override fun onPostExecute(result: ArrayList<User>?) {
        super.onPostExecute(result)
        val message = Message()
        message.obj = result
        handler.sendMessage(message)
    }
}