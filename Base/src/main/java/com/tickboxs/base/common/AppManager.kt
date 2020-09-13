package com.tickboxs.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import androidx.core.app.ActivityManagerCompat
import com.tickboxs.base.di.component.ActivityComponent
import java.util.*
import kotlin.system.exitProcess

class AppManager private constructor(){

    // 单例
    companion object {
        val INSTANCE:AppManager by lazy { AppManager() }
    }

    // Activity Stack
    private val activityStack: Stack<Activity> = Stack()

    fun addActivity(activity:Activity) {
        activityStack.add(activity)
    }

    fun finishActivity(activity:Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity():Activity {
        return activityStack.lastElement()
    }

    fun finishAllActivities() {
        activityStack.forEach {
            it.finish()
        }
        activityStack.clear()
    }

    // 退出App
    fun exitApp(context:Context) {
        // Activities 销毁
        finishAllActivities()

        // 关闭背景程序
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)

        // 手动成功退出 退出参数为0
        exitProcess(0)
    }
}
