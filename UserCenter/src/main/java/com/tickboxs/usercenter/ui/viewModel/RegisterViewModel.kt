package com.tickboxs.usercenter.ui.viewModel

import android.util.Log
import com.tickboxs.base.ui.viewModel.BaseViewModel
import com.tickboxs.usercenter.service.UserService
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import javax.inject.Inject

class RegisterViewModel @Inject constructor(userService:UserService) : BaseViewModel<RegisterViewModel.Input,RegisterViewModel.Output>(Input(),Output()) {

    data class Input(val codeTapped: PublishSubject<Unit> = PublishSubject.create<Unit>(),
                     val phone:BehaviorSubject<String> = BehaviorSubject.createDefault(""),
                     val code:BehaviorSubject<String> = BehaviorSubject.createDefault(""),
                     val password:BehaviorSubject<String> = BehaviorSubject.createDefault(""),
                     val passwordAgain:BehaviorSubject<String> = BehaviorSubject.createDefault(""))

    data class Output(val registerButtonEnable:BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false))

    init {
        input.codeTapped.flatMap { userService.register("123","12","1213") }.subscribe{Log.d("JOJO",it.toString())}
    }

}