package com.example.lesson05androidhwcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson05androidhwcalculator.databinding.FragmentHistoryBinding

class HistoryFragment() : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHistoryBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val historyList = requireArguments().getStringArrayList(KEY_HISTORY_LIST)

            recyclerviewHistory.layoutManager = LinearLayoutManager(view.context)
            recyclerviewHistory.adapter = HistoryAdapter(historyList) {
                pushFragmentCalc()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_HISTORY_LIST = "key_history_list"
        fun getInstance(historyList: ArrayList<String>): HistoryFragment {
            return HistoryFragment().apply {
                arguments = bundleOf(
                    KEY_HISTORY_LIST to historyList
                )
            }
        }
    }
}