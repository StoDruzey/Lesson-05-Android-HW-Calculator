package com.example.lesson05androidhwcalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson05androidhwcalculator.databinding.HistoryNotesBinding

class HistoryAdapter(
    private val historyList: List<String>,
    private val historyClick: (String) -> Unit
) : RecyclerView.Adapter<HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HistoryViewHolder(
            binding = HistoryNotesBinding.inflate(layoutInflater, parent, false),
            historyClick = historyClick
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}

class HistoryViewHolder(
    private val binding: HistoryNotesBinding,
    private val historyClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.historyNote.text = item
        binding.root.setOnClickListener {
            historyClick(item)
        }
    }
}