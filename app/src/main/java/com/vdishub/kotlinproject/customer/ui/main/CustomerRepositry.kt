package com.vdishub.kotlinproject.customer.ui.main

import com.vdishub.kotlinproject.customer.persistance.Customer
import com.vdishub.kotlinproject.customer.persistance.CustomerDao
import io.reactivex.Flowable


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 4:32 PM
 * @author Manish rawat
 */
class CustomerRepositry {
    lateinit var customerDao: CustomerDao
    fun getAllCustomer(): Flowable<List<Customer>> {
       return customerDao.getAllCustomers()
    }

}