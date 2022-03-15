package com.raykimjr.cs571.basiccalculator

import androidx.lifecycle.ViewModel
import kotlin.math.*

class CalculatorViewModel : ViewModel() {
    var numStr : String = "0"
    var operation : String = ""
    var firstOperand : String = ""
    var secondOperand : String = ""

    fun performOperation() : Any? {
        val firstOperandVal = firstOperand.toDouble()
        val secondOperandVal = secondOperand.toDouble()

        val result = when (operation) {
            "+" -> firstOperandVal + secondOperandVal
            "-" -> firstOperandVal - secondOperandVal
            "*" -> firstOperandVal * secondOperandVal
            "/" -> firstOperandVal / secondOperandVal
            else -> return null
        }

        if (floor(result) == ceil(result)) {
            return floor(result).toInt().toString()
        } else {
            return result.toString()
        }





    }
}