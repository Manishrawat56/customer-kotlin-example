package com.vdishub.kotlinproject.customer.ui.main

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.vdishub.kotlinproject.MyApplication
import com.vdishub.kotlinproject.customer.persistance.Customer
import io.reactivex.Flowable

class CustomerViewModel() : ViewModel() {
    //lateinit var customerRepositry: CustomerRepositry;

    fun getAllcustomer():Flowable<List<Customer>>{
        Log.e("getAllcustomer"    ,"getAllcustomer")
        return MyApplication.instance.getRepository().getAllCustomer()
    }

     var customerAdapter:CustomerAdapter = CustomerAdapter()
    fun getCustomerAdpater():CustomerAdapter{
        return customerAdapter
    }
}
