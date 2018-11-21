package com.vdishub.kotlinproject.user

import android.content.Context
import com.vdishub.kotlinproject.user.persistence.UserDao
import com.vdishub.kotlinproject.user.persistence.UsersDatabase
import com.vdishub.kotlinproject.user.ui.ViewModelFactory

/**
 * Enables injection of data sources.
 */
object Injection {

    fun provideUserDataSource(context: Context): UserDao {
        val database = UsersDatabase.getInstance(context)
        return database.userDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return ViewModelFactory(dataSource)
    }
}
