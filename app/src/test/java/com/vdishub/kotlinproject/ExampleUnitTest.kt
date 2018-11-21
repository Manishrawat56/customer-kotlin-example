package com.vdishub.kotlinproject

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.vdishub.kotlinproject.user.persistence.User
import com.vdishub.kotlinproject.user.persistence.UserDao
import com.vdishub.kotlinproject.user.ui.UserViewModel
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataSource: UserDao

    @Captor
    private lateinit var userArgumentCaptor: ArgumentCaptor<User>

    private lateinit var viewModel: UserViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = UserViewModel(dataSource)
    }

    @Test fun getUserName_whenNoUserSaved() {
        // Given that the UserDataSource returns an empty list of users
        `when`(dataSource.getUserById(UserViewModel.USER_ID)).thenReturn(Flowable.empty<User>())

        //When getting the user name
        viewModel.userName()
            .test()
            // The user name is empty
            .assertNoValues()
    }

    @Test fun getUserName_whenUserSaved() {
        // Given that the UserDataSource returns a user
        val user = User(userName = "user name")
        `when`(dataSource.getUserById(UserViewModel.USER_ID)).thenReturn(Flowable.just(user))

        //When getting the user name
        viewModel.userName()
            .test()
            // The correct user name is emitted
            .assertValue("user name")
    }

   /* @Test fun updateUserName_updatesNameInDataSource() {
        // When updating the user name
        viewModel.updateUserName("new user name")
            .test()
            .assertComplete()

        // The user name is updated in the data source
        // using ?: User("someUser") because otherwise, we get
        // "IllegalStateException: userArgumentCaptor.capture() must not be null"
        verify<UserDao>(dataSource).insertUser(capture(userArgumentCaptor))
        assertThat(userArgumentCaptor.value.userName, Matchers.`is`("new user name"))
    }*/

}
