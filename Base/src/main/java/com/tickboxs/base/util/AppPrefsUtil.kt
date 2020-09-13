package com.tickboxs.base.util

import android.content.Context
import android.content.SharedPreferences
import com.tickboxs.base.common.BaseApplication
import com.tickboxs.base.common.Constant

object AppPrefsUtil {
    private val sp: SharedPreferences = BaseApplication.INSTANCE.getSharedPreferences(
        Constant.TABLE_PREFS,
        Context.MODE_PRIVATE
    )
    private val ed: SharedPreferences.Editor

    init {
        ed = sp.edit()
    }

    // Boolean
    fun putBoolean(key: String, value: Boolean) {
        ed.putBoolean(key, value)
        ed.commit()
    }

    fun getBoolean(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

    // String
    fun putString(key: String, value: String) {
        ed.putString(key, value)
        ed.commit()
    }

    fun getString(key: String): String? {
        return sp.getString(key,"")
    }

    // Int
    fun putInt(key: String, value: Int) {
        ed.putInt(key, value)
        ed.commit()
    }

    fun getInt(key: String): Int {
        return sp.getInt(key,0)
    }

    // Long
    fun putLong(key: String, value: Long) {
        ed.putLong(key, value)
        ed.commit()
    }

    fun getLong(key: String): Long {
        return sp.getLong(key,0)
    }

    // Float
    fun putFloat(key: String, value: Float) {
        ed.putFloat(key, value)
        ed.commit()
    }

    fun getFloat(key: String): Float {
        return sp.getFloat(key,0.0f)
    }

    // Set
    fun putStringSet(key:String,set:Set<String>) {
        val localSet = getStringSet(key)
        localSet?.let {
            it.addAll(set)
            ed.putStringSet(key,it)
        } ?: let {
            ed.putStringSet(key,set)
        }
        ed.commit()
    }

    fun getStringSet(key:String) : MutableSet<String>? {
        val set = setOf<String>()
        return sp.getStringSet(key,set)
    }

    // 删除
    fun remove(key:String) {
        ed.remove(key)
    }
}