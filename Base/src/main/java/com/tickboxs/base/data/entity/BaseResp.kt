package com.tickboxs.base.data.entity

data class BaseResp<T> (val status:Int,val message:String,val data:T)