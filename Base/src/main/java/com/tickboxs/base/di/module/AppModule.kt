package com.tickboxs.base.di.module

import android.content.Context
import com.tickboxs.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context:BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}