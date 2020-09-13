package com.tickboxs.usercenter.service.impl

import com.tickboxs.base.data.entity.BaseResp
import com.tickboxs.base.rx.BaseException
import com.tickboxs.usercenter.repository.UserRepository
import com.tickboxs.usercenter.service.UserService
import io.reactivex.rxjava3.core.Observable
import java.lang.Error
import javax.inject.Inject

class UserServiceImpl @Inject constructor(userRepository:UserRepository): UserService {
    private val repository = UserRepository()
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile,pwd,verifyCode).map { t:BaseResp<String> ->

            if (t.status != 0) {
                throw BaseException(t.status,t.message)
            } else {
                true
            }
        }
    }

}