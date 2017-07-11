package com.app.kotlinsample.util

/**
 * Created by munnadroid on 7/11/17.
 */

class LoginValidator {
    val EMPTY = ""
    val MIN_PASSWORD_LENGTH = 6

    fun validateLogin(login: String?): Boolean {
        return login != EMPTY
    }

    fun validatePassword(password: String?): Boolean {
        return password?.length!! >= MIN_PASSWORD_LENGTH
    }

}