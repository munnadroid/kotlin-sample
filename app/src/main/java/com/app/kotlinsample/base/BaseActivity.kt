package com.app.kotlinsample.base

/**
 * Created by munnadroid on 7/11/17.
 */
abstract class BaseActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        ButterKnife.bind(this)
    }

    abstract val layoutId: Int
}