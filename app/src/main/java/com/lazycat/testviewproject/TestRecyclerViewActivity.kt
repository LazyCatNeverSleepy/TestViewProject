package com.lazycat.testviewproject

import android.app.Activity
import android.os.Bundle
import com.lazycat.testviewproject.databinding.ActivityTestRecyclerviewBinding

class TestRecyclerViewActivity : Activity(){

    private lateinit var binding : ActivityTestRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrayList : MutableList<String> = ArrayList<String>()
        for (index in 0..30){
            arrayList.add("這是第${index}個位置")
        }
        binding.mainList.adapter = ListAdapter(arrayList)
    }
}