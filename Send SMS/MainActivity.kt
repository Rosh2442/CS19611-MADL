package org.rajalakshmi.myapplication

import android.app.Activity
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
    private val REQUEST_PERMISSION_CODE=101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val phonenum:EditText=findViewById(R.id.etPhoneNum)
        val message:EditText=findViewById(R.id.etMessage)

        val send:Button=findViewById(R.id.btSend)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.SEND_SMS),REQUEST_PERMISSION_CODE)
        }
        send.setOnClickListener{
            val phone=phonenum.text.toString()
            val msg=message.text.toString()
            val smsManager:SmsManager
            smsManager=SmsManager.getDefault()
            smsManager.sendTextMessage(phone,null,msg,null,null)
            Toast.makeText(this,"Sent Successfully...!",Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
