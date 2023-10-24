package com.idn.doadandzikir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.DoaDanDzikirItem
import com.idn.doadandzikir.R

class QauliyahAdapter: RecyclerView.Adapter<QauliyahAdapter.DzikirViewHolder>() {

    private val listData = ArrayList<DoaDanDzikirItem>()
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle = view.findViewById<TextView>(R.id.tv_desc)
        val itemArabic = view.findViewById<TextView>(R.id.tv_lafaz)
        val itemtranslate = view.findViewById<TextView>(R.id.tv_terjemah)
    }

    fun setData(list: List<DoaDanDzikirItem>){
        listData.clear()
        listData.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= DzikirViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false)
    )



    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            itemTitle.text = listData[position].desc
            itemArabic.text = listData[position].lafaz
            itemtranslate.text = listData[position].terjemah
        }
    }

}