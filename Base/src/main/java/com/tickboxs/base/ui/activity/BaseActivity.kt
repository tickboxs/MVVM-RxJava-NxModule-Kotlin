package com.tickboxs.base.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.tickboxs.base.common.AppManager

abstract class BaseActivity : AppCompatActivity() {

    // disposeBag
    protected val scopeProvider: AndroidLifecycleScopeProvider by lazy {
        AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)
    }

    // 布局资源id
    protected abstract val layoutId: Int

    // vm绑定方法
    protected abstract fun bind()

    // UI相关方法
    protected abstract fun makeUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        // AppManager 入栈
        AppManager.INSTANCE.addActivity(this)

        makeUI()
        bind()

    }

    override fun onDestroy() {
        super.onDestroy()

        // AppManager 出栈
        AppManager.INSTANCE.finishActivity(this)
    }
}