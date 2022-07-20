package com.example.charlotte_childers_cpt_188_test_3

// Charlotte Childers CPT 188 Test 3
// 7/19/2022

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Second : AppCompatActivity() {

    lateinit var morgage: EditText
    lateinit var calculate: Button
    lateinit var years: EditText
    lateinit var interest: EditText
    lateinit var monthly: TextView

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        morgage=findViewById(R.id.MorgageAmount)
        calculate= findViewById(R.id.buttonCalculate2)
        years = findViewById(R.id.years)
        interest = findViewById(R.id.interestRate)
        monthly = findViewById(R.id.resultOfMorg)

        val text = "There was an error in your computations!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)

        calculate.setOnClickListener {
            try {
                val loanAmount = morgage.text.toString().toDouble()
                val interestRate = interest.text.toString().toDouble()
                val years = years.text.toString().toDouble()
                val payment = ((loanAmount * interestRate / 100) + loanAmount) / (years * 12)
                monthly.text = "Monthly Payment: $%.2f".format(payment) + "/month"
            }catch (e: Exception){
                toast.show()
            }finally {
                closeKeyBoard()
            }
        }

    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

}




