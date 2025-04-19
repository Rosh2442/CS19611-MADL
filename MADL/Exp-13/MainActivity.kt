package com.example.sms

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val REQUEST_PERMISSION_CODE=1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etPhoneNumber:EditText=findViewById(R.id.etPhoneNumber)
        val etMsg:EditText=findViewById(R.id.etMsg)
        val btSend : Button =findViewById(R.id.btSend)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS)!=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.SEND_SMS),REQUEST_PERMISSION_CODE)
        }
        btSend.setOnClickListener {
            val phoneNo=etPhoneNumber.text.toString()
            val msg=etMsg.text.toString()
           val smsManager:SmsManager
           smsManager=SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo,null,msg,null,null)
            Toast.makeText(this,"Sent Successfully..!",Toast.LENGTH_LONG).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
