package com.vdishub.kotlinproject.customer.ui.main

import com.vdishub.kotlinproject.customer.persistance.AppDatabase
import com.vdishub.kotlinproject.customer.persistance.Customer
import io.reactivex.Flowable


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 4:32 PM
 * @author Manish rawat
 */
class CustomerRepositry(val appDatabase:AppDatabase) {
    //lateinit var customerDao: CustomerDao
    fun getAllCustomer(): Flowable<List<Customer>> {
       return appDatabase.customerDao().getAllCustomers()
    }
    companion object {
        private lateinit var INSTANCE: CustomerRepositry

        /**
         * Gets database.
         *
         * @param AppDatabase the context
         * @return the database
         */
        fun getCustomerRepositry(appDatabase: AppDatabase): CustomerRepositry {

                synchronized(AppDatabase::class.java) {

                        // Create database here
                        INSTANCE = CustomerRepositry(appDatabase)


                    }



            return INSTANCE
        }
    }
}