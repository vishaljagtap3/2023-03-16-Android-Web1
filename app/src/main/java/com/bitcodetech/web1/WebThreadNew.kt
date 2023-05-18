package com.bitcodetech.web1

import android.os.AsyncTask

class WebThreadNew : AsyncTask<Any, Any, Any>() {

    override fun doInBackground(vararg p0: Any?): Any? {
        WebUtil.getUsersNew()
        return null
    }
}