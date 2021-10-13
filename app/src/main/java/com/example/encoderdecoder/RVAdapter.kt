package com.example.encoderdecoder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encoderdecoder.databinding.ItemRowBinding


class RVAdapter(private val texts: ArrayList<ArrayList<String>>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val text = texts[position][0]
        val enDe = texts[position][1] //encoded and decoded text

        holder.binding.apply {
            tvtext.text = text
            tvEnDe.text = enDe
        }

    }

    override fun getItemCount() = texts.size
}
