package com.bitcodetech.web1

import android.os.AsyncTask
import android.util.Log

class WebThread : AsyncTask<Any, Any, Any>() {

    override fun doInBackground(vararg p0: Any?): Any? {
        //WebUtil.simpleReqRes()
        val users = WebUtil.getDogBreeds()

        for(user in users!!) {
            Log.e("tag", user.toString())
        }
        return null
    }
}