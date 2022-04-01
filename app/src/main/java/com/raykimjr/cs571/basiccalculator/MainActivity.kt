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
        model.initialize()
        updateUI()

        binding.clearButton.setOnClickListener { view: View ->
            model.initialize()
            updateUI()
        }

        binding.zeroButton.setOnClickListener { view: View ->
            model.addZero()

            updateUI()
        }

        binding.oneButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("1")

            updateUI()
        }

        binding.twoButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("2")

            updateUI()
        }

        binding.threeButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("3")

            updateUI()
        }

        binding.fourButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("4")

            updateUI()
        }

        binding.fiveButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("5")

            updateUI()
        }

        binding.sixButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("6")

            updateUI()
        }

        binding.sevenButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("7")

            updateUI()
        }

        binding.eightButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("8")

            updateUI()
        }

        binding.nineButton.setOnClickListener { view: View ->
            model.addNonZeroNumber("9")

            updateUI()
        }

        binding.decButton.setOnClickListener { view: View ->
            model.addDec()

            updateUI()
        }

        binding.plusminusButton.setOnClickListener { view: View ->
            model.addPlusMinus()

            updateUI()
        }

        binding.percentButton.setOnClickListener { view: View ->
            model.makePercent()

            updateUI()
        }

        binding.addButton.setOnClickListener { view: View ->
            model.setOper("+")
            updateUI()
        }

        binding.subButton.setOnClickListener { view: View ->
            model.setOper("-")
            updateUI()
        }

        binding.multButton.setOnClickListener { view: View ->
            model.setOper("*")
            updateUI()
        }

        binding.divideButton.setOnClickListener { view: View ->
            model.setOper("/")
            updateUI()
        }

        binding.equalButton.setOnClickListener { view: View ->
            model.setOper("=")
            updateUI()
        }
    }

    fun updateUI() {
        binding.resultText.text = model.numStr
    }
}