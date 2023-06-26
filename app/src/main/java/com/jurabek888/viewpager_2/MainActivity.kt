package com.jurabek888.viewpager_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayout
import com.jurabek888.viewpager_2.Adapter.My_adapter
import com.jurabek888.viewpager_2.Models.User
import com.jurabek888.viewpager_2.databinding.ActivityMainBinding
import com.jurabek888.viewpager_2.databinding.ItemTabLayaotBinding
import com.jurabek888.viewpager_2.databinding.Tab2ItemBinding

class MainActivity : AppCompatActivity() {
      private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var my_pager_adapter:My_adapter
    private lateinit var list: ArrayList<User>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadview()
        my_pager_adapter=My_adapter(list)
        binding.myViewPager.adapter=my_pager_adapter

        binding.textNext.setOnClickListener {
            val carrent=binding.myViewPager.currentItem
            if (carrent < my_pager_adapter.count-1 ){
              binding.myViewPager.currentItem=carrent+1
            }
        }
        binding.textOld.setOnClickListener {
        val current = binding.myViewPager.currentItem
            if (current >= my_pager_adapter.count || current >= 0){
                binding.myViewPager.currentItem=current-1
            }
        }
        binding.myTabLayaut.setupWithViewPager(binding.myViewPager)

        val tabcount=binding.myTabLayaut.tabCount
        for (i in 0 until tabcount){
            val tabLayaotBinding=ItemTabLayaotBinding.inflate(layoutInflater)
            val tab2ItemBinding=Tab2ItemBinding.inflate(layoutInflater)
            val tab=binding.myTabLayaut.getTabAt(0)
            val tab3 =binding.myTabLayaut.getTabAt(i)
            tab?.customView=tabLayaotBinding.root
            tab3?.customView=tab2ItemBinding.root

            if(i == 0){
                tabLayaotBinding.tabImage.visibility=View.VISIBLE
                tab2ItemBinding.tabImage2.visibility=View.VISIBLE
            }else{
                tabLayaotBinding.tabImage.visibility=View.VISIBLE
                tab2ItemBinding.tabImage2.visibility=View.VISIBLE
            }
        }
        binding.myTabLayaut.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabLayaotBinding = ItemTabLayaotBinding.inflate(layoutInflater)
                tabLayaotBinding.tabImage.visibility = View.VISIBLE
                tab?.customView = tabLayaotBinding.root
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tab2ItemBinding = Tab2ItemBinding.inflate(layoutInflater)
                tab2ItemBinding.tabImage2.visibility = View.VISIBLE
                tab?.customView = tab2ItemBinding.root
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val tab2ItemBinding = Tab2ItemBinding.inflate(layoutInflater)
                tab2ItemBinding.tabImage2.visibility = View.VISIBLE
                tab?.customView = tab2ItemBinding.root

            }

        })
    }

    private fun loadview() {
        list=ArrayList()
        list.add(User(R.drawable.image_1,"Click va Paymega o’tish xizmati","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.image_2,"Barcha operatorlar bo’yicha statistika","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.image_3,"Tariflarni filtrlash","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
        list.add(User(R.drawable.image_4,"Yangi imkoniyatlar","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."))
    }
}