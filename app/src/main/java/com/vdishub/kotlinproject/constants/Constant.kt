package com.vdishub.kotlinproject.constants

import android.support.annotation.VisibleForTesting
import com.vdishub.kotlinproject.BuildConfig


/**
 * Created by vdishub.
 * Date: 21/11/18
 * Time: 4:22 PM
 * @author Manish rawat
 */
@VisibleForTesting
val DATABASE_NAME = "Sample.db"

object Constants {
    val API_URL = BuildConfig.BASE_URL

    object Posts {
        val DB_NAME = "posts_db"
        val DATABASE_NAME = "Sample.db"
    }
}