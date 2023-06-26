package com.jurabek888.viewpager_2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jurabek888.viewpager_2.Models.User
import com.jurabek888.viewpager_2.databinding.ItemViewpagerBinding

class My_adapter(var list:List<User>):PagerAdapter() {
    override fun getCount(): Int =list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemViewpagerBinding=ItemViewpagerBinding.inflate(LayoutInflater.from(container.context),container,false)
        itemViewpagerBinding.itemImage.setImageResource(list[position].image)
        itemViewpagerBinding.itemText1.text=list[position].text_1.toString()
        itemViewpagerBinding.itemText2.text=list[position].text_2.toString()
        container.addView(itemViewpagerBinding.root)

        return itemViewpagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View )
    }

}