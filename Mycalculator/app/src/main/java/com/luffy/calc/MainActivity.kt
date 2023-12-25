package com.luffy.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var inputEditText: EditText
    lateinit var outputEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        val button_c = findViewById<Button>(R.id.button_c)
        val button_1 = findViewById<Button>(R.id.button_1)
        val button_2 = findViewById<Button>(R.id.button_2)
        val button_3 = findViewById<Button>(R.id.button_3)
        val button_4 = findViewById<Button>(R.id.button_4)
        val button_5 = findViewById<Button>(R.id.button_5)
        val button_6 = findViewById<Button>(R.id.button_6)
        val button_7 = findViewById<Button>(R.id.button_7)
        val button_8 = findViewById<Button>(R.id.button_8)
        val button_9 = findViewById<Button>(R.id.button_9)
        val button_0 = findViewById<Button>(R.id.button_0)
        val button_equal = findViewById<Button>(R.id.button_equal)
        val button_plus = findViewById<Button>(R.id.button_plus)
        val button_min = findViewById<Button>(R.id.button_min)
        val button_x = findViewById<Button>(R.id.button_x)
        val button_div = findViewById<Button>(R.id.button_div)
        val button_dot = findViewById<Button>(R.id.button_dot)
        val button_del = findViewById<Button>(R.id.button_del)
        val button_per = findViewById<Button>(R.id.button_per)

        val clickListener = View.OnClickListener {view->
            val btn = view as Button
            var s = btn.text.toString()
            var oldInputText = inputEditText.text.toString()
            val lastChar = oldInputText.lastOrNull().toString()
            if(lastChar!=null && (lastChar.equals("+") || lastChar.equals("-") || lastChar.equals("*") || lastChar.equals("/")) && (s.equals("="))){
                oldInputText=oldInputText.dropLast(1)
                inputEditText.setText(oldInputText)
            }
            if(s.equals("C")){
                inputEditText.setText("")
                outputEditText.setText("")
            }else if(s.equals("DEL")){
                oldInputText = oldInputText.dropLast(1)
               inputEditText.setText(oldInputText)

            }else if(s.equals("X")){
                inputEditText.setText(oldInputText + "*")
            }
            else if(s.equals("=")){
                val res = ExpressionBuilder(oldInputText).build().evaluate()
                outputEditText.setText(res.toString())
            }else{
                inputEditText.setText(oldInputText + s)
            }



        }

        button_1.setOnClickListener(clickListener)
        button_2.setOnClickListener(clickListener)
        button_3.setOnClickListener(clickListener)
        button_4.setOnClickListener(clickListener)
        button_5.setOnClickListener(clickListener)
        button_6.setOnClickListener(clickListener)
        button_7.setOnClickListener(clickListener)
        button_8.setOnClickListener(clickListener)
        button_9.setOnClickListener(clickListener)
        button_0.setOnClickListener(clickListener)
        button_plus.setOnClickListener(clickListener)
        button_min.setOnClickListener(clickListener)
        button_x.setOnClickListener(clickListener)
        button_div.setOnClickListener(clickListener)
        button_dot.setOnClickListener(clickListener)
        button_equal.setOnClickListener(clickListener)
        button_per.setOnClickListener(clickListener)
        button_del.setOnClickListener(clickListener)
        button_c.setOnClickListener(clickListener)

    }

    private fun initializeViews() {
       inputEditText = findViewById(R.id.input_text)
        outputEditText = findViewById(R.id.output_text)
    }

}