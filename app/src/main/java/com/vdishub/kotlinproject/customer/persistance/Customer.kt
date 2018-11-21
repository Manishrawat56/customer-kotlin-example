package com.vdishub.kotlinproject.customer.persistance

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 11:29 AM
 * @author Manish rawat
 */
@Entity(indices = [Index("id")])
data class Customer(@PrimaryKey val id:Int,
                    val name:String,
                    val phone:String,
                    val email:String,
                    val address:String,
                    val state:String,
                    val pinCode:Int,
                    val city:String,
                    val country:String
                    ) {
}