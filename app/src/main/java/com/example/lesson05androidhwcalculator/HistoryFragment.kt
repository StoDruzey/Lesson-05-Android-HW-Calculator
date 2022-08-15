package com.example.lesson05androidhwcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson05androidhwcalculator.databinding.FragmentHistoryBinding
import java.util.ArrayList

class HistoryFragment(val historyList: List<String>) : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = requireNotNull(_binding)

//    val historyList: List<String>? = requireArguments().getStringArrayList(KEY_HISTORY_LIST)

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
//    companion object {
//        private const val KEY_HISTORY_LIST = "key_history_list"
//        fun getInstance(historyList: List<String>): SCalculatorFragment {
//            return SCalculatorFragment().apply {
//                arguments = bundleOf(
//                    KEY_HISTORY_LIST to historyList
//                )
//            }
//        }
//    }
}