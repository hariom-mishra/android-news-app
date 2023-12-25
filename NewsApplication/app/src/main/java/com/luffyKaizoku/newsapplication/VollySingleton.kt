package com.luffyKaizoku.newsapplication

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

//create a class with private constructor takes context parameter: prevent direct instantiation
class VolleySingleton constructor(context: Context) {

    //companion objects are used to create static methods and variables. Here, it is used to hold the single instance of VolleySingleton
    companion object {

        //volatile: ensure that changes to this variable are immediately made visible to other threads
        @Volatile
        private var INSTANCE: VolleySingleton? = null

        fun getInstance(context: Context) =
            //synchronized only one thread can execute at a time
            INSTANCE ?: synchronized(this) {
                //if null: then create an instance and assigns it to INSTANCE
                INSTANCE ?: VolleySingleton(context).also {
                    INSTANCE = it
                }
            }
    }

    //lazy: initialized only when it is accessed for the first time, and the result is cached for future use
    val requestQueue: RequestQueue by lazy {
        // applicationContext is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(context.applicationContext)
    }
}
