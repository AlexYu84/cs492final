package com.example.cs492final.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs492final.R
import com.example.cs492final.data.SearchItem

class SearchListAdapter(private val onSearchItemClick: (SearchItem) -> Unit)
    : RecyclerView.Adapter<SearchListAdapter.SearchItemViewHolder>() {
    var searchItemList = listOf<SearchItem>()

    fun updateItemList(newItemList: List<SearchItem>?) {
        searchItemList = newItemList ?: listOf()
        notifyDataSetChanged()
    }

    override fun getItemCount() = searchItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_list_item, parent, false)
        return SearchItemViewHolder(itemView, onSearchItemClick)
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.bind(searchItemList[position])
    }

   class SearchItemViewHolder(itemView: View, val onClick: (SearchItem) -> Unit)  : RecyclerView.ViewHolder(itemView) {
       private var currentItem: SearchItem? = null

       init {
           itemView.setOnClickListener {
               currentItem?.let(onClick)
           }
       }

       fun bind(item: SearchItem) {
           currentItem = item
           TODO("bind item attributes to views")
       }
   }
}