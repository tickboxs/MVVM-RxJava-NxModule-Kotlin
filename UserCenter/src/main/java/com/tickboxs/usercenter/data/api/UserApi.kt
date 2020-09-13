package com.tickboxs.usercenter.data.api

import com.tickboxs.base.data.entity.BaseResp
import com.tickboxs.usercenter.data.entity.RegisterReq
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>
}