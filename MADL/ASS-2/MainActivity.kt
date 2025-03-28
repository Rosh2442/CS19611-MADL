package org.rajalakshmi.bookapp

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
        
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val etPublisher = findViewById<EditText>(R.id.etPublisher)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        
        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()
            val publisher = etPublisher.text.toString()
            val price = etPrice.text.toString()
            
            val file = File(getExternalFilesDir(null), "book_details.txt")
            val writer = FileWriter(file)
            writer.write("$title\n$author\n$publisher\n$price")
            writer.close()
            
            etTitle.text.clear()
            etAuthor.text.clear()
            etPublisher.text.clear()
            etPrice.text.clear()
            
            Toast.makeText(this, "Book details saved successfully!", Toast.LENGTH_LONG).show()
        }
        
        btnLoad.setOnClickListener {
            val file = File(getExternalFilesDir(null), "book_details.txt")
            if (file.exists()) {
                val reader = BufferedReader(FileReader(file))
                val title = reader.readLine()
                val author = reader.readLine()
                val publisher = reader.readLine()
                val price = reader.readLine()
                
                etTitle.setText(title)
                etAuthor.setText(author)
                etPublisher.setText(publisher)
                etPrice.setText(price)
                
                reader.close()
                Toast.makeText(this, "Book details loaded successfully!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No saved data found!", Toast.LENGTH_LONG).show()
            }
        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
