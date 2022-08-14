package com.example.lesson05androidhwcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson05androidhwcalculator.databinding.FragmentScalculatorBinding

class SCalculatorFragment : Fragment() {
    private var _binding: FragmentScalculatorBinding? = null
    private val binding get() = requireNotNull(_binding)

    val historyList = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentScalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val historyList = mutableListOf<String>()
//        var key = 1

        with(binding) {

            var string = ""
            fun init() {
                displayField.text = "0"
                string = ""
                resultField.text = string
            }
            init()
            button0.setOnClickListener {
                string += "0"
                displayField.text = string
            }
            button1.setOnClickListener {
                string += "1"
                displayField.text = string
            }
            button2.setOnClickListener {
                string += "2"
                displayField.text = string
            }
            button3.setOnClickListener {
                string += "3"
                displayField.text = string
            }
            button4.setOnClickListener {
                string += "4"
                displayField.text = string
            }
            button5.setOnClickListener {
                string += "5"
                displayField.text = string
            }
            button6.setOnClickListener {
                string += "6"
                displayField.text = string
            }
            button7.setOnClickListener {
                string += "7"
                displayField.text = string
            }
            button8.setOnClickListener {
                string += "8"
                displayField.text = string
            }
            button9.setOnClickListener {
                string += "9"
                displayField.text = string
            }
            buttonDot.setOnClickListener {
                string += "."
                displayField.text = string
            }
            buttonC.setOnClickListener {
                init()
            }
            buttonDel.setOnClickListener {
                if (string.length != 0) {
                    string = string.dropLast(1)
                    displayField.text = string
                } else {
                    displayField.text = "0"
                }
            }
            buttonDiv.setOnClickListener {
                string += "/"
                displayField.text = string
            }
            buttonMult.setOnClickListener {
                string += "*"
                displayField.text = string
            }
            buttonMinus.setOnClickListener {
                string += "-"
                displayField.text = string
            }
            buttonPlus.setOnClickListener {
                string += "+"
                displayField.text = string
            }
            buttonEquals.setOnClickListener {
                resultField.text = Calculator.result(string)
                historyList.add("$string=$resultField.text")
            }
            buttonHist.setOnClickListener {
                pushFragmentHist(temporaryList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    companion object {
//        private const val
//        fun getInstance(historyList: List<String>): SCalculatorFragment {
//            return SCalculatorFragment().apply {
//
//            }
//        }
//    }
}

class Calculator() {
    companion object {
        fun result(string: String): String {
            val operands = mutableListOf<String>()
            if (string.isNotBlank()) {
                val regex = Regex("""-?\d+(\.\d+)?[*/\-+]?""")
                regex.findAll(string).forEach {
                    operands.add(it.value)
                }
            }
            //removing the last symbol of the last operand if action
            operands[operands.size - 1] = operands.last().replace("""[*/\-+]?$""".toRegex(), "")
            //perform actions:
            var i = 0
            var size = operands.size
            //first multiply and divide
            while (i < (size - 1)) {
                val num1 = operands[i].dropLast(1).toDouble()
                var num2: Double
                var act2: String
                if (i == size - 2) {
                    num2 = operands[i + 1].toDouble()
                    act2 = ""
                } else {
                    num2 = operands[i + 1].dropLast(1).toDouble()
                    act2 = operands[i + 1].takeLast(1)
                }
                when (operands[i].takeLast(1)) {
                    "*" -> {
                        operands[i + 1] = (num1 * num2).toString() + act2
                        operands.removeAt(i)
                        --size
                        --i
                    }
                    "/" -> {
                        if (num2 == 0.0) {
                            return "error"
                        }
                        operands[i + 1] = (num1 / num2).toString() + act2
                        operands.removeAt(i)
                        --size
                        --i
                    }
                }
                ++i
            }
            //then add and subtract
            size = operands.size
            i = 0
            while (i < (size - 1)) {
                val num1 = operands[i].dropLast(1).toDouble()
                var num2: Double
                var act2: String
                if (i == size - 2) {
                    num2 = operands[i + 1].toDouble()
                    act2 = ""
                } else {
                    num2 = operands[i + 1].dropLast(1).toDouble()
                    act2 = operands[i + 1].takeLast(1)
                }
                when (operands[i].takeLast(1)) {
                    "+" -> {
                        operands[i + 1] = (num1 + num2).toString() + act2
                        operands.removeAt(i)
                        --size
                        --i
                    }
                    "-" -> {
                        operands[i + 1] = (num1 - num2).toString() + act2
                        operands.removeAt(i)
                        --size
                        --i
                    }
                }
                ++i
            }
            return operands[0]
        }
    }
}
