package com.raykimjr.cs571.basiccalculator

import androidx.lifecycle.ViewModel
import kotlin.math.*

class CalculatorViewModel : ViewModel() {
    var numStr : String = "0"
    var operation : String = ""
    var firstOperand : String = ""
    var secondOperand : String = ""
    var backingStore : String = ""

    fun initialize() {
        numStr = "0"
        operation = ""
        firstOperand = ""
        secondOperand = ""
        backingStore = "0"
    }

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

    fun addNonZeroNumber(num : String) {
        if (backingStore == "0") {
            backingStore = num
        } else if (backingStore.length < 9){
            backingStore += num
        }

        numStr = backingStore
    }

    fun addZero() {
        if (backingStore != "0") backingStore += "0"

        numStr = backingStore
    }

    fun addDec() {
        if (backingStore.indexOf(".") == -1) {
            backingStore += "."
        }

        numStr = backingStore
    }

    fun addPlusMinus() {
        if (backingStore != "0") {
            if (backingStore.indexOf("-") == -1) {
                backingStore = "-" + backingStore
            } else {
                backingStore = backingStore.drop(1)
            }
        }

        numStr = backingStore
    }

    fun makePercent() {
        if (backingStore != "0"){
            backingStore = (backingStore.toDouble() / 100.0).toString()
        }

        numStr = backingStore
    }

    fun setOper(oper : String) {
        if (operation == "" && oper != "=") {
            operation = oper
            firstOperand = backingStore
            backingStore = "0"
        } else if (operation != "" && oper == "=") {
            secondOperand = backingStore
            val result = performOperation()
            numStr = result.toString()
            operation = ""
            firstOperand = ""
            secondOperand = ""
            backingStore = "0"
        } else if (operation != "" && oper != "=") {
            secondOperand = backingStore
            val result = performOperation()
            firstOperand = result.toString()
            operation = oper
            numStr = firstOperand
            backingStore = "0"
        }
    }


}