package com.vdishub.kotlinproject

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.vdishub.kotlinproject.customer.persistance.AppDatabase
import com.vdishub.kotlinproject.customer.persistance.Customer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomerDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: AppDatabase
    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears after test
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            AppDatabase::class.java)
            // allowing main thread queries, just for testing
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun getUsersWhenNoUserInserted() {
        database.customerDao().getCustomer(1)
            .test()
            .assertNoValues()
    }

    @Test fun updateAndGetUser() {
        // Given that we have a user in the data source
        database.customerDao().insert(CustomerDaoTest.CUSTOMER)

        // When we are updating the name of the user
        val updatedUser =  Customer(1, "Manish", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India")
        database.customerDao().insert(updatedUser)

        // When subscribing to the emissions of the user
        database.customerDao().getCustomer(1)
            .test()
            // assertValue asserts that there was only one emission of the user
            .assertValue { it.id == CustomerDaoTest.CUSTOMER.id && it.name == "Manish" }
    }
    companion object {

        private val CUSTOMER =
            Customer(1, "Prashant", "1234567890","abx@gmail.com","narela","delhi",110090,"new delhi","India")

    }
}