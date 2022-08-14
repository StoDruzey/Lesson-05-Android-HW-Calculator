package com.example.lesson05androidhwcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

val historyList = List(20) {
    "history note $it"
}

class MainActivity : AppCompatActivity(R.layout.activity_main) {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(SCalculatorFragment())
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

fun Fragment.pushFragmentHist(historyList: MutableList<String>) {
    (requireActivity() as MainActivity).addFragment(HistoryFragment(historyList))
}

fun Fragment.pushFragmentCalc() {
    (requireActivity() as MainActivity).addFragment(SCalculatorFragment())
}