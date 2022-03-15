package com.raykimjr.cs571.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.raykimjr.cs571.basiccalculator.databinding.ActivityMainBinding
import kotlin.math.ceil
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    private val model : CalculatorViewModel by viewModels()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model.numStr = "0"

        binding.clearButton.setOnClickListener { view: View ->
            model.numStr = "0"
            model.operation = ""
            model.firstOperand = ""
            model.secondOperand = ""
            binding.resultText.text = (model.numStr)
        }

        binding.zeroButton.setOnClickListener { view: View ->
            if (model.numStr != "0" && model.numStr.length < 9)
            {
                model.numStr += "0"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.oneButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "1"
            } else if (model.numStr.length < 9){
                model.numStr += "1"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.twoButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "2"
            } else if (model.numStr.length < 9){
                model.numStr += "2"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.threeButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "3"
            } else if (model.numStr.length < 9){
                model.numStr += "3"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.fourButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "4"
            } else if (model.numStr.length < 9){
                model.numStr += "4"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.fiveButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "5"
            } else if (model.numStr.length < 9){
                model.numStr += "5"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.sixButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "6"
            } else if (model.numStr.length < 9){
                model.numStr += "6"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.sevenButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "7"
            } else if (model.numStr.length < 9){
                model.numStr += "7"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.eightButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "8"
            } else if (model.numStr.length < 9){
                model.numStr += "8"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.nineButton.setOnClickListener { view: View ->
            if (model.numStr == "0") {
                model.numStr = "9"
            } else if (model.numStr.length < 9){
                model.numStr += "9"
            }

            binding.resultText.text = (model.numStr)
        }

        binding.decButton.setOnClickListener { view: View ->
            if (model.numStr.indexOf(".") == -1) {
                model.numStr += "."
            }

            binding.resultText.text = (model.numStr)
        }

        binding.plusminusButton.setOnClickListener { view: View ->
            if (model.numStr != "0") {
                if (model.numStr.indexOf("-") == -1) {
                    model.numStr = "-" + model.numStr
                } else {
                    model.numStr = model.numStr.drop(1)
                }
            }


            binding.resultText.text = model.numStr
        }

        binding.percentButton.setOnClickListener { view: View ->
            if (model.numStr != "0"){
                model.numStr = (model.numStr.toDouble() / 100.0).toString()
            }

            binding.resultText.text = model.numStr
        }

        binding.addButton.setOnClickListener { view: View ->
            if (model.operation == "") {
                model.operation = "+"
                model.firstOperand = model.numStr
                model.numStr = "0"
                //binding.resultText.setText(model.numStr)
            } else {
                model.secondOperand = model.numStr
                val result = model.performOperation()
                model.firstOperand = result.toString()
                binding.resultText.text = model.firstOperand
                model.operation = "+"
                model.numStr = "0"
                //binding.resultText.setText(model.numStr)
            }
        }

        binding.subButton.setOnClickListener { view: View ->
            if (model.operation == "") {
                model.operation = "-"
                model.firstOperand = model.numStr
                model.numStr = "0"
            } else {
                model.secondOperand = model.numStr
                val result = model.performOperation()
                model.firstOperand = result.toString()
                binding.resultText.text = model.firstOperand
                model.operation = "-"
                model.numStr = "0"

            }
        }

        binding.multButton.setOnClickListener { view: View ->
            if (model.operation == "") {
                model.operation = "*"
                model.firstOperand = model.numStr
                model.numStr = "0"
            } else {
                model.secondOperand = model.numStr
                val result = model.performOperation()
                model.firstOperand = result.toString()
                binding.resultText.text = model.firstOperand
                model.operation = "*"
                model.numStr = "0"

            }
        }

        binding.divideButton.setOnClickListener { view: View ->
            if (model.operation == "") {
                model.operation = "/"
                model.firstOperand = model.numStr
                model.numStr = "0"
            } else {
                model.secondOperand = model.numStr
                val result = model.performOperation()
                model.firstOperand = result.toString()
                binding.resultText.text = model.firstOperand
                model.operation = "/"
                model.numStr = "0"

            }
        }

        binding.equalButton.setOnClickListener { view: View ->
            if (model.operation == "") {

            } else {
                model.secondOperand = model.numStr
                val result = model.performOperation()
                model.numStr = result.toString()
                model.operation = ""
                model.firstOperand = ""
                model.secondOperand = ""
                binding.resultText.setText(model.numStr)
                model.numStr = "0"
            }
        }
    }
}