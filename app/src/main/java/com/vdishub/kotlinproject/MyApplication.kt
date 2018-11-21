package com.vdishub.kotlinproject

import android.app.Application
import android.content.Context
import com.vdishub.kotlinproject.customer.persistance.AppDatabase
import com.vdishub.kotlinproject.customer.ui.main.CustomerRepositry
import com.vdishub.kotlinproject.di.CoreComponent
import com.vdishub.kotlinproject.persistance.SharedPreferenceSave


class MyApplication : Application() {
    val TAG = MyApplication::class.java
        .simpleName

    lateinit var sharedPreferenceSave: SharedPreferenceSave

    override fun onCreate() {
        super.onCreate()
        instance = this
        pref()
        initDI()
        getDatabase(this)
    }

    private fun initDI() {
        //coreComponent = DaggerCoreComponent.builder().appModule(AppModule(this)).build()
    }
    fun getDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    fun getRepository(): CustomerRepositry {
        return CustomerRepositry.getCustomerRepositry(getDatabase(this))
    }

    fun getPreference(): SharedPreferenceSave {
        return sharedPreferenceSave
    }
    fun pref() {
        sharedPreferenceSave = SharedPreferenceSave(this)
    }
    companion object {
        lateinit var instance: MyApplication private set
        lateinit var coreComponent: CoreComponent
    }
}