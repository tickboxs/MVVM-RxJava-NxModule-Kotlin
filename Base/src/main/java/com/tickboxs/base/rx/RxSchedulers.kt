package com.tickboxs.base.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

object RxSchedulers {
    val database: Scheduler
        get() = Schedulers.single()

    val io: Scheduler
        get() = Schedulers.io()

    val ui: Scheduler
        get() = AndroidSchedulers.mainThread()
}