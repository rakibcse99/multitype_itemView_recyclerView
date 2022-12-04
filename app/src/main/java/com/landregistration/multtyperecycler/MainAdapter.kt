package com.landregistration.multtyperecycler

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.landregistration.multtyperecycler.R
import android.widget.TextView
import java.util.ArrayList

/**
 * EVERY MOMVENT IS A NEW BEGINNING
 * Created by Md Rakibul Hasan on 20,August,2022
 *
 * @Company Data Grid Limited
 * @Address House #14/A(new), Dhanmondi R/A, Dhaka 1209.
 * @Email rakib.cse99@gmail.com
 */
internal class MainAdapter(var arrayList: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view = if (viewType == 2) {
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_2, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_1, parent, false)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = arrayList[position].title
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 7 * 2 == 0) {
            2
        } else {
            1
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView

        init {
            mTextView = itemView.findViewById(R.id.subCatagory_title)
        }
    }
}