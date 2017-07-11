package com.app.kotlinsample

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import butterknife.OnEditorAction
import butterknife.OnFocusChange
import com.app.kotlinsample.base.BaseActivity
import com.mobsandgeeks.saripaar.annotation.Length
import com.mobsandgeeks.saripaar.annotation.NotEmpty
import com.mobsandgeeks.saripaar.annotation.Order
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {

    override val layoutId = R.layout.activity_login

    @NotEmpty(messageResId = R.string.username_not_empty)
    @Order(1)
    @BindView(R.id.usernameEditText)
    lateinit var usernameEditText: EditText

    @NotEmpty(messageResId = R.string.password_not_empty)
    @Order(2)
    @Length(min = 6)
    @BindView(R.id.passwordEditText)
    lateinit var passwordEditText: EditText


    @OnClick(R.id.submitButton)
    fun submitBtnClicked() {
        validateForm()
    }

    @OnEditorAction(R.id.passwordEditText)
    fun passportIcDoneKeyboard(actionId: Int): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            validateForm()
            return true
        }

        return false
    }

    @OnFocusChange(R.id.usernameEditText, R.id.passwordEditText)
    fun onFocusChanged(view: View, hasFocus: Boolean) {
        if (hasFocus)
            mValidator?.validateBefore(view)
    }

    override fun onValidationSucceeded() {
        super.onValidationSucceeded()
        //send data to server
        toast("Validation success!!!")
    }
}
