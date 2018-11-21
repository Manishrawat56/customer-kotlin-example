package com.vdishub.kotlinproject.customer.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 11:48 AM
 * @author Manish rawat
 */
@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upInsrt(customer: Customer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(customerList: List<Customer>)
    /**
     * Delete all.
     */
    @Query("DELETE FROM Customer")
    fun deleteAll()


    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    @Query("SELECT * from Customer ORDER BY name ASC")
    fun getAllCustomers(): Flowable<List<Customer>>
}