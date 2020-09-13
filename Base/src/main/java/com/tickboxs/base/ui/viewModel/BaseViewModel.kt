package com.tickboxs.base.ui.viewModel

open class BaseViewModel<Input,Output>(val input:Input,val output:Output) : AutoDisposeViewModel() {
    
}