package org.rajalakshmi.myapplication

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
        var result = 0.0
        val etTextView=findViewById<EditText>(R.id.etTextedit)
        val ctof=findViewById<Button>(R.id.ctof)
        val ftoc=findViewById<Button>(R.id.ftoc)
        val resultv=findViewById<TextView>(R.id.textView)

        ctof.setOnClickListener{
            val input = etTextView.text.toString().toDouble()
           // if(input!=null)
            result= (input*(9.0/5.0)+32.0)

            resultv.text="the respective farenheit is:"+result.toString()
        }
        ftoc.setOnClickListener{
            val input = etTextView.text.toString().toDouble()
            // if(input!=null)
            result= (input-32.0*(5.0/9.0))

            resultv.text="the respective celsius is:"+result.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
