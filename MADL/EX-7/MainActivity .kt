package org.rajalakshmi.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etRollNo=findViewById<EditText>(R.id.etRollNo);
        val etName=findViewById<EditText>(R.id.etName);
        val etCgpa=findViewById<EditText>(R.id.etCgpa);
        val btsave=findViewById<Button>(R.id.btsave);
        val btload=findViewById<Button>(R.id.btload);
        btsave.setOnClickListener{
            val roll =etRollNo.text.toString();
            val name = etName.text.toString();
            val cgpa=etCgpa.text.toString();
            val file= File(getExternalFilesDir(null),"student.txt")
            val writer=FileWriter(file)
            writer.write("$roll\n$name\n$cgpa")
            writer.close()
            etRollNo.text.clear()
            etName.text.clear()
            etCgpa.text.clear()
            Toast.makeText(this,"save successfully!",Toast.LENGTH_LONG).show()

        }
        btload.setOnClickListener{
            val file= File(getExternalFilesDir(null),"student.txt")
            val reader = BufferedReader(FileReader(file))
            val rollNo=reader.readLine()
            val name=reader.readLine()
            val cgpa=reader.readLine()
            etRollNo.setText(rollNo)
            etName.setText(name)
            etCgpa.setText(cgpa)
            reader.close()
            Toast.makeText(this,"loaded successful!",Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
