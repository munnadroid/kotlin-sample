package com.app.kotlinsample.base

import android.widget.EditText
import butterknife.ButterKnife
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import org.jetbrains.anko.toast

/**
 * Created by munnadroid on 7/11/17.
 */
abstract class BaseActivity : android.support.v7.app.AppCompatActivity(), Validator.ValidationListener {


    protected var mValidator: Validator? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        ButterKnife.bind(this)

        initializeValidator()
    }

    protected fun validateForm(){
        mValidator?.validate()
    }

    /**
     * initialize saripaar form validation
     */
    protected fun initializeValidator() {
        if (mValidator == null) {
            mValidator = Validator(this)
            mValidator?.validationMode = Validator.Mode.IMMEDIATE
            mValidator?.setValidationListener(this)
        }
    }

    /**
     * show error message in respective fields
     */
    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        if (errors != null)
            for (error in errors) {
                val view = error.view
                var message: String? = error.getCollatedErrorMessage(this)
                // Display error messages ;)
                if (view is EditText) {
                    view.error = message
                } else
                    toast(message!!)
            }
    }

    override fun onValidationSucceeded() {
    }

    abstract val layoutId: Int
}