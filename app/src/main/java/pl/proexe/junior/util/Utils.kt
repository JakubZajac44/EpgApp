package pl.proexe.junior.util

import java.text.SimpleDateFormat
import java.util.*


private val time24Format = SimpleDateFormat("HH:mm")
private val ddMMYYYYFormat = SimpleDateFormat("dd-MM-yyyy")

fun convertDateToTimeStringFormat(date:Date):String = time24Format.format(date)

fun convertMillisecondToDateFormat(millisecond:Long):String = ddMMYYYYFormat.format(Date(millisecond))

