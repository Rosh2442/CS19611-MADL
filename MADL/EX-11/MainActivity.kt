package org.rajalakshmi.myapplication

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.EditText
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
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_PHONE_STATE),REQUEST_PERMISSION_CODE)
        }
        val  etNetOpName:EditText=findViewById(R.id.etNwOpName)
        val  etCountryISO:EditText=findViewById(R.id.etCountryISO)
        val  etPhoneType:EditText=findViewById(R.id.etPhoneType)
        val  etSIMState:EditText=findViewById(R.id.etSIMState)
        val  etNetworkType:EditText=findViewById(R.id.etNetworkType)
        val btGetTelSer : Button = findViewById(R.id.btGetTelSer)

   val telephonyManager=getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        btGetTelSer.setOnClickListener{
            etNetOpName.setText(telephonyManager.networkOperatorName)
            etCountryISO.setText(telephonyManager.networkCountryIso)
            val phoneType = when(telephonyManager.phoneType){
                TelephonyManager.PHONE_TYPE_CDMA->"CDMA"
                TelephonyManager.PHONE_TYPE_GSM->"GSM"
                else ->"Others"
            }
            etPhoneType.setText(phoneType)
            val simState = when(telephonyManager.phoneType){
                TelephonyManager.SIM_STATE_ABSENT->"Absent"
                TelephonyManager.SIM_STATE_READY->"Ready"
                else ->"Others"
            }
            etSIMState.setText(simState)
            val networkType = when(telephonyManager.networkType){
                TelephonyManager.NETWORK_TYPE_LTE->"4G"
                TelephonyManager.NETWORK_TYPE_NR->"5G"
                else ->"Others"
            }
            etNetworkType.setText(networkType)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
