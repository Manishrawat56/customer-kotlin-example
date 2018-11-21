package com.vdishub.kotlinproject.customer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vdishub.kotlinproject.R
import com.vdishub.kotlinproject.customer.ui.main.CustomerFragment

class CustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CustomerFragment.newInstance())
                .commitNow()
        }
    }

}
