package com.tickboxs.base.di.component

import android.content.Context
import com.tickboxs.base.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context():Context
}