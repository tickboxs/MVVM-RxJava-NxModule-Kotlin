package com.tickboxs.ecommerce.ui.activity

import com.tickboxs.base.ui.activity.BaseActivity
import com.tickboxs.ecommerce.R
import com.tickboxs.ecommerce.ui.fragment.HomeFragment

class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main

    override fun bind() {

    }

    override fun makeUI() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer,HomeFragment())
        manager.commit()
    }
}