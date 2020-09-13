package com.tickboxs.usercenter.di.component

import com.tickboxs.usercenter.di.module.UserModule
import com.tickboxs.usercenter.ui.activity.RegisterActivity
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}