package com.tickboxs.usercenter.di.module

import com.tickboxs.usercenter.service.UserService
import com.tickboxs.usercenter.service.impl.UserServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserModule {

    @Binds
    abstract fun providesUserService(userService:UserServiceImpl):UserService

}