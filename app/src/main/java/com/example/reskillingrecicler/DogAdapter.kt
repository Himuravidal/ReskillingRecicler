package com.example.reskillingrecicler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.url_item_list.view.*

class DogAdapter(val callback: PassData) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private var dogUrlList = emptyList<String>()

    fun updateAdapter(list: List<String>) {
        dogUrlList = list
        notifyDataSetChanged()
    }

    inner class DogViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {
        val itemImage = mItemView.imageDog
        val click = mItemView.setOnClickListener {
            callback.passTheUrl(dogUrlList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.url_item_list, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val text = dogUrlList[position]
        Log.d("ADAPTER", text)
        //Glide
        Glide.with(holder.itemView.context).load(text).into(holder.itemImage)

    }

    override fun getItemCount() = dogUrlList.size


    interface PassData {
        fun passTheUrl(url : String)
    }

}