package com.tickboxs.usercenter.repository

import com.tickboxs.base.data.entity.BaseResp
import com.tickboxs.base.data.net.RetrofitFactory
import com.tickboxs.usercenter.data.api.UserApi
import com.tickboxs.usercenter.data.entity.RegisterReq
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<BaseResp<String>>{

        return Observable.just(BaseResp(0,"OK","NICE"))
//        return RetrofitFactory.INSTANCE
//            .create(UserApi::class.java)
//            .register(RegisterReq(mobile,pwd,verifyCode))
    }
}