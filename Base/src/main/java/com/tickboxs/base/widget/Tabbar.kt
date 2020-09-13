package com.tickboxs.base.widget

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.tickboxs.base.R

class Tabbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    var mCartBadge:TextBadgeItem
    var mMsgBadgeItem: ShapeBadgeItem

    init {

        // 主页
        val homeItem = BottomNavigationItem(R.drawable.ic_launcher_foreground,"Home")
            .setInactiveIconResource(R.drawable.ic_launcher_background)
            .setActiveColor(R.color.lb_basic_card_bg_color)
            .setInActiveColor(R.color.lb_basic_card_content_text_color)

        // 分类
        val categoryItem = BottomNavigationItem(R.drawable.ic_launcher_foreground,"Category")
            .setInactiveIconResource(R.drawable.ic_launcher_background)
            .setActiveColor(R.color.lb_basic_card_bg_color)
            .setInActiveColor(R.color.lb_basic_card_content_text_color)

        // 购物车
        val cartItem = BottomNavigationItem(R.drawable.ic_launcher_foreground,"Cart")
            .setInactiveIconResource(R.drawable.ic_launcher_background)
            .setActiveColor(R.color.lb_basic_card_bg_color)
            .setInActiveColor(R.color.lb_basic_card_content_text_color)

        mCartBadge = TextBadgeItem()
        cartItem.setBadgeItem(mCartBadge)

        // 消息
        val messageItem = BottomNavigationItem(R.drawable.ic_launcher_foreground,"Message")
            .setInactiveIconResource(R.drawable.ic_launcher_background)
            .setActiveColor(R.color.lb_basic_card_bg_color)
            .setInActiveColor(R.color.lb_basic_card_content_text_color)

        mMsgBadgeItem = ShapeBadgeItem()
        mMsgBadgeItem.setShape(ShapeBadgeItem.SHAPE_OVAL)
        messageItem.setBadgeItem(mMsgBadgeItem)

        // 我的
        val mineItem = BottomNavigationItem(R.drawable.ic_launcher_foreground,"Mine")
            .setInactiveIconResource(R.drawable.ic_launcher_background)
            .setActiveColor(R.color.lb_basic_card_bg_color)
            .setInActiveColor(R.color.lb_basic_card_content_text_color)

        // 底部导航样式
        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.lb_tv_white)

        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(messageItem)
            .addItem(mineItem)
            .setFirstSelectedPosition(0)
            .initialise()
    }

    fun checkCartBadge(count:Int) {
        if (count > 0) {
            mCartBadge.show()
            mCartBadge.setText("$count")
        } else {
            mCartBadge.hide()
        }
    }

    fun checkMsgBadge(isVisible:Boolean) {
        if (isVisible) {
            mMsgBadgeItem.show()
        } else {
            mMsgBadgeItem.hide()
        }
    }
}