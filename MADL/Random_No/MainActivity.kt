package org.rajalakshmi.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val Start=findViewById<EditText>(R.id.etStartrange)
        val End=findViewById<EditText>(R.id.etEndrange)
        val btcalculate=findViewById<Button>(R.id.btGenerate)
        val resulttv=findViewById<TextView>(R.id.tvResult)

        btcalculate.setOnClickListener{
            var result=0;
            val start=Start.text.toString().toInt();
            val end=End.text.toString().toInt();
            result= Random.nextInt(start,end+1)
            resulttv.text="The Random number is :"+result
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
