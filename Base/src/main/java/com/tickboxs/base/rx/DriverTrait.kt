package com.tickboxs.base.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.reactivestreams.Publisher

// Mimic Driver Trait in RxSwift for better signal bind experience
interface SharingStrategy {
    val scheduler: Scheduler
    fun <Element> share(source: Observable<Element>): Observable<Element>
}

open class SharedSequence<SharingStrategy : com.tickboxs.base.rx.SharingStrategy, Element>(source: Observable<Element>,
                                                                                                              sharingStrategy: SharingStrategy) {
    private val source = sharingStrategy.share(source)

    fun asObservable():Observable<Element> {
        return source
    }
}

object DriverSharingStrategy : SharingStrategy {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

    override fun <Element> share(source: Observable<Element>): Observable<Element> = source.replay(1).refCount()
}

typealias Driver<Element> = SharedSequence<DriverSharingStrategy, Element>

fun <Element> Observable<Element>.asDriver(onErrorJustReturn: Element): Driver<Element> {
    return Driver(observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { onErrorJustReturn }, DriverSharingStrategy)
}

fun <Element> Observable<Element>.asDriver(onErrorDriveWith: (t:Throwable)->Observable<Element>): Driver<Element> {
    return Driver(observeOn(DriverSharingStrategy.scheduler)
            .onErrorResumeNext(onErrorDriveWith), DriverSharingStrategy)
}

fun <Element> Driver<Element>.drive(relay: BehaviorSubject<Element>) {
    this.asObservable().subscribe {
        relay.onNext(it)
    }
}