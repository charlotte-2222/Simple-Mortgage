package com.example.charlotte_childers_cpt_188_test_3

// Charlotte Childers CPT 188 Test 3
// 7/19/2022

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var loan: EditText
    lateinit var calculate: Button
    lateinit var monthlyPayment: TextView
    lateinit var buttoRate: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loan = findViewById(R.id.loan_amount)
        calculate = findViewById(R.id.buttonCalculate)
        monthlyPayment = findViewById(R.id.resultofMonthlyPayment)
        buttoRate=findViewById<Button>(R.id.buttonRateThing)

        val text = "There was an error in your computations!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)


        loan.onFocusChangeListener=View.OnFocusChangeListener{
            v,hasFocus ->
            if(hasFocus){
                loan.setText("")
            }
            else{
                loan.setText("Enter Loan")
            }
        }

        calculate.setOnClickListener{
            try{
                val monthlyPayLoan = ((loan.text.toString().toDouble() * 0.03)+ loan.text.toString().toDouble())/360
                val formattedMonthlyPayment = String.format("%.2f", monthlyPayLoan)
                monthlyPayment.text = "Monthly Payment: $$formattedMonthlyPayment /month"

            }catch (e: Exception){
                toast.show()//display error message
            }finally {
                closeKeyBoard()//close keyboard
            }
        }

        buttoRate.setOnClickListener{
           val intent = Intent(this, Second::class.java)
            startActivity(intent)

        }


    }
    // closes the keyboard when the button is pressed
    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}