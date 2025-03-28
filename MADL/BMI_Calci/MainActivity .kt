package org.rajalakshmi.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val Weight=findViewById<EditText>(R.id.etWeight)
        val Height=findViewById<EditText>(R.id.etHeight)
        val btcalculate=findViewById<Button>(R.id.btCalculate)
        val resulttv=findViewById<TextView>(R.id.tvResult)

        btcalculate.setOnClickListener{
            var result=0.0;
            val weight=Weight.text.toString().toDouble();
            val height=Height.text.toString().toDouble();
            result=weight/(height*height);
            resulttv.text="Your BMI is:"+result
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
