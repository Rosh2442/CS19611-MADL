package org.rajalakshmi.sqlite
import android.provider.BaseColumns
object DBContract {
class UserEntry : BaseColumns {
companion object {
val TABLE_NAME = "students"
val COLUMN_REGISTER_NUMBER = "registernumber"
val COLUMN_NAME = "name"
val COLUMN_CGPA = "cgpa"
}
}
}
