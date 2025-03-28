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
        val etEmpId=findViewById<EditText>(R.id.EmpId);
        val etName=findViewById<EditText>(R.id.etName);
        val etSalary=findViewById<EditText>(R.id.etSalary);
        val btsave=findViewById<Button>(R.id.btsave);
        val btload=findViewById<Button>(R.id.btload);
        btsave.setOnClickListener{
            val id =etEmpId.text.toString();
            val name = etName.text.toString();
            val salary=etSalary.text.toString();
            val file= File(getExternalFilesDir(null),"employee.txt")
            val writer=FileWriter(file)
            writer.write("$id\n$name\n$salary")
            writer.close()
            etEmpId.text.clear()
            etName.text.clear()
            etSalary.text.clear()
            Toast.makeText(this,"save successfully!",Toast.LENGTH_LONG).show()

        }
        btload.setOnClickListener{
            val file= File(getExternalFilesDir(null),"employee.txt")
            val reader = BufferedReader(FileReader(file))
            val EmpId=reader.readLine()
            val name=reader.readLine()
            val Salary=reader.readLine()
            etEmpId.setText(id)
            etName.setText(name)
            etSalary.setText(salary)
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
