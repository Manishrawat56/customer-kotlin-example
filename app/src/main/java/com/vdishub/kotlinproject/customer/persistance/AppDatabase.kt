package com.vdishub.kotlinproject.customer.persistance

import android.os.AsyncTask
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.Database
import android.content.Context


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 11:54 AM
 * @author Manish rawat
 */
@Database(entities = arrayOf(Customer::class), version = 1)
public abstract class AppDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    private class PopulateDbAsync

    internal constructor(db: AppDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: CustomerDao

        init {
            mDao = db.customerDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            /*mDao.deleteAll()
            var emp = Employee(1, "Prashant", 29)
            mDao.insert(emp)
            emp = Employee(2, "Manish rawat", 26)
            mDao.insert(emp)*/
            return null
        }
    }

    companion object {
        private lateinit var INSTANCE: AppDatabase

        /**
         * Gets database.
         *
         * @param context the context
         * @return the database
         */
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Create database here
                        INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase::class.java, "emp_database"
                        )
                            .addCallback(sRoomDatabaseCallback).build()
                    }
                }
            }
            return INSTANCE
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE).execute()
            }
        }
    }
}