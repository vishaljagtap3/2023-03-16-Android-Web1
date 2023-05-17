package com.bitcodetech.web1

import android.net.Uri
import android.util.Log
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import javax.security.auth.login.LoginException

class WebUtil {

    companion object {

        fun simpleReqRes() {

            val url = URL("https://bitcode.in")
            val httpUrlCon = url.openConnection() as HttpURLConnection
            httpUrlCon.requestMethod = "GET"

            httpUrlCon.connect()

            Log.e("res", "method: ${httpUrlCon.requestMethod}")
            Log.e("res", "res code ${httpUrlCon.responseCode} ${httpUrlCon.responseMessage}")
            Log.e("res", "len ${httpUrlCon.contentLength} ${httpUrlCon.contentType} ${httpUrlCon.contentEncoding}")

            val ins = httpUrlCon.inputStream
            val stringBuffer = StringBuffer()
            val data = ByteArray(1024)
            var count = 0

            while( count != -1) {
                count = ins.read(data)
                if(count != -1) {
                    stringBuffer.append(String(data, 0, count))
                }
            }
            ins.close()
            httpUrlCon.disconnect()

            Log.e("res",stringBuffer.toString())

        }

        fun getDogBreeds() : ArrayList<User>?{

            val httpUrlCon = URL("https://reqres.in/api/users?page=2").openConnection() as HttpURLConnection
            httpUrlCon.connect()

            if(httpUrlCon.responseCode == 200) {
                val buffer = StringBuffer()
                val data = ByteArray(1024)
                var count : Int = 0
                while(count != -1) {
                    count = httpUrlCon.inputStream.read(data)
                    if(count != -1) {
                        buffer.append(String(data, 0, count))
                    }
                }
                httpUrlCon.inputStream.close()
                httpUrlCon.disconnect()
                Log.e("res", buffer.toString())

                val jObj = JSONObject(buffer.toString())
                Log.e("res", "Page no: ${jObj.getInt("page")}")

                val jUsers = jObj.getJSONArray("data")

                val users = ArrayList<User>()

                for(i in 0 until jUsers.length()) {
                    val jUser = jUsers.getJSONObject(i)

                    users.add(
                        User(
                            jUser.getInt("id"),
                            jUser.getString("email"),
                            jUser.getString("first_name"),
                            jUser.getString("last_name"),
                            jUser.getString("avatar")
                        )
                    )

                }

                return users

            }


            return null

        }

    }

}