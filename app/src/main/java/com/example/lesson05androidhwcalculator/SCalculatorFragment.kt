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

        with(binding) {

            displayField.text = "0"
            var string = ""

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
                string = ""
                displayField.text = "0"
            }
            buttonDel.setOnClickListener {
                string = if (string.length != 0) {
                    string.dropLast(1)
                } else {

                }
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    open class GetString() {
//
//        private var string: String? = null
//        fun read(): List<String> {
//
//        }
//    }
}


//
//    println("enter an arithmetic expression without brackets then press 'enter': ")
//    private var string: String? = readLine()
//    string = string ?: ""
//    string = string.replace("""\s+""".toRegex(), "") //all spaces are removed
//    val operands = mutableListOf<String>()
//    if (string.isNotBlank()) {
//        val regex = Regex("""-?\d+(\.\d+)?[*/\-+]?""")
//        regex.findAll(string).forEach {
//            operands.add(it.value)
//        }
//    }
//    operands[operands.size - 1] = operands.last().replace("""[*/\-+]?$""".toRegex(), "")
//    //removing the last symbol of the last operand if action
//    return operands
//}