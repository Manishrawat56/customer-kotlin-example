package com.vdishub.kotlinproject.persistance

import android.content.Context
import android.content.SharedPreferences



class SharedPreferenceSave(context: Context) {
   lateinit var prefs: SharedPreferences
   lateinit var editor: SharedPreferences.Editor
    private val LOGIN_STATUS = "login_status"
    private val EMIAL = "email"
    private val PASSWD = "password"

    /*fun SharedPreferenceSave(context: Context): ??? {
        prefs = context.getSharedPreferences(
            "wm_data", Context.MODE_PRIVATE
        )
        editor = prefs.edit()
    }*/

    /*public static SharedPreferences getPrefs(Context context) {
        if (prefs == null){
            synchronized (SharedPreferenceSave.class){
                if (prefs == null){

                }
            }
        }
        return prefs;
    }
*/
    fun getEmail(): String {
        return prefs.getString(EMIAL, "")
    }

    fun setEmail(email: String) {
        editor.putString(EMIAL, email)
        editor.commit()
    }


    fun getPassword(): String {
        return prefs.getString(PASSWD, "")
    }

    fun setPassword(password: String) {
        editor.putString(PASSWD, password)
        editor.commit()
    }


    fun getCustomerId(): String {
        return prefs.getString("customer_id", "")
    }

    fun setCustomerId(customerId: String) {
        editor.putString("customer_id", customerId)
        editor.commit()
    }


    fun isLogin(): Boolean {
        return prefs.getBoolean(LOGIN_STATUS, false)
    }

    fun setLogin(login: Boolean) {
        editor.putBoolean(LOGIN_STATUS, login)
        editor.commit()
    }


    fun getCartCount(): Int {
        return prefs.getInt("count", 0)
    }

    fun setCartCount(count: Int) {
        if (count >= 0) {
            editor.putInt("count", count)
            editor.commit()
        }
    }

    /* public boolean isSkip() {
        return prefs.getBoolean("skip", false);
    }

    public void setSkip(boolean skip) {
        editor.putBoolean("skip", skip);
        editor.commit();
    }*/
}