package pl.proexe.junior.util

import java.text.SimpleDateFormat
import java.util.*


private val time24Format = SimpleDateFormat("HH:mm")

fun convertDateToTimeStringFormat(date:Date):String = time24Format.format(date)

