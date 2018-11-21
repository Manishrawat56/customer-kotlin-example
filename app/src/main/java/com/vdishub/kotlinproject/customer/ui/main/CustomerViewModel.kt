package com.vdishub.kotlinproject.customer.ui.main

import android.arch.lifecycle.ViewModel
import com.vdishub.kotlinproject.customer.persistance.Customer
import io.reactivex.Flowable

class CustomerViewModel : ViewModel() {
    lateinit var customerRepositry: CustomerRepositry;

    fun getAllcustomer():Flowable<List<Customer>>{
        return customerRepositry.getAllCustomer()
    }
}
