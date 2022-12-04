package com.landregistration.multtyperecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.landregistration.multtyperecycler.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)


        val dataList = ArrayList<CategoryModel>()
        dataList.add(CategoryModel(1,0, "1. Hi! I am in View 1"))
        dataList.add(CategoryModel(2,0, "2. Hi! I am in View 2"))
        dataList.add(CategoryModel(3,0, "3. Hi! I am in View 3"))
        dataList.add(CategoryModel(4,0, "4. Hi! I am in View 4"))
        dataList.add(CategoryModel(5,0, "5. Hi! I am in View 5"))
        dataList.add(CategoryModel(6,0, "6. Hi! I am in View 6"))
        dataList.add(CategoryModel(7,0, "7. Hi! I am in View 7"))
//        dataList.add(CategoryModel(8,0, "8. Hi! I am in View 8"))

        val mGridLayoutManager = GridLayoutManager(this, 2)
        mGridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if ((position + 1) % 7 * 2 == 0) {
                    2
                } else {
                    1
                }
            }
        }
        binding.recylerview.layoutManager = mGridLayoutManager
        binding.recylerview.adapter = MainAdapter(dataList)
    }
}