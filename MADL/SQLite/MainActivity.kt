package org.rajalakshmi.sqlite
import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
lateinit var usersDBHelper : UsersDBHelper
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
val etRegisterNumber : EditText = findViewById(R.id.etRegisterNumber)
val etName : EditText = findViewById(R.id.etName)
val etCGPA : EditText = findViewById(R.id.etCGPA)
val btAdd : Button = findViewById(R.id.btAdd)
val btView : Button = findViewById(R.id.btView)
val btModify : Button = findViewById(R.id.btModify)
val btDelete : Button = findViewById(R.id.btDelete)
val btClear : Button = findViewById(R.id.btClear)
usersDBHelper = UsersDBHelper(this)
btAdd.setOnClickListener {
val registerNumber : String = etRegisterNumber.text.toString()
val name : String = etName.text.toString()
val cgpa : String = etCGPA.text.toString()
var result = usersDBHelper.insertUser(UserModel(registernumber =
registerNumber, name = name, cgpa = cgpa))
etRegisterNumber.setText("")
etName.setText("")
etCGPA.setText("")
}
btView.setOnClickListener {
var users = usersDBHelper.readUser(etRegisterNumber.text.toString())
users.forEach {
etName.setText(it.name)
etCGPA.setText(it.cgpa)
}
}
btDelete.setOnClickListener {
var registerNumber = etRegisterNumber.text.toString()
val result = usersDBHelper.deleteUser(registerNumber)
if(result)
Toast.makeText(applicationContext, "User Deleted...!",
Toast.LENGTH_LONG).show()
}
btClear.setOnClickListener {
etRegisterNumber.setText("")
etName.setText("")
etCGPA.setText("")
}
}
}
