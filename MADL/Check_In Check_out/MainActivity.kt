package org.rajalakshmi.myapplication

import android.os.Bundle
import android.widget.Button
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

        var count=0;
        val resultView=findViewById<TextView>(R.id.textView)
        val addbt=findViewById<Button>(R.id.addbt)
        val subbt=findViewById<Button>(R.id.subbt)
        resultView.text=count.toString();
        addbt.setOnClickListener{
            count+=1;
            resultView.text=count.toString()
        }
        subbt.setOnClickListener{
            count-=1;
            resultView.text=count.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
