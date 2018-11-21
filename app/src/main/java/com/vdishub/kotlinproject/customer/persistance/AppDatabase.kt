package com.vdishub.kotlinproject.customer.persistance

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import android.util.Log


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

    internal constructor(val db: AppDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: CustomerDao

        init {
            mDao = db.customerDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            mDao.deleteAll()
            Log.e("doInBackground"    ,"doInBackground")
            mDao.insert(Customer(1, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(2, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(3, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(4, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(5, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(6, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(7, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(8, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(9, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(10, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(11, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(12, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(13, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(14, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(15, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India"))
            mDao.insert(Customer(16, "Manish", "9874561230","xyz@gmail.com","sonia vihar","delhi",110090,"new delhi","India"))
            return null
        }
    }

    companion object {
            private lateinit var INSTANCE: AppDatabase
      /*  @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()*/

            /**
             * Gets database.
             *
             * @param context the context
             * @return the database
             */
            fun getInstance(context: Context): AppDatabase {

                    synchronized(AppDatabase::class.java) {

                            // Create database here
                            INSTANCE = Room.databaseBuilder(
                                context.getApplicationContext(),
                                AppDatabase::class.java, "emp_database.db"
                            )
                                .addCallback(sRoomDatabaseCallback).build()

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