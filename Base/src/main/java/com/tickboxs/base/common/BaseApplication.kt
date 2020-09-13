package com.tickboxs.base.common

import android.app.Application
import android.content.pm.ApplicationInfo
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.stetho.Stetho
import com.tickboxs.base.BuildConfig
import com.tickboxs.base.logger.initLogger


open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // 单例
        INSTANCE = this

        // 日志
        initLogger(BuildConfig.DEBUG)

        // Chrome调试插件
        initStetho()

        // ARouter
        initARouter()
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initARouter() {
        if (isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }

    // 这里BaseApplication是系统创建的 所以不用lazy写法创建单例
    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    // 判断是否为Debug模式
    private fun isDebug(): Boolean {
        return this.applicationInfo != null &&
                this.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE !== 0
    }
}