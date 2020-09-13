package com.tickboxs.base.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.*
import kotlin.collections.ArrayList

class BaseRecyclerViewAdapter<T,VH:RecyclerView.ViewHolder> (val mContext:Context) : RecyclerView.Adapter<VH>() {

    // 数据集合 用RxJava做
    val dataList: BehaviorSubject<Array<T>> = BehaviorSubject.create()

    // 点击事件
    val itemTapSubject:PublishSubject<Pair<T,Int>> = PublishSubject.create()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemTapSubject.onNext(Pair(dataList.value[position],position))
        }
    }

    override fun getItemCount(): Int {
        return dataList.value.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

}