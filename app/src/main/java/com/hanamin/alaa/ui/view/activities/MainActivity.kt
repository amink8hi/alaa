package com.hanamin.alaa.ui.view.activities

import android.os.Bundle
import com.hanamin.alaa.R
import com.hanamin.alaa.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}