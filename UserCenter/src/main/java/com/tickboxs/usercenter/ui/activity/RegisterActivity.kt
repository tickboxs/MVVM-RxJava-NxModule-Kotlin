package com.tickboxs.usercenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxbinding4.widget.textChanges
import com.tickboxs.base.ui.activity.BaseActivity
import com.tickboxs.usercenter.R
import com.tickboxs.usercenter.ui.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import com.tickboxs.base.rx.asDriver
import com.tickboxs.base.rx.drive
import javax.inject.Inject


class RegisterActivity() : BaseActivity() {

    override val layoutId = R.layout.activity_register

    @Inject
    lateinit var vm:RegisterViewModel

    override fun bind() {

        mPhoneEt.textChanges().subscribe{ Log.d("JOJO","HELOO")}
        mCodeBtn.clicks().subscribe{ vm.input.codeTapped.onNext(Unit) }
//        mPhoneEt.textChanges()
//            .map { it.toString() }
//            .asDriver("")
//            .drive(vm.input.phone)
//
//        mCodeEt.textChanges()
//            .map { it.toString() }
//            .asDriver("")
//            .drive(vm.input.code)
//
//        mPwdEt.textChanges()
//            .map { it.toString() }
//            .asDriver("")
//            .drive(vm.input.password)
    }

    override fun makeUI() {

    }

    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}