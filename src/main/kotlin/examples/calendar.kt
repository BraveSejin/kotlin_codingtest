package examples


import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val sdf = SimpleDateFormat("yyyyMMdd")
    val date1 = sdf.parse("20001001")
    val date2 = sdf.parse("19970416")
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = date1
    cal2.time = date2
    println("${cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)}")
}