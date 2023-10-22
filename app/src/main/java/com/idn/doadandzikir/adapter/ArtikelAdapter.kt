package com.idn.doadandzikir.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.idn.doadandzikir.R
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.databinding.ItemArticleBinding
import com.idn.doadandzikir.utils.OnItemCallback


class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder> () {
    private var listArtikel = ArrayList<Artikel>()
    private var onItemCalBack : OnItemCallback? = null

    fun setData(list: List<Artikel>){
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCalBack = onItemCallback
    }

    inner class ArtikelViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArtikelViewHolder (
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount() = listArtikel.size
    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener { onItemCalBack?.onItemClick(data)
        }
    }
}