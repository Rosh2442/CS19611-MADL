package org.rajalakshmi.sqlite
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
class UsersDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,
null, DATABASE_VERSION) {
override fun onCreate(db: SQLiteDatabase?) {
db?.execSQL(SQL_CREATE_ENTRIES)
}
override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion:
Int) {
db?.execSQL(SQL_DELETE_ENTRIES)
onCreate(db)
}
@Throws(SQLiteConstraintException::class)
fun insertUser(user: UserModel): Boolean {
// Gets the data repository in write mode
val db = writableDatabase
// Create a new map of values, where column names are the keys
val values = ContentValues()
values.put(DBContract.UserEntry.COLUMN_REGISTER_NUMBER,
user.registernumber)
values.put(DBContract.UserEntry.COLUMN_NAME, user.name)
values.put(DBContract.UserEntry.COLUMN_CGPA, user.cgpa)
// Insert the new row, returning the primary key value of the new row
val newRowId = db.insert(DBContract.UserEntry.TABLE_NAME, null, values)
return true
}
@SuppressLint("Range")
fun readUser(registerNumber : String): ArrayList<UserModel> {
val users = ArrayList<UserModel>()
val db = writableDatabase
var cursor: Cursor? = null
try {
cursor = db.rawQuery("select * from " +
DBContract.UserEntry.TABLE_NAME + " WHERE " +
DBContract.UserEntry.COLUMN_REGISTER_NUMBER + " = '" + registerNumber + "'",
null)
}
catch (e: SQLiteException) {
db.execSQL(SQL_CREATE_ENTRIES)
return ArrayList()
}
var name : String
var cgpa : String
if (cursor!!.moveToFirst()) {

42 Dept. of Computer Science and Engineering | Rajalakshmi Engineering College
while (cursor.isAfterLast == false) {
name =
cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
cgpa =
cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CGPA))
users.add(UserModel(registerNumber, name, cgpa))
cursor.moveToNext()
}
}
return users
}
@Throws(SQLiteConstraintException::class)
fun deleteUser(userid: String): Boolean {
val db = writableDatabase
val selection = DBContract.UserEntry.COLUMN_REGISTER_NUMBER + " LIKE ?"
val selectionArgs = arrayOf(userid)
db.delete(DBContract.UserEntry.TABLE_NAME, selection, selectionArgs)
return true
}
companion object {
// If you change the database schema, you must increment the database
version.
val DATABASE_VERSION = 1
val DATABASE_NAME = "FeedReader.db"
private val SQL_CREATE_ENTRIES =
"CREATE TABLE " + DBContract.UserEntry.TABLE_NAME + " (" +
DBContract.UserEntry.COLUMN_REGISTER_NUMBER + " TEXT PRIMARY
KEY," +
DBContract.UserEntry.COLUMN_NAME + " TEXT," +
DBContract.UserEntry.COLUMN_CGPA + " TEXT)"
private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
DBContract.UserEntry.TABLE_NAME
}
}
