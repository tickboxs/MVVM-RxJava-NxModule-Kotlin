package com.tickboxs.usercenter.service

import io.reactivex.rxjava3.core.Observable

interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String) : Observable<Boolean>
}